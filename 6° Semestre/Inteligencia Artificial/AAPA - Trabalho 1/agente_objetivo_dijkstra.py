import heapq

import matplotlib.pyplot as plt
import numpy as np
from IPython.display import clear_output

colunas = 10
linhas = 10

ambiente = None
pontos = 0

def main():
    global ambiente
    gerar_ambiente()

    posAPAx = 0
    posAPAy = 0

    if (linhas > 2) and (colunas > 2):
        posAPAx = np.random.choice([1, linhas - 2])
        posAPAy = np.random.choice([1, colunas - 2])

    current_position = (posAPAx, posAPAy)
    visited = set()

    exibir(current_position)

    objObtido = ambiente[current_position[0], current_position[1]]

    while True:
        pos_sujeira = encontrar_sujeira_mais_proxima(current_position)

        if pos_sujeira is None:
            break

        acao = agenteObjetivo(current_position, objObtido)

        if acao == "acima":
            current_position = (current_position[0] - 1, current_position[1])
        elif acao == "abaixo":
            current_position = (current_position[0] + 1, current_position[1])
        elif acao == "esquerda":
            current_position = (current_position[0], current_position[1] - 1)
        elif acao == "direita":
            current_position = (current_position[0], current_position[1] + 1)
        elif acao == 'aspirar':
            ambiente[current_position[0]][current_position[1]] = 0

        objObtido = ambiente[current_position[0], current_position[1]]

        visited.add(current_position)
        exibir(current_position)


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


def encontrar_sujeira_mais_proxima(pos_atual):
    sujeira = [(i, j) for i in range(len(ambiente)) for j in range(len(ambiente[0])) if ambiente[i][j] == 2]
    if not sujeira:
        return None
    distancias = dijkstra(ambiente, pos_atual)
    sujeira_distancias = [(distancias[i][j], (i, j)) for i, j in sujeira]
    sujeira_distancias.sort()
    return sujeira_distancias[0][1] if sujeira_distancias else None


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


if __name__ == "__main__":
    main()
