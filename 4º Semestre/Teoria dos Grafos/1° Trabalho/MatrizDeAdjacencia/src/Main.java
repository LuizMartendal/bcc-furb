//Luiz Henrique Martendal

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[][] matriz = {
//                {0, 1, 1, 1, 1, 0, 0},
//                {1, 0, 0, 0, 0, 1, 1},
//                {1, 0, 0, 0, 0, 1, 1},
//                {1, 0, 0, 0, 0, 1, 1},
//                {1, 0, 0, 0, 0, 1, 1},
//                {0, 1, 1, 1, 1, 0, 0},
//                {0, 1, 1, 1, 1, 0, 0}
//        };
        /*
        Tipo do Grafo:
	        Não dirigido; Simples; Bipartido;
        Arestas do Grafo:
	        Quantidade de arestas: 12
	        E = { (0,1) (0,2) (0,3) (0,4) (1,5) (1,6) (2,5) (2,6) (3,5) (3,6) (4,5) (4,6) }
        Graus do Vértice:
            V = { 0, 1, 2, 3, 4, 5, 6 }
            Grau do vétice 0: 4
            Grau do vétice 1: 3
            Grau do vétice 2: 3
            Grau do vétice 3: 3
            Grau do vétice 4: 3
            Grau do vétice 5: 4
            Grau do vétice 6: 4
            Sequência de graus: (3, 3, 3, 3, 4, 4, 4)
        */

        int[][] matriz = {
                {1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 0, 2, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        /*
            Tipo do Grafo:
                Não dirigido; Multigrafo;
            Arestas do Grafo:
                Quantidade de arestas: 15
	            E = { (0,0) (0,1) (0,2) (0,3) (0,4) (1,5) (1,6) (2,2) (2,2) (2,5) (2,6) (3,5) (3,6) (4,5) (4,6) }
            Graus do Vértice:
                V = { 0, 1, 2, 3, 4, 5, 6 }
                Grau do vétice 0: 6
                Grau do vétice 1: 3
                Grau do vétice 2: 7
                Grau do vétice 3: 3
                Grau do vétice 4: 3
                Grau do vétice 5: 4
                Grau do vétice 6: 4
                Sequência de graus: (3, 3, 3, 4, 4, 6, 7)

        */

//        int[][] matriz = {
//                {0, 0, 1, 0, 1, 0, 0},
//                {1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 0},
//                {0, 1, 0, 1, 0, 0, 0},
//                {0, 0, 1, 0, 1, 0, 0}
//        };
        /*
            Tipo do Grafo:
                Dirigido; Simples; Bipartido;
            Arestas do Grafo:
                Quantidade de arestas: 12
                E = { (0,2) (0,4) (1,0) (1,6) (2,5) (3,0) (3,6) (4,5) (5,1) (5,3) (6,2) (6,4) }
            Graus do Vértice:
                V = { 0, 1, 2, 3, 4, 5, 6 }
                Grau do vétice 0: 2
                Grau do vétice 1: 2
                Grau do vétice 2: 1
                Grau do vétice 3: 2
                Grau do vétice 4: 1
                Grau do vétice 5: 2
                Grau do vétice 6: 2
                Sequência de graus: (1, 1, 2, 2, 2, 2, 2)
        */

//        int[][] matriz = {
//                {1, 0, 1, 0, 1, 0, 0},
//                {1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 2, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 0},
//                {0, 1, 0, 1, 0, 0, 0},
//                {0, 0, 1, 0, 1, 0, 0}
//        };
        /*
            Tipo do Grafo:
                Dirigido; Multigrafo;
            Arestas do Grafo:
                Quantidade de arestas: 15
                E = { (0,0) (0,2) (0,4) (1,0) (1,6) (2,2) (2,5) (3,0) (3,6) (4,5) (5,1) (5,3) (6,2) (6,4) }
            Graus do Vértice:
                V = { 0, 1, 2, 3, 4, 5, 6 }
                Grau do vétice 0: 3
                Grau do vétice 1: 2
                Grau do vétice 2: 3
                Grau do vétice 3: 2
                Grau do vétice 4: 1
                Grau do vétice 5: 2
                Grau do vétice 6: 2
                Sequência de graus: (1, 2, 2, 2, 2, 3, 3)
        */

//        int[][] matriz = {
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
//        };
        /*
            Tipo do Grafo:
                Não dirigido; Simples; Núlo;
            Arestas do Grafo:
                Quantidade de arestas: 0
                E = { }
            Graus do Vértice:
                V = { 0, 1, 2 }
                Grau do vétice 0: 0
                Grau do vétice 1: 0
                Grau do vétice 2: 0
                Sequência de graus: (0, 0, 0)
        */

        System.out.println("Tipo do Grafo: \n"+tipoDoGrafo(matriz)+"\nArestas do Grafo: \n"+arestasDoGrafo(matriz)+"\nGraus do Vértice: \n"+grausDoVertice(matriz)+"\nFim :)");
    }

    public static String tipoDoGrafo(int[][] matriz) {
        String str = "";
        boolean ehDirigido = ehUmGrafoDirigido(matriz);
        if (ehDirigido) {
            str = "\tDirigido;";
        } else {
            str = "\tNão dirigido;";
        }
        boolean ehSimples = ehUmGrafoSimples(matriz);
        if (ehSimples) {
            str += " Simples;";
        } else {
            str += " Multigrafo;";
        }
        if (ehUmGrafoRegular(matriz, ehDirigido)) {
            str += " Regular;";
            if (ehSimples) {
                boolean ehCompleto = ehUmGrafoCompleto(matriz, ehDirigido);
                if (ehCompleto) {
                    str += " Completo;";
                } else {
                    str += " Não é um grafo completo;";
                }
            }
        }
        boolean ehNulo = ehUmGrafoNulo(matriz, ehDirigido);
        if (ehNulo) {
            str += " Núlo;";
        }
        if (ehUmGrafoBipartido(matriz) && !ehNulo) {
            str += " Bipartido;";
        }
        return str;
    }

    public static String arestasDoGrafo(int[][] matriz) {
        boolean ehDirigido = ehUmGrafoDirigido(matriz);
        String str = "";
        // Independente de dirigido ou não, optei por calcular o tamanho do grafo a partir da sequência de graus de saída
        List<Integer> sequenciaDeGraus = pegarGrauDeSaidaDosVertices(matriz, ehDirigido);
        Collections.sort(sequenciaDeGraus);
        if (ehDirigido) {
            str = "\tQuantidade de arestas: " + sequenciaDeGraus.stream().mapToInt(Integer::intValue).sum() + "\n";
        } else {
            str = "\tQuantidade de arestas: " + sequenciaDeGraus.stream().mapToInt(Integer::intValue).sum() / 2 + "\n";
        }
        str += "\tE = { ";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    int qtdArestas = matriz[i][j];
                    if (!ehDirigido) {
                        if (i <= j)
                            for (int k = 0; k < qtdArestas; k++) {
                                str += "(" + i + "," + j + ") ";
                            }
                    } else {
                        for (int k = 0; k < qtdArestas; k++) {
                            str += "(" + i + "," + j + ") ";
                        }
                    }
                }
            }
        }
        return str + "}";
    }

    public static String grausDoVertice(int[][] matriz) {
        String str = "\tV = { ";
        for (int i = 0; i < matriz.length; i++) {
            if (i == matriz.length - 1) {
                str += i + " }\n";
            } else {
                str += i + ", ";
            }
        }
        boolean ehDirigido = ehUmGrafoDirigido(matriz);
        str += separarGrausESequencia(matriz, pegarGrauDeSaidaDosVertices(matriz, ehDirigido), "saída");
        if (ehDirigido) {
            str += "\n" + separarGrausESequencia(matriz, pegarGrauDeEntradaDosVertices(matriz), "entrada");
        }
        return str;
    }

    private static List<Integer> pegarGrauDeEntradaDosVertices(int[][] matriz) {
        ArrayList<Integer> grauDosVertices = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            int valor = 0;
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[j][i] > 0) {
                    valor += matriz[j][i];
                }
            }
            grauDosVertices.add(valor);
        }
        return grauDosVertices;
    }

    private static String separarGrausESequencia(int[][] matriz, List<Integer> grauDosVertices, String tipo) {
        String str = "\tGraus de " + tipo + ":\n";
        for (int i = 0; i < matriz.length; i++) {
            str += "\t\tGrau do vértice " + i + ": " + grauDosVertices.get(i) + "\n";
        }
        Collections.sort(grauDosVertices);
        str += "\tSequência de graus de " + tipo + ": (";
        for (int i = 0; i < matriz.length; i++) {
            if (i == matriz.length - 1) {
                str += grauDosVertices.get(i);
            } else {
                str += grauDosVertices.get(i) + ", ";
            }
        }
        return str += ")";
    }

    private static boolean ehUmGrafoDirigido(int[][] matriz) {
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != matriz[j][i] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ehUmGrafoSimples(int[][] matriz) {
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if ((i == j && matriz[i][j] > 0) || matriz[i][j] > 1 || matriz[j][i] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean ehUmGrafoRegular(int[][] matriz, boolean ehDirigido) {
        List<Integer> grauDosVertices = pegarGrauDeSaidaDosVertices(matriz, ehDirigido);
        int grauDeReferencia = grauDosVertices.get(0);
        if (matriz.length == 0) {
            return false;
        }
        for (int i = 1; i < grauDosVertices.size(); i++) {
            if (grauDosVertices.get(i) != grauDeReferencia) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> pegarGrauDeSaidaDosVertices(int[][] matriz, boolean ehDirigido) {
        ArrayList<Integer> grauDosVertices = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            int grau = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                if (!ehDirigido && i == j) {
                    grau += (matriz[i][j] * 2);
                } else {
                    grau += matriz[i][j];
                }
            }
            grauDosVertices.add(grau);
        }
        return grauDosVertices;
    }

    private static boolean ehUmGrafoCompleto(int[][] matriz, boolean ehDirigido) {
        int grauDeReferencia = matriz.length - 1;
        List<Integer> grauDosVertices = pegarGrauDeSaidaDosVertices(matriz, ehDirigido);
        for (int i = 0; i < matriz.length; i++) {
            if (grauDosVertices.get(i) != grauDeReferencia) {
                return false;
            }
        }
        return true;
    }

    private static boolean ehUmGrafoNulo(int[][] matriz, boolean ehDirigido) {
        List<Integer> grauDosVertices = pegarGrauDeSaidaDosVertices(matriz, ehDirigido);
        for (int i = 0; i < matriz.length; i++) {
            if (grauDosVertices.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean ehUmGrafoBipartido(int[][] matriz) {
        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();
        if (temLacos(matriz) || matriz.length <= 1) return false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!v1.contains(i) && !v2.contains(i) && i != j) {
                    if (matriz[i][j] > 0) {
                        if (v1.contains(j)) {
                            v2.add(i);
                        } else {
                            v1.add(i);
                            if (!v2.contains(j)) v2.add(j);
                        }
                    }
                } else if (v1.contains(i) && !v2.contains(i) && i != j) {
                    if (matriz[i][j] > 0) {
                        if (v1.contains(j)) return false;
                        if (!v2.contains(j)) v2.add(j);
                    }
                } else if (!v1.contains(i) && v2.contains(i) && i != j) {
                    if (matriz[i][j] > 0) {
                        if (v2.contains(j)) return false;
                        if (!v1.contains(j)) v1.add(j);
                    }
                }
            }
        }
        return true;
    }

    private static boolean temLacos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][i] > 0) {
                return true;
            }
        }
        return false;
    }
}