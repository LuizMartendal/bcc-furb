import java.util.Scanner;

public class Exercicio1 {
    
    public Exercicio1(){
        Scanner s = new Scanner(System.in);
        int[] numeros = lerDados(s);
        imprimirDados(numeros);
        s.close();
    }

    public int[] lerDados(Scanner s){
        int numeros[] = new int[10];

        for (int i = 0; i < 10; i++){
            System.out.println("Adicione o " + (i + 1) + "° número:");
            numeros[i] = s.nextInt();
        }

        return numeros;
    }

    public void imprimirDados(int resposta[]){
        for (int i = 9; i >= 0; i--){
            System.out.println(resposta[i]);
        }
    }

    public static void main(String[] args) {
        new Exercicio1();
    }
}
