import numpy as np
import matplotlib.pyplot as plt
from heapq import heappop, heappush
from IPython.display import clear_output
import copy

linhas, colunas = 6, 6
posAPAx, posAPAy = 1, 1
pontos = 0
ambiente = None
direcoes = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def main():
  global pontos
  gerar_ambiente()

  posicao_inicial = posAPAx, posAPAy
  exibir(posicao_inicial)

  if ambiente[posAPAx][posAPAy] == 2:
    ambiente[posAPAx][posAPAy] = 0
    print(f"Sujeira aspirada na posição ({posAPAx}, {posAPAy})")
    pontos += 1
    exibir(posicao_inicial)

  ambiente_clone = copy.deepcopy(ambiente)

  melhor_caminho = limpar_todas_sujeiras(posicao_inicial, ambiente_clone)

  for proxima_posicao in melhor_caminho:
    exibir(proxima_posicao)
    x, y = proxima_posicao
    pontos += 1

    if ambiente[x][y] == 2:
      ambiente[x][y] = 0
      print(f"Sujeira aspirada na posição ({x}, {y})")
      exibir(proxima_posicao)
      pontos += 1

  print(f"Ambiente limpo em {pontos} pontos!")


def checkObj(sala):
  return np.any(sala == 2)


def gerar_ambiente():
  global ambiente
  ambiente = np.zeros((linhas, colunas), dtype=int)
  ambiente[0, :] = 1
  ambiente[-1, :] = 1
  ambiente[:, 0] = 1
  ambiente[:, -1] = 1

  if linhas > 2 or colunas > 2:
    ambiente[1:-1, 1:-1] = np.random.choice([0, 2], size=(linhas - 2, colunas - 2))


# Função para calcular a distância de Manhattan
def distancia_manhattan(pos1, pos2):
  return abs(pos1[0] - pos2[0]) + abs(pos1[1] - pos2[1])


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


# A*
def a_star(inicio, objetivo, ambiente_clone):
  fila = []
  heappush(fila, (0, inicio))  # A fila armazena tuplas (custo estimado, posição)
  custos = {inicio: 0}
  caminho = {inicio: None}

  while fila:
    _, atual = heappop(fila)

    if atual == objetivo:
      break

    for direcao in direcoes:
      vizinho = (atual[0] + direcao[0], atual[1] + direcao[1])

      if 0 <= vizinho[0] < linhas and 0 <= vizinho[1] < colunas and ambiente_clone[vizinho[0], vizinho[1]] != 1:
        novo_custo = custos[atual] + 1

        if vizinho not in custos or novo_custo < custos[vizinho]:
          custos[vizinho] = novo_custo
          prioridade = novo_custo + distancia_manhattan(vizinho, objetivo)
          heappush(fila, (prioridade, vizinho))
          caminho[vizinho] = atual

  atual = objetivo
  caminho_reconstruido = []
  while atual is not None:
    caminho_reconstruido.append(atual)
    atual = caminho[atual]
  caminho_reconstruido.reverse()

  return caminho_reconstruido


def limpar_todas_sujeiras(posicao_inicial, ambiente_clone):
  caminho_completo = []
  posicao_atual = posicao_inicial
  sujeiras = [(i, j) for i in range(linhas) for j in range(colunas) if ambiente_clone[i, j] == 2]
  while checkObj(ambiente_clone):

    proximidade_sujeira = [(posicao_atual[0] + direcao[0], posicao_atual[1] + direcao[1]) for direcao in direcoes if 0 <= posicao_atual[0] + direcao[0] < linhas and
                           0 <= posicao_atual[1] + direcao[1] < colunas and ambiente_clone[posicao_atual[0] + direcao[0], posicao_atual[1] + direcao[1]] == 2]

    if proximidade_sujeira:
      proxima_sujeira = proximidade_sujeira[0]
      caminho_completo.append(proxima_sujeira)
      posicao_atual = proxima_sujeira
      ambiente_clone[posicao_atual[0], posicao_atual[1]] = 0
      sujeiras.remove(proxima_sujeira)

    else:
      distancias = [(distancia_manhattan(posicao_atual, sujeira), sujeira) for sujeira in sujeiras]
      _, sujeira_mais_proxima = min(distancias)
      caminho = a_star(posicao_atual, sujeira_mais_proxima, ambiente_clone)
      caminho_completo += caminho[1:]
      posicao_atual = sujeira_mais_proxima
      ambiente_clone[posicao_atual[0], posicao_atual[1]] = 0
      sujeiras.remove(sujeira_mais_proxima)

  return caminho_completo


if __name__ == '__main__':
  main()

#   B) É possível ter todo o espaço limpo efetivamente? Justifique sua resposta.
#     R: Sim, pois utilizamos o algoritmo A*, onde ele mapea o caminho mais curto entre a posição atual e a sujeira mais próxima
#        fazendo com que que ele encontre o caminho mais curto, assim limpando de forma efetiva