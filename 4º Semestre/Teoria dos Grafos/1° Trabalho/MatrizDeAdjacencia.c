#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>

typedef int bool;
#define true 1
#define false 0

#define tamanhoDaMatriz 3

char* tipoDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho);
char* arestasDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho);
char* grausDoVertice(int matriz[][tamanhoDaMatriz], int tamanho);

bool ehUmGrafoDirigido(int matriz[][tamanhoDaMatriz], int tamanho);
bool ehUmGrafoSimples(int matriz[][tamanhoDaMatriz], int tamanho);
bool ehUmGrafoRegular(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoCompleto(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoNulo(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoBipartido(int matriz[][tamanhoDaMatriz], int tamanho);
bool temLacos(int matriz[][tamanhoDaMatriz], int tamanho);
bool contains(int vetor[], int elementoProcurado);

int* pegarGrauDosVertices(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);

void main() {
    setlocale(LC_ALL, "");

    int matriz[tamanhoDaMatriz][tamanhoDaMatriz] = {
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0}
    };
    printf("Tipo do Grafo: \n%s", tipoDoGrafo(matriz, tamanhoDaMatriz));
    printf("\nArestas do Grafo: \n%s", arestasDoGrafo(matriz, tamanhoDaMatriz));
    printf("\nGraus do Vértice: \n%s", grausDoVertice(matriz, tamanhoDaMatriz));
    printf("\nFim :)");
    system("pause");
}

char* tipoDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho){
    char* str = (char*) malloc(255 * sizeof(char));
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    if (ehDirigido) {
        strcat(str, "\tDirigido;");
    } else {
        strcat(str, "\tNão dirigido;");
    }
    bool ehSimples = ehUmGrafoSimples(matriz, tamanho);
    if (ehSimples) {
        strcat(str, " Simples;");
    } else {
        strcat(str, " Multigrafo;");
    }
    if (ehUmGrafoRegular(matriz, tamanho, ehDirigido)) {
        strcat(str, " Regular;");
        if (ehSimples) {
            bool ehCompleto = ehUmGrafoCompleto(matriz, tamanho, ehDirigido);
            if (ehCompleto) {
                strcat(str, " Completo;");
            } else {
                strcat(str, " Não é um grafo completo;");
            }
        }
    }
    bool ehNulo = ehUmGrafoNulo(matriz, tamanho, ehDirigido);
    if (ehNulo) {
        strcat(str, " Núlo;");
    }
    if (ehUmGrafoBipartido(matriz, tamanho) && !ehNulo) {
        strcat(str, " Bipartido;");
    }
    return str;
}

void bubbleSort(int vetor[], int tamanho) {
    int i, j;
    for (i = 0; i < tamanho - 1; i++) {
        for (j = 0; j < tamanho - i - 1; j++) {
            if (vetor[j] > vetor[j + 1]) {
                int temp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = temp;
            }
        }
    }
}

int somaVetor(int vetor[], int tamanho) {
    int soma = 0;
    for (int i = 0; i < tamanho; i++) {
        soma += vetor[i];
    }
    return soma;
}

char* arestasDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho) {
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    char* str = (char*) malloc(255 * sizeof(char));
    int* sequenciaDeGraus = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    bubbleSort(sequenciaDeGraus, tamanho);
    int soma = 0;
    if (ehDirigido) {
        soma = somaVetor(sequenciaDeGraus, tamanho);
    } else {
        soma = somaVetor(sequenciaDeGraus, tamanho) / 2;
    }
    strcat(str, "\tQuantidade de arestas: ");
    char somaString[255];
    sprintf(somaString, "%d", soma);
    strcat(str, somaString);
    strcat(str, "\n");
    strcat(str, "\tE = { ");
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if (matriz[i][j] != 0) {
                int qtdVertices = matriz[i][j];
                if (!ehDirigido) {
                    if (i < j) {
                        for (int k = 0; k < qtdVertices; k++) {
                            strcat(str, "(");
                            char iString[255];
                            sprintf(iString, "%d", i);
                            strcat(str, iString);
                            strcat(str, ",");
                            char jString[255];
                            sprintf(jString, "%d", j);
                            strcat(str, jString);
                            strcat(str, ") ");
                        }
                    }
                } else {
                    for (int k = 0; k < qtdVertices; k++) {
                        strcat(str, "(");
                        char iString[255];
                        sprintf(iString, "%d", i);
                        strcat(str, iString);
                        strcat(str, ",");
                        char jString[255];
                        sprintf(jString, "%d", j);
                        strcat(str, jString);
                        strcat(str, ") ");
                    }
                }
            }
        }
    }
    strcat(str, "}");
    return str;
}


