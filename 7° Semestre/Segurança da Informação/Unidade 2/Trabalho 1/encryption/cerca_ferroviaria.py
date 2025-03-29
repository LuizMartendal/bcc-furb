class CercaFerroviaria:
    @staticmethod
    def cifrar_cerca_ferroviaria(texto: str, trilhos: int):
        texto = texto.replace(" ", "")

        colunas = len(texto)
        matriz = [['' for _ in range(colunas)] for _ in range(trilhos)]

        print("\nMatriz inicial:")
        CercaFerroviaria.print_tabela(matriz)

        linha, direcao = 0, 1
        texto = texto.replace(" ", "")
        for coluna in range(len(texto)):
            matriz[linha][coluna] = texto[coluna]
            if linha == 0:
                direcao = 1
            elif linha == trilhos - 1:
                direcao = -1
            linha += direcao

        print("\nMatriz após preenchimento:")
        CercaFerroviaria.print_tabela(matriz)

        tabela_flat = [item for linha in matriz for item in linha]

        texto_cifrado = ''.join(tabela_flat)
        return texto_cifrado

    @staticmethod
    def decifrar_cerca_ferroviaria(texto_cifrado, trilhos):
        matriz = [['' for _ in range(len(texto_cifrado))] for _ in range(trilhos)]

        linha, direcao = 0, 1

        for coluna in range(len(texto_cifrado)):
            matriz[linha][coluna] = '*'
            if linha == 0:
                direcao = 1
            elif linha == trilhos - 1:
                direcao = -1
            linha += direcao

        print("\nMatriz inicial:")
        CercaFerroviaria.print_tabela(matriz)

        index = 0
        for i in range(trilhos):
            for j in range(len(texto_cifrado)):
                if matriz[i][j] == '*' and index < len(texto_cifrado):
                    matriz[i][j] = texto_cifrado[index]
                    index += 1

        print("\nMatriz após preenchimento:")
        CercaFerroviaria.print_tabela(matriz)

        resultado = []
        linha, direcao = 0, 1

        for coluna in range(len(texto_cifrado)):
            resultado.append(matriz[linha][coluna])
            if linha == 0:
                direcao = 1
            elif linha == trilhos - 1:
                direcao = -1
            linha += direcao

        return ''.join(resultado)

    @staticmethod
    def print_tabela(tabela):
        for linha in tabela:
            print(f"| {' | '.join(linha)} |")


def main_cerca_ferroviaria():
    print("Cifra Cerca Ferroviária")
    texto_original = input("Entre com o texto que você quer cifrar: ")
    num_trilhos = int(input("Entre com o número de trilhos: "))

    cf = CercaFerroviaria()

    print("\n+" + "+".join(["-" * len(texto_original)]) + "+")
    print("\nCifrando Texto")
    texto_cifrado = cf.cifrar_cerca_ferroviaria(texto_original, num_trilhos)

    print("\n+" + "+".join(["-" * len(texto_original)]) + "+")
    print("\nDecifrando Texto")
    texto_decifrado = cf.decifrar_cerca_ferroviaria(texto_cifrado, num_trilhos)

    print("\n+" + "+".join(["-" * len(texto_original)]) + "+")
    print(f"\nTexto Original: {texto_original}")
    print(f"\nTexto Cifrado: {texto_cifrado}")
    print(f"\nTexto Decifrado: {texto_decifrado}")


main_cerca_ferroviaria()
