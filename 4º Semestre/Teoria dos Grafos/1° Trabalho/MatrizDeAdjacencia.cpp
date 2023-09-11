#include <stdio.h>
#include <stdlib.h>
#include <locale>
#include <string>
#include <vector>
#include <new>
#include <iostream>
#include <algorithm>
#include <numeric>

using namespace std;

const int tamanhoDaMatriz = 3;

string tipoDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho);
string arestasDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho);
string grausDoVertice(int matriz[][tamanhoDaMatriz], int tamanho);

bool ehUmGrafoDirigido(int matriz[][tamanhoDaMatriz], int tamanho);
bool ehUmGrafoSimples(int matriz[][tamanhoDaMatriz], int tamanho);
bool ehUmGrafoRegular(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoCompleto(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoNulo(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido);
bool ehUmGrafoBipartido(int matriz[][tamanhoDaMatriz], int tamanho);
bool temLacos(int matriz[][tamanhoDaMatriz], int tamanho);
bool contains(vector<int> vetor, int elementoProcurado);

vector<int> pegarGrauDosVertices(int matriz[][3], int tamanho, bool ehDirigido);

int main() {
    setlocale(LC_ALL, "");

    int matriz[][tamanhoDaMatriz] = {
                {0, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };

    cout << "Tipo do Grafo: \n" << tipoDoGrafo(matriz, tamanhoDaMatriz) << "\nArestas do Grafo: \n" << arestasDoGrafo(matriz, tamanhoDaMatriz) << "\nGraus do Vértice: \n" << grausDoVertice(matriz, tamanhoDaMatriz) << "\nFim :)";

    return 0;
}

string tipoDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho) {
    string str = "";
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    if (ehDirigido) {
        str = "\tDirigido;";
    } else {
        str = "\tNão dirigido;";
    }
    bool ehSimples = ehUmGrafoSimples(matriz, tamanho);
    if (ehSimples) {
        str += " Simples;";
    } else {
        str += " Multigrafo;";
    }
    if (ehUmGrafoRegular(matriz, tamanho, ehDirigido)) {
        str += " Regular;";
        if (ehSimples) {
            bool ehCompleto = ehUmGrafoCompleto(matriz, tamanho, ehDirigido);
            if (ehCompleto) {
                str += " Completo;";
            } else {
                str += " Não é um grafo completo;";
            }
        }
    }
    bool ehNulo = ehUmGrafoNulo(matriz, tamanho, ehDirigido);
    if (ehNulo) {
        str += " Núlo";
    }
    if (ehUmGrafoBipartido(matriz, tamanho) && !ehNulo) {
        str += " Bipartido;";
    }
    return str;
}

string arestasDoGrafo(int matriz[][tamanhoDaMatriz], int tamanho) {
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    string str = "";
    vector<int> sequenciaDeGraus = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    sort(sequenciaDeGraus.begin(), sequenciaDeGraus.end());
    int soma = 0;
    if (ehDirigido) {
        soma = accumulate(sequenciaDeGraus.begin(), sequenciaDeGraus.end(), 0);
    } else {
        soma = accumulate(sequenciaDeGraus.begin(), sequenciaDeGraus.end(), 0) / 2;
    }
    str = "\tQuantidade de arestas: " + to_string(soma) + "\n";
    str += "\tE = { ";
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if (matriz[i][j] != 0) {
                int qtdArestas = matriz[i][j];
                if (!ehDirigido) {
                    if (i <= j) {
                       for (int k = 0; k < qtdArestas; k++) {
                            str += "(" + to_string(i) + "," + to_string(j) + ") ";
                        }
                    }
                } else {
                    for (int k = 0; k < qtdArestas; k++) {
                        str += "(" + to_string(i) + "," + to_string(j) + ") ";
                    }
                }
            }
        }
    }
    return str + "}";
}

string grausDoVertice(int matriz[][tamanhoDaMatriz], int tamanho) {
    string str = "\tV = { ";
    for (int i = 0; i < tamanho; i++) {
        if (i == tamanho - 1) {
            str += to_string(i) + " }\n";
        } else {
            str += to_string(i) + ", ";
        }
    }
    bool ehDirigido = ehUmGrafoDirigido(matriz, tamanho);
    vector<int> grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        str += "\tGrau do vétice " + to_string(i) + ": " + to_string(grauDosVertices[i]) + "\n";
    }
    sort(grauDosVertices.begin(), grauDosVertices.end());
    str += "\tSequência de graus: (";
    for (int i = 0; i < tamanho; i++) {
        if (i == tamanho - 1) {
            str += to_string(grauDosVertices[i]);
        } else {
            str += to_string(grauDosVertices[i]) + ", ";
        }
    }
    return str += ")";
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
    vector<int> grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
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
    vector<int> grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        if (grauDeReferencia != grauDosVertices[i]) {
            return false;
        }
    }
    return true;
}

bool ehUmGrafoNulo(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    vector<int> grauDosVertices = pegarGrauDosVertices(matriz, tamanho, ehDirigido);
    for (int i = 0; i < tamanho; i++) {
        if (grauDosVertices[i] != 0) {
            return false;
        }
    }
    return true;
}

bool ehUmGrafoBipartido(int matriz[][tamanhoDaMatriz], int tamanho) {
    vector<int> v1 = {};
    vector<int> v2 = {};
    if (temLacos(matriz, tamanho)) {
        return false;
    }
    for (int i = 0; i < tamanho; i++) {
        for (int j = 0; j < tamanho; j++) {
            if (!contains(v1, i) && !contains(v2, i) && i != j) {
                if (matriz[i][j] > 0) {
                    if (contains(v1, j)) {
                        v2.insert(v2.end(), i);
                    } else {
                        v1.insert(v1.end(), i);
                        if (!contains(v2, j)) {
                            v2.insert(v2.end(), j);
                        }
                    }
                }
            } else if (contains(v1, i) && !contains(v2, i) && i != j) {
                if (matriz[i][j] > 0) {
                    if (contains(v1, j)) {
                        return false;
                    }
                    if (!contains(v2, j)) {
                        v2.insert(v2.end(), j);
                    }
                }
            } else if (!contains(v1, i) && contains(v2, i) && i != j) {
                if (matriz[i][j] > 0) {
                    if (contains(v2, j)) {
                        return false;
                    }
                    if (!contains(v1, j)) {
                        v1.insert(v1.end(), j);
                    }
                }
            }
        }
    }
}

vector<int> pegarGrauDosVertices(int matriz[][tamanhoDaMatriz], int tamanho, bool ehDirigido) {
    vector<int> grauDosVertices = {};
    for (int i = 0; i < tamanho; i++) {
        int grau = 0;
        for (int j = 0; j < tamanho; j++) {
            if (!ehDirigido && i == j) {
                    grau += (matriz[i][j] * 2);
                } else {
                    grau += matriz[i][j];
                }
        }
        grauDosVertices.insert(grauDosVertices.end(), grau);
    }
    return grauDosVertices;
}

bool temLacos(int matriz[][tamanhoDaMatriz], int tamanho) {
    for (int i = 0; i < tamanho; i++) {
        if (matriz[i][i] != 0) {
            return true;
        }
    }
    return false;
}

bool contains(vector<int> vetor, int elementoProcurado) {
    for (int elemento : vetor) {
        if (elemento == elementoProcurado) {
            return true;
        }
    }
    return false;
}
