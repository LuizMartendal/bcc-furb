import numpy as np
import math
import random
import tkinter as tk
from tkinter import messagebox

# Constantes
LINHAS = 6
COLUNAS = 7
JOGADOR = 0
IA = 1
PECA_JOGADOR = 1
PECA_IA = 2
COR_VAZIA = "white"
COR_JOGADOR = "red"
COR_IA = "yellow"

# Função para criar um tabuleiro vazio
def criar_tabuleiro():
    tabuleiro = np.zeros((LINHAS, COLUNAS))
    return tabuleiro

# Função para soltar uma peça em uma coluna específica
def soltar_peca(tabuleiro, linha, coluna, peca):
    tabuleiro[linha][coluna] = peca

# Função para verificar se uma coluna é válida para jogada
def localizacao_valida(tabuleiro, coluna):
    return tabuleiro[LINHAS-1][coluna] == 0

# Função para obter a próxima linha disponível em uma coluna
def obter_linha_aberta(tabuleiro, coluna):
    for l in range(LINHAS):
        if tabuleiro[l][coluna] == 0:
            return l

# Função para verificar se um jogador fez um movimento vencedor
def jogada_vencedora(tabuleiro, peca):
    # Verificação horizontal
    for c in range(COLUNAS-3):
        for l in range(LINHAS):
            if tabuleiro[l][c] == peca and tabuleiro[l][c+1] == peca and tabuleiro[l][c+2] == peca and tabuleiro[l][c+3] == peca:
                return True
    # Verificação vertical
    for c in range(COLUNAS):
        for l in range(LINHAS-3):
            if tabuleiro[l][c] == peca and tabuleiro[l+1][c] == peca and tabuleiro[l+2][c] == peca and tabuleiro[l+3][c] == peca:
                return True
    # Verificação diagonal positiva
    for c in range(COLUNAS-3):
        for l in range(LINHAS-3):
            if tabuleiro[l][c] == peca and tabuleiro[l+1][c+1] == peca and tabuleiro[l+2][c+2] == peca and tabuleiro[l+3][c+3] == peca:
                return True
    # Verificação diagonal negativa
    for c in range(COLUNAS-3):
        for l in range(3, LINHAS):
            if tabuleiro[l][c] == peca and tabuleiro[l-1][c+1] == peca and tabuleiro[l-2][c+2] == peca and tabuleiro[l-3][c+3] == peca:
                return True

# Função para obter as colunas válidas
def obter_localizacoes_validas(tabuleiro):
    localizacoes_validas = []
    for coluna in range(COLUNAS):
        if localizacao_valida(tabuleiro, coluna):
            localizacoes_validas.append(coluna)
    return localizacoes_validas

# Função para calcular a pontuação de uma posição do tabuleiro
def pontuar_posicao(tabuleiro, peca):
    pontuacao = 0
    peca_oponente = PECA_JOGADOR
    tabuleiro_avaliacao = np.array([[3, 4, 5, 7, 5, 4, 3],
                                    [4, 6, 8, 10, 8, 6, 4],
                                    [5, 7, 11, 13, 11, 7, 5],
                                    [5, 7, 11, 13, 11, 7, 5],
                                    [4, 6, 8, 10, 11, 6, 4],
                                    [3, 4, 5, 7, 5, 4, 3]])

    pontuacao_peca = np.sum(tabuleiro_avaliacao[tabuleiro == peca])
    pontuacao_oponente = np.sum(tabuleiro_avaliacao[tabuleiro == peca_oponente])

    pontuacao = pontuacao_peca - pontuacao_oponente
    return pontuacao

# Função para verificar se o tabuleiro é um nó terminal
def eh_no_terminal(tabuleiro):
    return jogada_vencedora(tabuleiro, PECA_JOGADOR) or jogada_vencedora(tabuleiro, PECA_IA) or (len(obter_localizacoes_validas(tabuleiro)) == 0)

