import numpy as np
import matplotlib.pyplot as plt
from IPython.display import clear_output
import random

colunas = 6
linhas = 6

ambiente: any
sujeiras = 0

def main():
  ambiente = criar_ambiente()
  posAPAx, posAPAy = 0, 0

  if (linhas > 2) and (colunas > 2):
    posAPAx = np.random.choice([1, linhas - 2])
    posAPAy = np.random.choice([1, colunas - 2])

  exibir(ambiente, posAPAx, posAPAy)

  while True:
    percepcao = funcaoMapear(ambiente, posAPAx, posAPAy)
    acoes = agenteReativoSimples(ambiente, percepcao)

    if acoes != []:
      acoes = random.choice(acoes)
    posAPAx, posAPAy = mover_agente(ambiente, acoes, posAPAx, posAPAy)
    exibir(ambiente, posAPAx, posAPAy)


def criar_ambiente():
  ambiente = np.zeros((linhas, colunas), dtype=int)

  ambiente[0, :] = 1
  ambiente[-1, :] = 1
  ambiente[:, 0] = 1
  ambiente[:, -1] = 1

  if linhas > 2 or colunas > 2:
    ambiente[1:-1, 1:-1] = np.random.choice([0, 2], size=(linhas-2, colunas-2))

  return ambiente


def exibir(ambiente, posAPAx, posAPAy):
  global sujeiras
  plt.pause(0.2)
  clear_output(wait=True)

  plt.imshow(ambiente, 'Blues')
  plt.title(f"Quantidade de sujeiras encontradas: {sujeiras}")
  plt.nipy_spectral()

  plt.plot([posAPAy],[posAPAx], marker='o', color='r', ls='')

  plt.show(block=False)

  plt.pause(0.2)
  plt.clf()


def agenteReativoSimples(ambiente, percepcao):
  posicao, status = percepcao
  if status == 'sujo':
    return ['aspirar']
  else:
    x, y = posicao
    movimentos = []

    if x > 1:
      if ambiente[x - 1][y] == 2:
        return ['acima']
      movimentos.append('acima')
    if x < linhas - 2:
      if ambiente[x + 1][y] == 2:
        return ['abaixo']
      movimentos.append('abaixo')
    if y > 1:
      if ambiente[x][y - 1] == 2:
        return ['esquerda']
      movimentos.append('esquerda')
    if y < colunas - 2:
      if ambiente[x][y + 1] == 2:
        return ['direita']
      movimentos.append('direita')

  return movimentos


def funcaoMapear(ambiente, x, y):
  status = 'sujo' if ambiente[x][y] == 2 else 'limpo'
  return ((x, y), status)


def mover_agente(ambiente, acao, posAPAx, posAPAy):
  global sujeiras
  if acao == 'aspirar':
    ambiente[posAPAx][posAPAy] = 0
    sujeiras += 1
  elif acao == 'direita' and ambiente[posAPAx][posAPAy + 1] != 1:
    posAPAy += 1
  elif acao == 'abaixo' and ambiente[posAPAx + 1][posAPAy] != 1:
    posAPAx += 1
  elif acao == 'esquerda' and ambiente[posAPAx][posAPAy - 1] != 1:
    posAPAy -= 1
  elif acao == 'acima' and ambiente[posAPAx - 1][posAPAy] != 1:
    posAPAx -= 1
  return posAPAx, posAPAy


if __name__ == "__main__":
  main()