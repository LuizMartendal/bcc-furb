public class Exercicio11 {
    public static void main(String[] args) {
        int biscoito = 1, totalQuebrado = 0;
        for (int horas_trabalhadas = 1, biscoitos_quebrados = 1; horas_trabalhadas <= 16 && biscoitos_quebrados <= 16; horas_trabalhadas++, biscoitos_quebrados = 3){
            biscoito = (biscoito * biscoitos_quebrados);
            totalQuebrado = biscoito + totalQuebrado;
            System.out.println("Na " + horas_trabalhadas + "° hora, a máquina quebra " + biscoito + " biscoito(s)");
        }
        System.out.println("Total de biscoitos quebrados em um dia: " + totalQuebrado);
    }
}
