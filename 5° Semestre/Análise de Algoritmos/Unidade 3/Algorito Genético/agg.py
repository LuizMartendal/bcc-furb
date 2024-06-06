import random
import string
from deap import base, creator, tools, algorithms
from fuzzywuzzy import fuzz

# Parâmetros do Algoritmo Genético
POPULATION_SIZE = 1000
GENERATIONS = 10000
MUTATION_RATE = 0.02
CROSSOVER_RATE = 0.7
SIMILARITY_THRESHOLD = 30  # Limiar mínimo de similaridade

# Lista de nomes de filmes (população inicial estática)
movie_titles = [
    "The Shawshank Redemption", "The Godfather", "The Dark Knight",
    "Pulp Fiction", "Schindler's List", "The Lord of the Rings: The Return of the King",
    "Forrest Gump", "Inception", "Fight Club", "The Matrix",
    "Goodfellas", "The Empire Strikes Back", "One Flew Over the Cuckoo's Nest",
    "Interstellar", "City of God", "Spirited Away", "Saving Private Ryan",
    "The Green Mile", "Life Is Beautiful", "The Silence of the Lambs",
    "Star Wars", "Se7en", "The Usual Suspects", "The Lion King", "Back to the Future"
]

# Função de aptidão (fitness function)
def evalFitness(individual):
    individual_str = ''.join(individual).strip()
    return fuzz.token_sort_ratio(individual_str.lower(), TARGET.lower()),

# Configuração do DEAP
creator.create("FitnessMax", base.Fitness, weights=(1.0,))
creator.create("Individual", list, fitness=creator.FitnessMax)

toolbox = base.Toolbox()
toolbox.register("attr_char", random.choice, string.printable)
toolbox.register("individual", tools.initRepeat, creator.Individual, toolbox.attr_char, len(max(movie_titles, key=len)))
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

def create_individual_from_title(title):
    ind = list(title)
    while len(ind) < len(max(movie_titles, key=len)):
        ind.append(' ')
    return creator.Individual(ind)

def main(target_string):
    global TARGET
    TARGET = target_string

    global GENE_LENGTH 
    GENE_LENGTH = len(TARGET)

    random.seed(64)

    # Encontrar filmes na lista movie_titles com similaridade acima do limiar
    matching_movies = [(movie, fuzz.token_sort_ratio(movie.lower(), TARGET.lower())) for movie in movie_titles]

    matching_movies = [(movie, score) for movie, score in matching_movies if score >= SIMILARITY_THRESHOLD]

    if matching_movies:
        # Ordenar os filmes correspondentes pelo nível de correspondência
        matching_movies_sorted = sorted(matching_movies, key=lambda x: x[1], reverse=True)

        print("Filmes correspondentes encontrados:")
        for movie, score in matching_movies_sorted:
            print(f"{movie} - Nível de correspondência: {score}%")
    else:
        print("Nenhum filme correspondente encontrado.")

if __name__ == "__main__":
    target_string = input("Digite o nome do filme que você está procurando: ").strip()
    main(target_string)
