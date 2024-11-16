import numpy as np
import matplotlib.pyplot as plt

# Carregando os dados das cidades a partir do arquivo fornecido
data = np.loadtxt('cidades.mat')

# Separando as coordenadas X e Y
x = data[0]
y = data[1]

Ncidade = len(x)  # Número de cidades
Npop = 20         # Tamanho da população
geracoes = 10000  # Número de iterações

"""
Cria uma lista de Npop permutações diferentes, onde cada permutação representa uma rota aleatória das cidades.
Essa é a população inicial com a qual o algoritmo genético começará a trabalhar.
Cada elemento dessa lista é um cromossomo, que no contexto do problema, é uma solução candidata para o caminho que visita todas as cidades.
"""
populacao = [np.random.permutation(Ncidade) for _ in range(Npop)]


def calcula_distancia_total(cromossomo, x, y):
    """Calcula a distância total percorrida por um cromossomo."""
    distancia = 0
    for i in range(len(cromossomo)):
        cidade_atual = cromossomo[i]
        proxima_cidade = cromossomo[(i + 1) % len(cromossomo)]  # Retorna à cidade inicial
        distancia += np.sqrt((x[cidade_atual] - x[proxima_cidade])**2 + (y[cidade_atual] - y[proxima_cidade])**2)
    distancia += np.sqrt((x[cromossomo[-1]] - x[cromossomo[0]]) ** 2 + (y[cromossomo[-1]] - y[cromossomo[0]]) ** 2)
    return distancia


# Função de aptidão
def aptidao(populacao, x, y):
    custos = [calcula_distancia_total(cromossomo, x, y) for cromossomo in populacao]
    return np.array(custos)


# Implementação do crossover 'cycle'
def crossover_cycle(pai1, pai2):
    n = len(pai1)
    filho1, filho2 = np.empty(n, dtype=int), np.empty(n, dtype=int)
    filho1.fill(-1)
    filho2.fill(-1)

    # Ciclo para preencher os filhos
    ciclo = True
    index = 0
    while ciclo:
        filho1[index] = pai1[index]
        filho2[index] = pai2[index]
        """
        Procura a próxima posição em pai1 onde o valor atual de pai2 (na posição index) aparece.
        Isso permite que o algoritmo siga o "ciclo" traçado pelos genes de pai2 em pai1.
        """
        index = np.where(pai1 == pai2[index])[0][0] #
        ciclo = index != 0  # Termina o ciclo quando volta ao início!!!

    filho1[filho1 == -1] = pai2[filho1 == -1]
    filho2[filho2 == -1] = pai1[filho2 == -1]
    return filho1, filho2


# Operdor de mutação
def mutacao(cromossomo):
    """Aplica a mutação trocando dois genes aleatórios."""
    i, j = np.random.choice(len(cromossomo), 2, replace=False)
    cromossomo[i], cromossomo[j] = cromossomo[j], cromossomo[i]
    return cromossomo


# Processo de seleção usando o método da rolet
def selecao_roleta(populacao, custos, num_selecionados):
    custos = np.array(custos)  # Converte custos para um array do numpy
    probabilidade = 1 / custos

    # Evita divisão por zero
    probabilidade[custos == 0] = np.inf

    probabilidade /= probabilidade.sum()
    indices = np.random.choice(len(populacao), size=num_selecionados, p=probabilidade)
    return [populacao[i] for i in indices]


# Algoritmo genético
for geracao in range(geracoes):
    custos = aptidao(populacao, x, y)

    # Selecionar os 10 melhores indivíduos
    melhores_indices = np.argsort(custos)[:10]
    melhores = [populacao[i] for i in melhores_indices]
    custos_melhores = [custos[i] for i in melhores_indices]

    # Gerar novos filhos com base nos 10 melhores usando o método da roleta
    nova_populacao = melhores.copy()
    filhos = selecao_roleta(melhores, custos_melhores, num_selecionados=10)

    for i in range(0, len(filhos) - 1, 2):
        filho1, filho2 = crossover_cycle(filhos[i], filhos[i + 1])
        nova_populacao.append(filho1)
        nova_populacao.append(filho2)

    # Limitar a população a Npop (caso tenha gerado mais de 20 indivíduos)
    if len(nova_populacao) > Npop:
        nova_populacao = nova_populacao[:Npop]

    # Aplica mutação em todos os novos cromossomos, exceto os 10 melhores
    nova_populacao[10:] = [mutacao(cromossomo) if np.random.rand() < 0.1 else cromossomo for cromossomo in nova_populacao[10:]]

    # Atualiza a população
    populacao = nova_populacao


# Resultados
custos_finais = aptidao(populacao, x, y)
melhor_indice = np.argmin(custos_finais)
melhor_solucao = populacao[melhor_indice]
melhor_custo = custos_finais[melhor_indice]

print("Tamanho da População:", Npop)
print("Número de Cidades:", Ncidade)
print("Melhor Custo:", melhor_custo)
print("Melhor Solução:", melhor_solucao)

# Plot do melhor caminho encontrado
plt.figure(figsize=(10, 10))
rota_x = np.append(x[melhor_solucao], x[melhor_solucao[0]])
rota_y = np.append(y[melhor_solucao], y[melhor_solucao[0]])
plt.plot(rota_x, rota_y, marker='o')
plt.title("Melhor Caminho Encontrado pelo Algoritmo Genético")
plt.xlabel("Coordenada X")
plt.ylabel("Coordenada Y")
plt.show()
