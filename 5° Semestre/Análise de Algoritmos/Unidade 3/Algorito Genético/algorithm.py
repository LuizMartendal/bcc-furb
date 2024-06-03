import random
import string
from deap import base, creator, tools, algorithms

# Parâmetros do Algoritmo Genético
POPULATION_SIZE = 100
TARGET_STRING = input("Digite a string alvo: ")
GENE_LENGTH = len(TARGET_STRING)
GENERATIONS = 10000
MUTATION_RATE = 0.05
CROSSOVER_RATE = 0.7

# Função de aptidão (fitness function)
def evalFitness(individual):
    return sum(ind == tgt for ind, tgt in zip(individual, TARGET)),

# Configuração do DEAP
creator.create("FitnessMax", base.Fitness, weights=(1.0,))
creator.create("Individual", list, fitness=creator.FitnessMax)

toolbox = base.Toolbox()
toolbox.register("attr_char", random.choice, string.printable)
toolbox.register("individual", tools.initRepeat, creator.Individual, toolbox.attr_char, GENE_LENGTH)
toolbox.register("population", tools.initRepeat, list, toolbox.individual)

toolbox.register("mate", tools.cxTwoPoint)
toolbox.register("mutate", tools.mutUniformInt, low=0, up=len(string.printable)-1, indpb=MUTATION_RATE)
toolbox.register("select", tools.selTournament, tournsize=3)
toolbox.register("evaluate", evalFitness)

# Função de mutação personalizada para caracteres
def mutCustom(individual, indpb):
    for i in range(len(individual)):
        if random.random() < indpb:
            individual[i] = random.choice(string.printable)
    return individual,

toolbox.register("mutate", mutCustom, indpb=MUTATION_RATE)

def main():
    global TARGET, GENE_LENGTH

    TARGET = TARGET_STRING
    
    random.seed(64)
    
    # Criação da população inicial
    population = toolbox.population(n=POPULATION_SIZE)
    
    # Estatísticas
    stats = tools.Statistics(lambda ind: ind.fitness.values)
    stats.register("avg", lambda x: sum([i[0] for i in x]) / len(x))
    stats.register("max", lambda x: max([i[0] for i in x]))

    # Logbook para manter registro das informações
    logbook = tools.Logbook()
    logbook.header = ["gen", "nevals"] + (stats.fields if stats else [])

    # Avaliar a população inicial
    fitnesses = list(map(toolbox.evaluate, population))
    for ind, fit in zip(population, fitnesses):
        ind.fitness.values = fit

    record = stats.compile(population) if stats else {}
    logbook.record(gen=0, nevals=len(population), **record)
    print(logbook.stream)
    
    # Algoritmo Genético
    for gen in range(1, GENERATIONS + 1):
        offspring = toolbox.select(population, len(population))
        offspring = list(map(toolbox.clone, offspring))

        for child1, child2 in zip(offspring[::2], offspring[1::2]):
            if random.random() < CROSSOVER_RATE:
                toolbox.mate(child1, child2)
                del child1.fitness.values
                del child2.fitness.values

        for mutant in offspring:
            if random.random() < MUTATION_RATE:
                toolbox.mutate(mutant)
                del mutant.fitness.values

        invalid_ind = [ind for ind in offspring if not ind.fitness.valid]
        fitnesses = map(toolbox.evaluate, invalid_ind)
        for ind, fit in zip(invalid_ind, fitnesses):
            ind.fitness.values = fit

        population[:] = offspring

        record = stats.compile(population) if stats else {}
        logbook.record(gen=gen, nevals=len(invalid_ind), **record)
        print(logbook.stream)

        best_individual = tools.selBest(population, k=1)[0]
        print(f"Geração {gen}: Melhor Indivíduo = {''.join(best_individual)} com Fitness = {best_individual.fitness.values[0]}")

        if best_individual.fitness.values[0] == GENE_LENGTH:
            break

    # Melhor indivíduo final
    best_individual = tools.selBest(population, k=1)[0]
    print(f"Melhor indivíduo: {''.join(best_individual)} com fitness: {best_individual.fitness.values[0]}")

if __name__ == "__main__":
    main()
