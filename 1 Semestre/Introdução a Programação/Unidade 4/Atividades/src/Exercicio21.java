import java.util.Scanner;

public class Exercicio21 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Escreva sua massa corporal: ");
        double massa = ler.nextDouble();
        System.out.print("Escreva sua altura: ");
        double altura = ler.nextDouble();
        double imc = massa / Math.pow(altura, 2);
        if (imc < 18.5){
            System.out.println("Magreza");
        }else if (imc >= 18.5 && imc <= 24.9){
            System.out.println("Saudável");
        }else if (imc >= 25 && imc <= 29.9){
            System.out.println("Sobrepeso");
        }else if (imc >= 30 && imc <= 34.9){
            System.out.println("Obesidade Grau I");
        }else if (imc >= 35 && imc <= 39.9){
            System.out.println("Obesidade Grau II (severa)");
        }else if (imc >= 40){
            System.out.println("Obesidade Grau III (móbida)");
        }
        ler.close();
    }
}