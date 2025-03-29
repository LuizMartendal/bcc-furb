class TransposicaoGeometricaColunar:
    @staticmethod
    def cifrar_transposicao_geometrica_colunar(texto: str, colunas):
        texto = texto.replace(" ", "")
        print(f"Texto sem espaços: {texto}")

        linhas = (len(texto) + colunas - 1) // colunas
        matriz = [texto[i:i + colunas] for i in range(0, len(texto), colunas)]

        print("\nMatriz após separação do texto:")
        TransposicaoGeometricaColunar.print_matriz(matriz)

        if len(matriz[-1]) < colunas:
            matriz[-1] += "X" * (colunas - len(matriz[-1]))

        print("\nMatriz após preencher a última linha:")
        TransposicaoGeometricaColunar.print_matriz(matriz)

        texto_cifrado = ""
        for j in range(colunas):
            for i in range(linhas):
                texto_cifrado += matriz[i][j]

        return texto_cifrado

    @staticmethod
    def decifrar_transposicao_geometrica_colunar(texto_cifrado: str, colunas):
        linhas = len(texto_cifrado) // colunas
        matriz = ['' for _ in range(linhas)]

        index = 0
        for j in range(colunas):
            for i in range(linhas):
                matriz[i] += texto_cifrado[index]
                index += 1

        print("\nMatriz após transposição:")
        TransposicaoGeometricaColunar.print_matriz(matriz)

        texto_decifrado = ''.join(matriz)
        return texto_decifrado

    @staticmethod
    def print_matriz(matriz):
        for linha in matriz:
            print(f"| {' | '.join(linha)} |")
        print("+" + "+".join(["-" * len(linha) for linha in matriz]) + "+")


def main_transposicao_geométrica():
    print("Cifra de Transposição Geométrica Colunar")
    texto_original = input("Entre com o texto que você quer cifrar: ")
    num_colunas = int(input("Entre com o número de colunas: "))

    tgc = TransposicaoGeometricaColunar()

    texto_cifrado = tgc.cifrar_transposicao_geometrica_colunar(texto_original, num_colunas)
    print(f"\nTexto Cifrado: {texto_cifrado}")

    texto_decifrado = tgc.decifrar_transposicao_geometrica_colunar(texto_cifrado, num_colunas)
    print(f"\nTexto Decifrado: {texto_decifrado}")


main_transposicao_geométrica()
