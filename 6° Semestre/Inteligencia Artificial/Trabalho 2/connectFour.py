import numpy as np
import tkinter as tk
from tkinter import messagebox

LINHAS = 6
COLUNAS = 7
PECA_VAZIA = 0
PECA_JOGADOR = 1
PECA_IA = 2
PROFUNDIDADE_MAXIMA = 6

COR_VAZIA = "black"
COR_JOGADOR = "red"
COR_IA = "blue"
COR_BOTAO = 'black'
COR_BOTAO_LETRA = 'white'

tabuleiro = np.full((LINHAS, COLUNAS), PECA_VAZIA)
janela = tk.Tk()
janela.title('Connect Four')

botoes_colunas = []
botoes_tabuleiro = []

def atualizar_tabuleiro_gui(tabuleiro):
    tabuleiro_invertido = np.flip(tabuleiro, 0)
    tabuleiro_invertido = tabuleiro_invertido.astype(int)
    for l in range(LINHAS):
        for c in range(COLUNAS):
            cor = COR_VAZIA
            if tabuleiro_invertido[l][c] == PECA_JOGADOR:
                cor = COR_JOGADOR
            elif tabuleiro_invertido[l][c] == PECA_IA:
                cor = COR_IA
            botoes_tabuleiro[l][c].config(bg=cor)

def jogada_valida(coluna): # adicionar parametro linha
    return tabuleiro[0][coluna] == PECA_VAZIA

def obter_linha_aberta(coluna):
    for linha in range(LINHAS - 1, -1, -1):
        if tabuleiro[linha][coluna] == PECA_VAZIA:
            return linha

def verificar_vitoria():
    for c in range(COLUNAS - 3):
        for l in range(LINHAS):
            if tabuleiro[l][c] == tabuleiro[l][c + 1] == tabuleiro[l][c + 2] == tabuleiro[l][c + 3] != PECA_VAZIA:
                return tabuleiro[l][c]

    for c in range(COLUNAS):
        for l in range(LINHAS - 3):
            if tabuleiro[l][c] == tabuleiro[l + 1][c] == tabuleiro[l + 2][c] == tabuleiro[l + 3][c] != PECA_VAZIA:
                return tabuleiro[l][c]

    for c in range(COLUNAS - 3):
        for l in range(LINHAS - 3):
            if tabuleiro[l][c] == tabuleiro[l + 1][c + 1] == tabuleiro[l + 2][c + 2] == tabuleiro[l + 3][c + 3] != PECA_VAZIA:
                return tabuleiro[l][c]

    for c in range(COLUNAS - 3):
        for l in range(3, LINHAS):
            if tabuleiro[l][c] == tabuleiro[l - 1][c + 1] == tabuleiro[l - 2][c + 2] == tabuleiro[l - 3][c + 3] != PECA_VAZIA:
                return tabuleiro[l][c]

    return None

def verificar_empate():
    return all(tabuleiro[0][c] != PECA_VAZIA for c in range(COLUNAS))

# Algoritmo Minimax com poda Alpha Beta
def avaliar_tabuleiro():
    score = 0
    for c in range(COLUNAS):
        for l in range(LINHAS):
            if tabuleiro[l][c] == PECA_IA:
                score += 1
            elif tabuleiro[l][c] == PECA_JOGADOR:
                score -= 1
    return score

def minimax(profundidade, alpha, beta, maximizando):
    vencedor = verificar_vitoria()
    if vencedor == PECA_IA:
        return 1000
    elif vencedor == PECA_JOGADOR:
        return -1000
    elif verificar_empate():
        return 0

    if profundidade == PROFUNDIDADE_MAXIMA:
        return avaliar_tabuleiro()

    if maximizando:
        melhor_valor = -float('inf')
        for coluna in range(COLUNAS):
            if jogada_valida(coluna):
                linha = obter_linha_aberta(coluna)
                tabuleiro[linha][coluna] = PECA_IA
                valor = minimax(profundidade + 1, alpha, beta, True)
                tabuleiro[linha][coluna] = PECA_VAZIA
                melhor_valor = max(melhor_valor, valor)
                alpha = max(alpha, valor)
                if beta <= alpha:
                    break  # Poda
        return melhor_valor
    else:
        melhor_valor = float('inf')
        for coluna in range(COLUNAS):
            if jogada_valida(coluna):
                linha = obter_linha_aberta(coluna)
                tabuleiro[linha][coluna] = PECA_JOGADOR
                valor = minimax(profundidade + 1, alpha, beta, False)
                tabuleiro[linha][coluna] = PECA_VAZIA
                melhor_valor = min(melhor_valor, valor)
                beta = min(beta, valor)
                if beta <= alpha:
                    break  # Poda
        return melhor_valor

# Função para encontrar a melhor jogada da IA
def encontrar_melhor_jogada():
    melhor_valor = -float('inf')
    melhor_coluna = None
    for coluna in range(COLUNAS):
        if jogada_valida(coluna):
            linha = obter_linha_aberta(coluna)
            tabuleiro[linha][coluna] = PECA_IA
            valor = minimax(0, -float('inf'), float('inf'), True)
            tabuleiro[linha][coluna] = PECA_VAZIA
            if valor > melhor_valor:
                melhor_valor = valor
                melhor_coluna = coluna
    return melhor_coluna

"""# **Controle do Jogo**"""

# Função para a jogada da IA
def jogada_ia():
    coluna = encontrar_melhor_jogada()
    if coluna is not None:
        linha = obter_linha_aberta(coluna)
        tabuleiro[linha][coluna] = PECA_IA
        atualizar_tabuleiro_gui(tabuleiro)
        if verificar_vitoria() == PECA_IA:
            messagebox.showinfo("Derrota", "IA venceu!")
            janela.quit()

# Função para a jogada do jogador
def jogada_humano(coluna):
    atualizar_tabuleiro_gui(tabuleiro)
    if jogada_valida(coluna):
        linha = obter_linha_aberta(coluna)
        tabuleiro[linha][coluna] = PECA_JOGADOR
        atualizar_tabuleiro_gui(tabuleiro)
        if verificar_vitoria() == PECA_JOGADOR:
            messagebox.showinfo("Vitória", "Jogador venceu!")
            janela.quit()
        else:
            jogada_ia()
    else:
        messagebox.showinfo("Coluna inválida ou cheia! Tente novamente.")

# Função principal
def main():
    for c in range(COLUNAS):
        botao_coluna = tk.Button(janela, text=str(c), command=lambda c=c: jogada_humano(c), width=5, height=2,
                                 fg=COR_BOTAO_LETRA, bg=COR_BOTAO)
        botao_coluna.grid(row=0, column=c)
        botoes_colunas.append(botao_coluna)

    for l in range(LINHAS):
        linha_botoes = []
        for c in range(COLUNAS):
            botao = tk.Button(janela, text="", width=5, height=2, bg=COR_VAZIA)
            botao.grid(row=l + 1, column=c)
            linha_botoes.append(botao)
        botoes_tabuleiro.append(linha_botoes)
    messagebox.showinfo("Connect Four", "Bem-vindo ao Connect Four!")
    janela.mainloop()

if __name__ == "__main__":
    main()