# Algoritmo Minimax com poda alfa-beta
def minimax(tabuleiro, profundidade, alfa, beta, maximizador):
    localizacoes_validas = obter_localizacoes_validas(tabuleiro)
    terminal = eh_no_terminal(tabuleiro)

    if profundidade == 0 or terminal:
        if terminal:
            if jogada_vencedora(tabuleiro, PECA_IA):
                return (None, math.inf)
            elif jogada_vencedora(tabuleiro, PECA_JOGADOR):
                return (None, -math.inf)
            else:
                return (None, 0)
        else:
            return (None, pontuar_posicao(tabuleiro, PECA_IA))

    if maximizador:
        valor = -math.inf
        melhor_coluna = random.choice(localizacoes_validas)
        for coluna in localizacoes_validas:
            linha = obter_linha_aberta(tabuleiro, coluna)
            tabuleiro_copia = tabuleiro.copy()
            soltar_peca(tabuleiro_copia, linha, coluna, PECA_IA)
            nova_pontuacao = minimax(tabuleiro_copia, profundidade-1, alfa, beta, False)[1]

            if nova_pontuacao > valor:
                valor = nova_pontuacao
                melhor_coluna = coluna
            alfa = max(alfa, valor)

            if alfa >= beta:
                break
        return melhor_coluna, valor

    else:
        valor = math.inf
        melhor_coluna = random.choice(localizacoes_validas)
        for coluna in localizacoes_validas:
            linha = obter_linha_aberta(tabuleiro, coluna)
            tabuleiro_copia = tabuleiro.copy()
            soltar_peca(tabuleiro_copia, linha, coluna, PECA_JOGADOR)
            nova_pontuacao = minimax(tabuleiro_copia, profundidade-1, alfa, beta, True)[1]

            if nova_pontuacao < valor:
                valor = nova_pontuacao
                melhor_coluna = coluna
            beta = min(beta, valor)

            if alfa >= beta:
                break
        return melhor_coluna, valor

# Função que atualiza a interface gráfica com o estado atual do tabuleiro
def atualizar_tabuleiro_gui(tabuleiro):
    for l in range(LINHAS):
        for c in range(COLUNAS):
            cor = COR_VAZIA
            if tabuleiro[l][c] == PECA_JOGADOR:
                cor = COR_JOGADOR
            elif tabuleiro[l][c] == PECA_IA:
                cor = COR_IA
            botoes_tabuleiro[l][c].config(bg=cor)

# Função chamada quando o jogador clica em uma coluna
def jogador_joga(coluna):
    if localizacao_valida(tabuleiro, coluna):
        linha = obter_linha_aberta(tabuleiro, coluna)
        soltar_peca(tabuleiro, linha, coluna, PECA_JOGADOR)
        atualizar_tabuleiro_gui(tabuleiro)

        if jogada_vencedora(tabuleiro, PECA_JOGADOR):
            messagebox.showinfo("Vitória", "Você venceu!")
            janela.quit()

        vez_ia()

# Função que simula o turno da IA
def vez_ia():
    coluna, _ = minimax(tabuleiro, 3, -math.inf, math.inf, True)
    if localizacao_valida(tabuleiro, coluna):
        linha = obter_linha_aberta(tabuleiro, coluna)
        soltar_peca(tabuleiro, linha, coluna, PECA_IA)
        atualizar_tabuleiro_gui(tabuleiro)

        if jogada_vencedora(tabuleiro, PECA_IA):
            messagebox.showinfo("Derrota", "A IA venceu!")
            janela.quit()

# Configuração da interface gráfica
janela = tk.Tk()
janela.title("Conecta 4")

botoes_colunas = []
botoes_tabuleiro = []

tabuleiro = criar_tabuleiro()

# Criar botões para selecionar colunas
for c in range(COLUNAS):
    botao_coluna = tk.Button(janela, text=str(c), command=lambda c=c: jogador_joga(c), width=5, height=2)
    botao_coluna.grid(row=0, column=c)
    botoes_colunas.append(botao_coluna)

# Criar botões para o tabuleiro
for l in range(LINHAS):
    linha_botoes = []
    for c in range(COLUNAS):
        botao = tk.Button(janela, text="", width=5, height=2, bg=COR_VAZIA)
        botao.grid(row=l+1, column=c)
        linha_botoes.append(botao)
    botoes_tabuleiro.append(linha_botoes)

janela.mainloop()