char* grausDoVertice(int matriz[][tamanhoDaMatriz], int tamanho) {
    char* str = (char*) malloc(255 * sizeof(char));
    strcat(str, "\tV = { ");
    for (int i = 0; i < tamanho; i++) {
        if (i == tamanho - 1) {
            char iString[255];
            sprintf(iString, "%d", i);
            strcat(str, iString);
            strcat(str, " }\n");
        } else {
            char iString[255];
            sprintf(iString, "%d", i);
            strcat(str, iString);
            strcat(str, ", ");
        }
    }
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    int* grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        strcat(str, "\tGrau do v�tice ");
        char iString[255];
        sprintf(iString, "%d", i);
        strcat(str, iString);
        strcat(str, ": ");
        char grauString[255];
        sprintf(grauString, "%d", grauDosVertices[i]);
        strcat(str, grauString);
        strcat(str, "\n");
    }
    bubbleSort(grauDosVertices, sizeof(grauDosVertices) / sizeof(grauDosVertices[0]));
    strcat(str, "\tSequ�ncia de graus: (");
    for (int i = 0; i < tamanho; i++) {
        if (i == tamanho - 1) {
            char grauString[255];
            sprintf(grauString, "%d", grauDosVertices[i]);
            strcat(str, grauString);
        } else {
            char grauString[255];
            sprintf(grauString, "%d", grauDosVertices[i]);
            strcat(str, grauString);
            strcat(str, ", ");
        }
    }
    strcat(str, ")");
    return str;
}

bool ehUmGrafoDirigido(int matriz[][tamanhoDaMatriz], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if (matriz[i][j] != matriz[j][i] && i != j) {
                return true;
            }
        }
    }
    return false;
}

bool ehUmGrafoSimples(int matriz[][tamanhoDaMatriz], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if ((i == j && matriz[i][j] > 0) || matriz[i][j] > 1 || matriz[j][i] > 1) {
                return false;
            }
        }
    }
    return true;
}

bool ehUmGrafoRegular(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    int* grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    int grauDeReferencia = grauDosVertices[0];
    if (grauDeReferencia == 0 || tamanho <= 1) {
        return false;
    }
    for (int i = 1; i < tamanho; i++) {
        if (grauDeReferencia != grauDosVertices[i]) {
            return false;
        }
    }
    return true;
}

bool ehUmGrafoCompleto(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    int grauDeReferencia = tamanho - 1;
    int* grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        if (grauDeReferencia != grauDosVertices[i]) {
            return false;
        }
    }
    return true;
}

bool ehUmGrafoNulo(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    int* grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        if (grauDosVertices[i] != 0) {
            return false;
        }
    }
    return true;
}

bool ehUmGrafoBipartido(int matriz[][tamanhoDaMatriz], int tamanho) {
    int* v1 = (int*) malloc(tamanho * sizeof(int));
    int* v2 = (int*) malloc(tamanho * sizeof(int));
    if (temLacos(matriz, tamanho)) {
        return false;
    }
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if (!contains(v2, i) && i != j) {
                if (!contains(v1, i)) {
                    v1[i] = i;
                }
                if (!contains(v2, j) && matriz[i][j] != 0) {
                    if (!contains(v1, j)) {
                        return false;
                    }
                    v2[i] = j;
                }
            }
            if (contains(v2, j) && i != j) {
                if (!contains(v1, j) && matriz[i][j] != 0) {
                    if (contains(v2, j)) {
                        return false;
                    }
                    v1[i] = j;
                }
            }
        }
    }
    return true;
}

bool temLacos(int matriz[][tamanhoDaMatriz], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        if (matriz[i][i] != 0) {
            return true;
        }
    }
    return false;
}

bool contains(int vetor[], int elementoProcurado) {
    for (int i = 0; i < tamanhoDaMatriz; i++) {
        if (vetor[i] == elementoProcurado) {
            return true;
        }
    }
    return false;
}


int* pegarGrauDosVertices(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    int* grauDosVertices = (int*) malloc(tamanho * sizeof(int));
    for (int i = 0; i < tamanho; i++) {
        int grau = 0;
        for (int j = 0; j < tamanho; j++) {
            if (!ehDirigido && i == j) {
                    grau += (matriz[i][j] * 2);
                } else {
                    grau += matriz[i][j];
                }
        }
        grauDosVertices[i] = grau;
    }
    return grauDosVertices;
}
