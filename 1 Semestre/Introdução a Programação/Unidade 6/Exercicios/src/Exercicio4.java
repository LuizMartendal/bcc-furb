import java.util.Scanner;

public class Exercicio4 {
    public Exercicio4(){
        Scanner s = new Scanner(System.in);
        int vetor1[] = lerDados(s, "ventor[1]");
        int vetor2[] = lerDados(s, "vetor[2]");
        somaVetores(vetor1, vetor2);
        int soma[] = somaVetores(vetor1, vetor2);
        imprimirDados(soma, vetor1, vetor2);
        s.close();
    }

    public int[] lerDados(Scanner s, String nome){
        int vetor[] = new int[10];

        for (int i = 0; i < 10; i++){
            System.out.print("Adicione o " + (i + 1) + "° número: " + nome + " = ");
            vetor[i] = s.nextInt();
        }

        return vetor;
    }

    public int[] somaVetores(int vetor1[], int vetor2[]){
        int soma[] = new int[10];
        
        for (int i = 0; i < 10; i++){
            soma[i] = vetor1[i] + vetor2[i];
        }

        return soma;
    }

    public void imprimirDados(int soma[], int vetor1[], int vetor2[]){
        for (int i = 0; i < 10; i++){
            System.out.println("A soma do " + vetor1[i] + " + " + vetor2[i] + " = " + soma[i]);
        }
    }

    public static void main(String[] args) {
        new Exercicio4();
    }
}
