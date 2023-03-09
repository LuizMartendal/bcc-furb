import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio2{
    
    public Exercicio2(){
        Scanner s = new Scanner(System.in);
        
        double vetor[] = lerDados(s);
        double media = calcular(vetor);
        informarValores(media, vetor);

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

    public double calcular(double vetor[]){
        double soma = 0;

        for (int i = 0; i < 12; i++){
            soma = soma + vetor[i];
        }

        double media = soma / 12;

        return media;
    }
    
    public void informarValores(double media, double vetor[]){
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < 12; i++){
            if (vetor[i] > media){
                System.out.println("Vetor[" + i + "] = " + vetor[i] + " é maior que a média: " + df.format(media));
            }
        }
    }

    public static void main(String[] args) {
        new Exercicio2();
    }
}