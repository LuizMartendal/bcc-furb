# Eduardo Lyra, Lucas Fritzke, Luiz Martendal, Daniel Kruger

import numpy as np
import matplotlib.pyplot as plt
from IPython.display import clear_output

COL_SIZE = 6
LINE_SIZE = 6

def main():
    global avancarX
    avancarX = 1
    global avancarY
    avancarY = 1

    global posAPAx
    posAPAx = 1
    global posAPAy
    posAPAy = 1

    global contagem
    contagem = 0

    gerar_matriz_com_paredes()
    executar()

def executar():
    global posAPAx, posAPAy, matriz
    while True:
        status = funcaoMapear()
        print(agenteReativoSimples(status[1]))
        exibir(posAPAy, posAPAx, matriz)

def funcaoMapear():
    global posAPAx, posAPAy, matriz
    if matriz[posAPAx][posAPAy] == 2:
        status = "sujo"
    else:
        status = "limpo"
    return ((posAPAx, posAPAy), status)

def agenteReativoSimples(status):
    global avancarX, avancarY, posAPAx, posAPAy, matriz, contagem
    if status == "sujo":
        matriz[posAPAx][posAPAy] = 0
        contagem += 1
        return 'aspirar'
    if matriz[posAPAx + avancarX][posAPAy] != 1:
        moverAgente('x')
        return verificaDirecaoX()
    if matriz[posAPAx][avancarY + posAPAy] != 1:
        moverAgente('y')
        avancarX *= -1
        return verificaDirecaoY()
    else:
        avancarY *= -1
        avancarX *= -1
        moverAgente('y')
        return verificaDirecaoY()

def moverAgente(flag):
    global avancarX, avancarY, posAPAx, posAPAy
    if flag == 'x':
        posAPAx += avancarX
    else:
        posAPAy += avancarY

def verificaDirecaoX():
    global avancarX
    if avancarX > 0:
        return 'abaixo'
    else:
        return 'acima'

def verificaDirecaoY():
    global avancarY
    if avancarY > 0:
        return 'direita'
    else:
        return 'esquerda'


def gerar_matriz_com_paredes():
    global matriz, contagem
    matriz = np.zeros((LINE_SIZE, COL_SIZE), dtype=int)

    matriz[0, :] = 1
    matriz[-1, :] = 1
    matriz[:, 0] = 1
    matriz[:, -1] = 1

    matriz[1:-1, 1:-1] = np.random.choice([0, 2], size=(LINE_SIZE-2, COL_SIZE-2))


def exibir(y, x, matriz):
    global contagem

    clear_output(wait=True)
    plt.imshow(matriz, 'Blues')
    plt.title(f"Quantidade de sujeiras encontradas: {contagem}")
    plt.nipy_spectral()

    plt.plot([y],[x], marker='o', color='r', ls='')

    plt.show(block=False)

    plt.pause(0.5)
    plt.clf()

if __name__ == "__main__":
  main()


# A) A sua solução é extensível para um mundo 3 x 3? E para um mundo 6 x 6? Explique sua resposta
# R: Sim, pois nosso algoritmo realiza o caminhamento de cima para baixo, e depois de baixo para cima. Ele se baseia nos extremos (paredes)