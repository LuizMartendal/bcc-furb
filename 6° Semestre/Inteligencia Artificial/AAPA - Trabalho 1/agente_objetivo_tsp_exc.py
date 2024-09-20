import numpy as np
import matplotlib.pyplot as plt
import heapq
from IPython.display import clear_output
from itertools import permutations

# Constantes globais
colunas = 10
linhas = 10

# Variáveis globais
ambiente = None
pontos = 0


def main():
    global ambiente
    global pontos
    gerar_ambiente()

    posAPAx = 0
    posAPAy = 0

    if (len(ambiente) > 2) and (len(ambiente[0]) > 2):
        posAPAx = np.random.choice([1, linhas - 2])
        posAPAy = np.random.choice([1, colunas - 2])

    posicao_atual = (posAPAx, posAPAy)
    pontos = 0

    while True:
        objObtido = checkObj(posicao_atual)
        if not tem_sujeira():
            print("Ambiente limpo :D")
            return

        acao = agenteObjetivo(posicao_atual, objObtido)
        if acao == "acima":
            posicao_atual = (posicao_atual[0] - 1, posicao_atual[1])
        elif acao == "abaixo":
            posicao_atual = (posicao_atual[0] + 1, posicao_atual[1])
        elif acao == "esquerda":
            posicao_atual = (posicao_atual[0], posicao_atual[1] - 1)
        elif acao == "direita":
            posicao_atual = (posicao_atual[0], posicao_atual[1] + 1)
        elif acao == "aspirar":
            ambiente[posicao_atual[0]][posicao_atual[1]] = 0
        elif acao == "NoOp":
            break

        exibir(posicao_atual)


def gerar_ambiente():
    global ambiente
    ambiente = np.zeros((linhas, colunas), dtype=int)
    ambiente[0, :] = 1
    ambiente[-1, :] = 1
    ambiente[:, 0] = 1
    ambiente[:, -1] = 1
    if linhas > 2 or colunas > 2:
        ambiente[1:-1, 1:-1] = np.random.choice([0, 2], size=(linhas - 2, colunas - 2))


def exibir(current_position):
    plt.pause(0.2)
    clear_output(wait=True)
    global ambiente
    global pontos
    x, y = current_position
    plt.imshow(ambiente, cmap='Blues')
    plt.title(f'Pontos: {pontos}')
    plt.plot([y], [x], marker='o', color='r', ls='')
    plt.show(block=False)
    plt.pause(0.2)
    plt.clf()


def dijkstra(matriz, inicio):
    n = len(matriz)
    m = len(matriz[0])
    distancias = [[float('inf')] * m for _ in range(n)]
    distancias[inicio[0]][inicio[1]] = 0
    fila_prioridade = [(0, inicio)]
    direcoes = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    while fila_prioridade:
        distancia_atual, (x, y) = heapq.heappop(fila_prioridade)

        if distancia_atual > distancias[x][y]:
            continue

        for dx, dy in direcoes:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and matriz[nx][ny] != 1:
                nova_distancia = distancia_atual + 1
                if nova_distancia < distancias[nx][ny]:
                    distancias[nx][ny] = nova_distancia
                    heapq.heappush(fila_prioridade, (nova_distancia, (nx, ny)))

    return distancias


def calcular_distancia_total(caminho):
    total_distancia = 0
    for i in range(len(caminho) - 1):
        x1, y1 = caminho[i]
        x2, y2 = caminho[i + 1]
        total_distancia += abs(x1 - x2) + abs(y1 - y2)
    return total_distancia


def resolver_tsp(pontos):
    menor_distancia = float('inf')
    melhor_caminho = []

    for perm in permutations(pontos[1:]):
        caminho = [pontos[0]] + list(perm)
        distancia = calcular_distancia_total(caminho)
        if distancia < menor_distancia:
            menor_distancia = distancia
            melhor_caminho = caminho

    return melhor_caminho


def checkObj(pos_atual):
    return ambiente[pos_atual[0], pos_atual[1]]


def agenteObjetivo(pos_atual, objObtido):
    global pontos

    if objObtido == 2:
        pontos += 1
        return "aspirar"

    pos_sujeira = encontrar_sujeira_mais_proxima(pos_atual)
    if pos_sujeira is None:
        return "NoOp"

    if pos_sujeira[0] < pos_atual[0]:
        pontos += 1
        return "acima"
    elif pos_sujeira[0] > pos_atual[0]:
        pontos += 1
        return "abaixo"
    elif pos_sujeira[1] < pos_atual[1]:
        pontos += 1
        return "esquerda"
    elif pos_sujeira[1] > pos_atual[1]:
        pontos += 1
        return "direita"

    return "NoOp"


def encontrar_sujeira_mais_proxima(pos_atual):
    sujeira = [(i, j) for i in range(len(ambiente)) for j in range(len(ambiente[0])) if ambiente[i][j] == 2]
    if not sujeira:
        return None
    distancias = dijkstra(ambiente, pos_atual)
    sujeira_distancias = [(distancias[i][j], (i, j)) for i, j in sujeira]
    sujeira_distancias.sort()
    return sujeira_distancias[0][1] if sujeira_distancias else None


def tem_sujeira():
    return np.any(ambiente == 2)


if __name__ == "__main__":
    main()