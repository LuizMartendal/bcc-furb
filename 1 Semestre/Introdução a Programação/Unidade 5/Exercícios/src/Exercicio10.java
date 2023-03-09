
public class Exercicio10 {
    public static void main(String[] args) {
        int numero_esquerda = 0,numero_direita = 0; 
        double numero_Quadrado;
        for (int n = 1; n <= 999; n++){
            numero_esquerda = n / 10;
            numero_direita = n % 10;
            int soma = numero_esquerda + numero_direita;
            numero_Quadrado = Math.pow(soma, 2);
            if (numero_Quadrado == n){
                System.out.println(numero_esquerda + " + " + numero_direita + " = " + soma + " = " + soma + " * " + soma + " = " + n);
            }
            }
        for (int n1 = 2; n1 <= 99999; n1++){
            numero_esquerda = n1 / 100;
            numero_direita = n1 % 100;
            int soma = numero_esquerda + numero_direita;
            numero_Quadrado = Math.pow(soma, 2);
            if (numero_Quadrado == n1){
                System.out.println(numero_esquerda + " + " + numero_direita + " = " + soma + " = " + soma + " * " + soma + " = " + n1);
        }
        }
        for (int n2 = 2; n2 <= 999999; n2++){
            numero_esquerda = n2 / 1000;
            numero_direita = n2 % 1000;
            int soma = numero_esquerda + numero_direita;
            numero_Quadrado = Math.pow(soma, 2);
            if (numero_Quadrado == n2){
                System.out.println(numero_esquerda + " + " + numero_direita + " = " + soma + " = " + soma + " * " + soma + " = " + n2);
        }
        }
    } 
}