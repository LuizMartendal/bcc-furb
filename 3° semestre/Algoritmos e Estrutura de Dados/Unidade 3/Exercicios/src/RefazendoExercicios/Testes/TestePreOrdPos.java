package RefazendoExercicios.Testes;

import RefazendoExercicios.ArvoreBST;
import RefazendoExercicios.ArvoreBinaria;
import RefazendoExercicios.NoArvoreBST;
import RefazendoExercicios.NoArvoreBinaria;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class TestePreOrdPos {

    public static void main(String[] args) {
        ArvoreBST<Integer> arvore = new ArvoreBST<>();

        arvore.inserir(3);
        arvore.inserir(1);
        arvore.inserir(2);
        arvore.inserir(5);
        arvore.inserir(4);
        arvore.inserir(6);

        System.out.println("Pré ordem: 3 1 2 5 4 6 = " + arvore);
        System.out.println("Ordem: 1 2 3 4 5 6 = " + arvore.toStringOrdered());
        System.out.println("Pós ordem: 2 1 4 6 5 3 = " + arvore.toStringPos());

        ArvoreBinaria<String> calculadora = new ArvoreBinaria<>();

        NoArvoreBinaria<String> no3 = new NoArvoreBinaria<>("3");
        NoArvoreBinaria<String> no6 = new NoArvoreBinaria<>("6");
        NoArvoreBinaria<String> no36 = new NoArvoreBinaria<>("+", no3, no6);

        NoArvoreBinaria<String> no4 = new NoArvoreBinaria<>("4");
        NoArvoreBinaria<String> no1 = new NoArvoreBinaria<>("1");
        NoArvoreBinaria<String> no41 = new NoArvoreBinaria<>("-", no4, no1);

        NoArvoreBinaria<String> no4136 = new NoArvoreBinaria<>("*", no36, no41);

        NoArvoreBinaria<String> no5 = new NoArvoreBinaria<>("5");
        NoArvoreBinaria<String> no54136 = new NoArvoreBinaria<>("+", no4136, no5);

        calculadora.setRaiz(no54136);

        System.out.println("Pré ordem: + * + 3 6 - 4 1 5 = " + calculadora);
        System.out.println("Ordem: ((3 + 6) * (4 - 1)) + 5 = " + calculadora.toStringOrdered());
        System.out.println("Pós ordem: 3 6 + 4 1 - * 5 + = " + calculadora.toStringPos());

        String[] list = calculadora.toStringPos().split(" ");

        int resultado = 0;

        List<Integer> operandos = new ArrayList<>();
        String operador = "";

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("+") || list[i].equals("-") || list[i].equals("*")) {
                operador = list[i];
                resultado = calcular(operandos, operador);
                operandos.remove(operandos.size() - 1);
                operandos.remove(operandos.size() - 1);
                operandos.add(resultado);
            } else {
                operandos.add(parseInt(list[i]));
            }
        }

        System.out.println(operandos);
    }

    public static int calcular(List<Integer> operandos, String operador) {
        return switch (operador) {
            case "+" -> operandos.get(operandos.size() - 2) + operandos.get(operandos.size() - 1);
            case "-" -> operandos.get(operandos.size() - 2) - operandos.get(operandos.size() - 1);
            case "*" -> operandos.get(operandos.size() - 2) * operandos.get(operandos.size() - 1);
            default -> 0;
        };
    }
}
