import java.util.Scanner;

public class Exercicio3 {
    public Exercicio3(){
        Scanner s = new Scanner(System.in);
        double vetor[] = lerDados(s);
        double vetorAtualizado[] = atualizarDados(vetor);
        imprimirDados(vetorAtualizado);
        s.close();
    }

    public double[] lerDados(Scanner s){
        double vetor[] = new double[12];

        for (int i = 0; i < 12; i++){
            System.out.print("Adicione o " + (i + 1) + "° valor: ");
            vetor[i] = s.nextDouble();
        }

        return vetor;
    }

    public double[] atualizarDados(double vetorAtualizado[]){
        for (int i = 0; i < 12; i++){
            if (vetorAtualizado[i] % 2 != 0){
                vetorAtualizado[i] = (vetorAtualizado[i] * 0.05) + vetorAtualizado[i];
            }else if (vetorAtualizado[i] % 2 == 0){
                vetorAtualizado[i] = (vetorAtualizado[i] * 0.02) + vetorAtualizado[i];
            }
        }

        return vetorAtualizado;
    }

    public void imprimirDados(double vetor[]){
        for (int i = 0; i < 12; i++){
            System.out.println("Vetor [" + i + "] = " + vetor[i]);
        }
    }

    public static void main(String[] args) {
        new Exercicio3();
    }
}
