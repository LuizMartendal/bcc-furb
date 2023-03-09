import java.util.Scanner;

public class Exercicio7 {

    public Exercicio7(){
        Scanner s = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de elementos do vetor: ");
        int elementos = s.nextInt();
        
        while (elementos < 0 || elementos > 20){
            System.out.println("Valor incorreto!!");
            elementos = s.nextInt();
        }

        int vetor[] = lerDados(s, elementos);
        int vetor_ordenado[] = ordenarValores(vetor, elementos);
        imprimirDados(vetor_ordenado, elementos);
        s.close();  
    }

    public int[] lerDados(Scanner s, int elementos){
        int vetor[] = new int[elementos];

        for (int i = 0; i < elementos; i++){
            System.out.print("Adicione o " + (i + 1) + "° valor: ");
            vetor[i] = s.nextInt();
            for (int j = 0; j < elementos && j != i; j++){
                if (vetor[i] == vetor[j] && i != j){
                    System.out.println("Esse valor já foi adicionado!!!");
                    System.out.print("Adicione o " + (i + 1) + "° valor: ");
                    vetor[i] = s.nextInt();
                }
            }
        }

        return vetor;
    }

    public int[] ordenarValores(int vetor[], int elementos){
        int bolha = 0, i = 0;
        
        do{
            if (vetor[i] > vetor[i + 1]){
                bolha = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = bolha;
                i = 0;
            }else{
                if (i < elementos){
                    i += 1;
                }else{
                    break;
                }
                
            }
        }while(i < elementos - 1);

        return vetor;
    }

    public void imprimirDados(int vetor_ordenado[], int elementos){
        for (int j = 0; j < elementos; j++){

            if (j == elementos - 1){
                System.out.println(vetor_ordenado[j]);
            }else{
                System.out.print(vetor_ordenado[j] + " , ");
            }
        }
    }
    public static void main(String[] args) {
        new Exercicio7();
}
}
