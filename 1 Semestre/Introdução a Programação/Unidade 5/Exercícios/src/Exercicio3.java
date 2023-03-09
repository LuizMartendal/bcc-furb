public class Exercicio3 {
    public static void main(String[] args) {
        double divisao = 0;
        for (double sequencia = 1; sequencia <=100; sequencia++){
            divisao = 1 / sequencia + divisao;
            System.out.println("1 / " + sequencia + " = " + divisao);
            }
            System.out.println(divisao);
    }
}
