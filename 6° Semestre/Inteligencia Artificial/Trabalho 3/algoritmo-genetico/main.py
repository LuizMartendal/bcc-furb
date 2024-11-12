import numpy as np
import matplotlib.pyplot as plt

# print('Carregando os dados das cidades a partir do arquivo fornecido')
data = np.loadtxt('cidades.mat')
# print('Cidades carregadas: ', data)

# print('Separando as coordenadas')
x = data[0]
y = data[1]
# print('X: ', x, ' Y: ', y)

Ncidade = len(x)
# print('Número de cidades: ', Ncidade)
Npop = 20
# print('Tamanho da população: ', Npop)
geracoes = 10000
# print('Número de iterações: ', geracoes)

# print('Inicializa a população com permutações de cidades')
populacao = [np.random.permutation(Ncidade) for _ in range(Npop)]


def calcula_distancia_total(cromossomo, x, y):
    # print('Calculando a distância total percorrida por um cromossomo')
    # print('Cromossomo: ', cromossomo)
    # print('X: ', x, ' Y: ', y)
    distancia = 0
    for i in range(len(cromossomo)):
        cidade_atual = cromossomo[i]
        proxima_cidade = cromossomo[(i + 1) % len(cromossomo)]  # Retorna à cidade inicial
        distancia += np.sqrt((x[cidade_atual] - x[proxima_cidade])**2 + (y[cidade_atual] - y[proxima_cidade])**2)

    distancia += np.sqrt((x[cromossomo[-1]] - x[cromossomo[0]]) ** 2 + (y[cromossomo[-1]] - y[cromossomo[0]]) ** 2)

    # print('Distância calculada: ', distancia)
    return distancia


def aptidao(populacao, x, y):
    # print('Realizando função de aptidao nas coordenadas X: ', x, ' e Y: ', y)
    custos = [{'custo': calcula_distancia_total(cromossomo, x, y), 'cromossomo': cromossomo} for cromossomo in populacao]
    return np.array(custos)


def crossover_cycle(pai1, pai2):
    # print('Implementação do crossover cycle')
    # print('Pai1: ', pai1)
    # print('Pai2: ', pai2)
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
        index = np.where(pai1 == pai2[index])[0][0]
        ciclo = index != 0  # Termina o ciclo quando volta ao início

    filho1[filho1 == -1] = pai2[filho1 == -1]
    filho2[filho2 == -1] = pai1[filho2 == -1]
    # print('Filhos gerados: Filho1 = ', filho1, ' Filho2 = ', filho2)
    return filho1, filho2


def mutacao(cromossomo):
    # print('Aplicando a mutação trocando dois genes aleatórios')
    # print('Cromossomo antes da mutação: ', cromossomo)
    i, j = np.random.choice(len(cromossomo), 2, replace=False)
    cromossomo[i], cromossomo[j] = cromossomo[j], cromossomo[i]
    # print('Cromossomo depois da mutação: ', cromossomo)
    return cromossomo


def selecao_roleta(populacao, custos):
    # print('Processo de seleção usando o método da roleta')
    probabilidade = 1 / custos
    probabilidade /= probabilidade.sum()
    indices = np.random.choice(len(populacao), size=Npop//2, p=probabilidade)
    return [populacao[i] for i in indices]


for geracao in range(geracoes):
    # Calcula os custos e ordena a população
    custos = sorted(aptidao(populacao, x, y), key=lambda item: item['custo'])

    # Seleciona a metade da população com menor custo
    nova_populacao = [item['cromossomo'] for item in custos[:len(custos) // 2]]

    # Calcula a soma da aptidão inversa (menor custo -> maior probabilidade)
    total_aptidao = sum(1 / item['custo'] for item in custos[:len(custos) // 2])
    probabilidades = [(1 / item['custo']) / total_aptidao for item in custos[:len(custos) // 2]]

    nova_geracao = []
    while len(nova_geracao) < len(nova_populacao):
        # Seleciona pais usando a roleta
        pai1 = np.random.choice(nova_populacao, p=probabilidades)
        pai2 = pai1

        # Garante que pai1 e pai2 sejam diferentes
        while pai2 == pai1:
            pai2 = np.random.choice(nova_populacao, p=probabilidades)

        # Realiza o crossover e adiciona os filhos à nova geração
        filho1, filho2 = crossover_cycle(pai1, pai2)
        nova_geracao.extend([filho1, filho2])

    # Limita a nova geração ao tamanho desejado
    nova_geracao = nova_geracao[:len(nova_populacao)]

    # Aplica mutação nos novos cromossomos
    nova_geracao = [mutacao(cromossomo) if np.random.rand() < 0.1 else cromossomo for cromossomo in nova_geracao]

    # Atualiza a população
    populacao = nova_populacao + nova_geracao

# Mostra os resultados
custos_finais = aptidao(populacao, x, y)
melhor_indice = np.argmin(custos_finais)
melhor_solucao = populacao[melhor_indice]
melhor_custo = custos_finais[melhor_indice]

# print('')
# print("Tamanho da População:", Npop)
# print("Número de Cidades:", Ncidade)
# print("Melhor Custo:", melhor_custo)
# print("Melhor Solução:", melhor_solucao)
# print('População: ', data)

# Plot do melhor caminho encontrado - essa parte foi gerada pelo chatzão brabo :)
plt.figure(figsize=(10, 10))
rota_x = np.append(x[melhor_solucao], x[melhor_solucao[0]])
rota_y = np.append(y[melhor_solucao], y[melhor_solucao[0]])
plt.plot(rota_x, rota_y, marker='o')
plt.title("Melhor Caminho Encontrado pelo Algoritmo Genético")
plt.xlabel("Coordenada X")
plt.ylabel("Coordenada Y")
plt.show()
