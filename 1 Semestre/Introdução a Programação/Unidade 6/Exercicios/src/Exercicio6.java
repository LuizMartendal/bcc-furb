import java.util.Scanner;

public class Exercicio6 {
    
    public Exercicio6(){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Adicione a quantidade de elementos que o vetor possui: ");
        int elementos = s.nextInt();

        double vetor[] = lerDados(s, elementos);
        verificaDados(s, vetor, elementos);
        
        s.close();
    }

    public double[] lerDados(Scanner s, int elementos){
        
        double vetor[] = new double[elementos];

        for (int i = 0; i < elementos; i++){
            System.out.print("Adicione o " + (i + 1) + "° número: ");
            vetor[i] = s.nextDouble();
        }

        return vetor;
    }

    public void verificaDados(Scanner s, double vetor[], int elementos){
        System.out.print("Informe o valor a ser verificado: ");
        double valor = s.nextDouble();

        String nExiste = "";
        int contador = 0;

        for (int i = 0; i < elementos; i++){

            if (valor == vetor[i]){
                System.out.println("O valor " + valor + " está presente no vetor[" + i + "]");
            }else if (valor != vetor[i]){
                nExiste = "O valor " + valor + " não está presente em nenhum vetor!";
                contador += 1;
            }
        }

        if (contador == elementos){
            System.out.println(nExiste);
        }
        
    }

    public static void main(String[] args) {
        new Exercicio6();
    }
}
