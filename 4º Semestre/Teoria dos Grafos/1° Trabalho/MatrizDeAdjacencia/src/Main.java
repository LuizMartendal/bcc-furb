import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {
                {0, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        };
        System.out.println("Tipo do Grafo: \n"+tipoDoGrafo(matriz)+"\nArestas do Grafo: \n"+arestasDoGrafo(matriz)+"\nGraus do Vértice: \n"+grausDoVertice(matriz)+"\nEste trabalho foi terminado ás 1:43 no dia 08/09/23 :)");
    }

    private static String tipoDoGrafo(int[][] matriz) {
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
        if (ehUmGrafoRegular(matriz)) {
            str += " Regular;";
            if (ehSimples) {
                boolean ehCompleto = ehUmGrafoCompleto(matriz);
                if (ehCompleto) {
                    str += " Completo;";
                } else {
                    str += " Não é um grafo completo;";
                }
            }
        }
        if (ehUmGrafoNulo(matriz)) {
            str += " Núlo";
        }
        if (ehUmGrafoBipartido(matriz)) {
            str += " Bipartido;";
        }
        return str;
    }

    private static String arestasDoGrafo(int[][] matriz) {
        String str = "";
        List<Integer> sequenciaDeGraus = pegarGrauDosVertices(matriz);
        Collections.sort(sequenciaDeGraus);
        if (ehUmGrafoDirigido(matriz)) {
            str = "\tQuantidade de arestas: " + sequenciaDeGraus.stream().mapToInt(Integer::intValue).sum() + "\n";
        } else {
            str = "\tQuantidade de arestas: " + sequenciaDeGraus.stream().mapToInt(Integer::intValue).sum() / 2 + "\n";
        }
        str += "\tE = { ";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    str += "(" + i + "," + j + ") ";
                }
            }
        }
        return str + "}";
    }

    private static String grausDoVertice(int[][] matriz) {
        String str = "\tV = { ";
        for (int i = 0; i < matriz.length; i++) {
            if (i == matriz.length - 1) {
                str += i + " }\n";
            } else {
                str += i + ", ";
            }
        }
        List<Integer> grauDosVertices = pegarGrauDosVertices(matriz);
        for (int i = 0; i < matriz.length; i++) {
            str += "\tGrau do vétice " + i + ": " + grauDosVertices.get(i) + "\n";
        }
        Collections.sort(grauDosVertices);
        str += "\tSequência de graus: (";
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

    private static boolean ehUmGrafoRegular(int[][] matriz) {
        List<Integer> grauDosVertices = pegarGrauDosVertices(matriz);
        int grauDeReferencia = grauDosVertices.get(0);
        if (grauDeReferencia == 0 || matriz.length <= 1) {
            return false;
        }
        for (int i = 1; i < grauDosVertices.size(); i++) {
            if (grauDosVertices.get(i) != grauDeReferencia) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> pegarGrauDosVertices(int[][] matriz) {
        ArrayList<Integer> grauDosVertices = new ArrayList<>();
        for(int i = 0; i < matriz.length; i++) {
            int grau = 0;
            for (int j = 0; j < matriz[0].length; j++) {
                grau += matriz[i][j];
            }
            grauDosVertices.add(grau);
        }
        return grauDosVertices;
    }

    private static boolean ehUmGrafoCompleto(int[][] matriz) {
        int grauDeReferencia = matriz.length - 1;
        List<Integer> grauDosVertices = pegarGrauDosVertices(matriz);
        for (int i = 0; i < matriz.length; i++) {
            if (grauDosVertices.get(i) != grauDeReferencia) {
                return false;
            }
        }
        return true;
    }

    private static boolean ehUmGrafoNulo(int[][] matriz) {
        List<Integer> grauDosVertices = pegarGrauDosVertices(matriz);
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
        if (temLacos(matriz)) {
            return false;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (!v2.contains(i) && i != j) {
                    if (!v1.contains(i)) {
                        v1.add(i);
                    }
                    if (!v2.contains(j) && matriz[i][j] != 0) {
                        if (v1.contains(j)) {
                            return false;
                        }
                        v2.add(j);
                    }
                }
                if (v2.contains(i) && i != j) {
                    if (!v1.contains(j) && matriz[i][j] != 0) {
                        if (v2.contains(j)) {
                            return false;
                        }
                        v1.add(j);
                    }
                }
            }
        }
        return true;
    }

    private static boolean temLacos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = i; j <= i; j++) {
                if (matriz[i][j] > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}