import java.util.Scanner;

public class Exercicio8 {
    
    public Exercicio8(){
        Scanner s = new Scanner(System.in);

        int elementos = 0;
        
        do {
            System.out.print("Adicione a quantidade de elementos que deseja adicionar ao vetor: ");
            elementos = s.nextInt();

            if (elementos < 1 || elementos > 20){
                System.out.println("O número de elementos deve ser maior que 0 e menor que 21!!");
            }

        }while(elementos < 1 || elementos > 20);

        double vetor[] = lerVetor(s, elementos);
        int contador = 0;
        int conta_zero = 0;
        double vetor_contador[] = new double[elementos];

        boolean resposta_contador;
        for (int i = 0; i < elementos; i++){
            resposta_contador = contador_n_diferentes(vetor, i, vetor_contador , elementos);
            if (resposta_contador != true){
                vetor_contador[i] = vetor[i];
                contador++;
            }
        }

        double vetor_n_diferentes[] = new double[contador];
    
        boolean resposta_vetor;
        for (int i = 0, h = 0; i < elementos && h < contador; i++, h++){
            resposta_vetor = vetor_n_diferentes(vetor_n_diferentes, i, h,vetor, elementos, contador);
            
            if (!resposta_vetor || resposta_vetor && vetor[i] == 0 && conta_zero < 1){
                vetor_n_diferentes[h] = vetor[i];
            }else if (resposta_vetor || vetor[i] == 0 && conta_zero >= 1){
                h--;
            }

            if (vetor[i] == 0){
                conta_zero++;
            }
        }

        int vetor_frequencia[] = frequencia(vetor, contador, elementos, vetor_n_diferentes);
        

        imprimirDados(vetor, vetor_n_diferentes, elementos, contador, vetor_frequencia);
        s.close();
    }

    public double[] lerVetor(Scanner s, int elementos){
        double vetor[] = new double[elementos];
        
        for (int i = 0; i < elementos; i++){
            System.out.print("Adicione o valor do vetor[" + i + "] : ");
            vetor[i] = s.nextDouble();
        }

        return vetor;
    }

    public boolean contador_n_diferentes(double vetor[], int i, double vetor_contador[], int elementos){
        
        for (int j = 0; j < elementos; j++){
            if (vetor[i] == vetor_contador[j] && i > j){
                return true;
            }
        }

        return false;
    }

    public boolean vetor_n_diferentes(double vetor_n_diferentes[], int i, int h, double vetor[], int elementos, int contador){
        
        for (int j = 0; j < contador; j++){
            if (vetor[i] == vetor_n_diferentes[j]){
                return true;
            }
        }

        return false;
    }

    public int[] frequencia(double vetor[], int contador, int elementos, double vetor_n_diferentes[]){
        int vetor_frequencia[] = new int[contador];

        for (int j = 0; j < contador; j++){
            for (int i = 0; i < elementos; i++){
                if (vetor[i] == vetor_n_diferentes[j]){
                vetor_frequencia[j] += 1;
            }
            }
        }

        return vetor_frequencia;
    }

    public void imprimirDados(double vetor[], double vetor_n_diferentes[], int elementos, int contador, int vetor_frequencia[]){
        System.out.println("");
        for (int i = 0; i < elementos; i++){
            System.out.print(vetor[i] + "\t");
        }

        System.out.println("\n \t\t\tNúmeros\tFrequência");

        for (int i = 0; i < contador; i++){
            
            System.out.println("\t\t\t" + vetor_n_diferentes[i] + "\t" + vetor_frequencia[i]);
            
        }
    }

    public static void main(String[] args) {
        new Exercicio8();
    }
}
