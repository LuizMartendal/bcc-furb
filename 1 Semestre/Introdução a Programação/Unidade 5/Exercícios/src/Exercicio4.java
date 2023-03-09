 
public class Exercicio4 {
    public static void main(String[] args) {
        double denominador = 0; double divisao = 0;
        for (double soma = 2, impar = 3; impar <=42 && soma <= 40; impar += 2, soma += 2){
            denominador = soma + denominador;
            divisao = impar / denominador + divisao;
            System.out.println(impar + " / " + denominador + " = " + divisao);
        }
        System.out.println("S = " + divisao);
    }

}
