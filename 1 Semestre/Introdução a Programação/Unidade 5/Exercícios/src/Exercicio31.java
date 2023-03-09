import java.util.Scanner;

public class Exercicio31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0, decomposicao = 2;
        String divisor_dois = "", divisor_tres = "";
        System.out.print("Entre com um número inteiro positivo: ");
        while (numero != 1){
            numero = sc.nextInt();
            while (numero % 2 == 0){
                divisor_dois = divisor_dois + (int)numero + "\t" + (int)decomposicao + "\n";
                numero /= decomposicao;
            } 
            while (numero % 3 == 0){
                decomposicao = 3;
                divisor_dois = divisor_dois + (int)numero + "\t" + (int)decomposicao + "\n";
                numero /= decomposicao;
            }
            decomposicao = numero;
            divisor_dois = divisor_dois + (int)numero + "\t" + (int)decomposicao + "\n";
            numero /= decomposicao;
            divisor_dois = divisor_dois + (int)numero ;
        }
        System.out.println("Número \tDecomposição");
        System.out.print(divisor_dois);
        System.out.print(divisor_tres);
        
        sc.close();
    }
}