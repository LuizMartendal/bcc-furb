import java.util.Scanner;

public class LuizHenriqueMartendal_2 {

    public LuizHenriqueMartendal_2(){
        Scanner s = new Scanner (System.in);

        int tamanho_do_vetor = 0;
        System.out.print("Tamanho do vetor: ");
        do{
            tamanho_do_vetor = s.nextInt();

            if (tamanho_do_vetor <= 0){
                System.out.println("O tamanho dos vetores precisam ser maior que 0");
            }
        }while (tamanho_do_vetor <= 0);
        

        int vetA[] = lerVetor(s, " __ Lendo o VetA __", tamanho_do_vetor);
        int vetB[] = lerVetor(s, " __ Lendo o VetB __", tamanho_do_vetor);

        int vetSoma[] = somarVetores(vetA, vetB, tamanho_do_vetor);

        ordenarVetor(vetSoma, tamanho_do_vetor);
        imprimirVetor(vetSoma, tamanho_do_vetor);
        s.close();
    }

    public int[] lerVetor(Scanner s, String nome_vetor, int tamanho_do_vetor){
        System.out.println(nome_vetor);
        int vetor[] = new int[tamanho_do_vetor];

        for (int i = 0; i < tamanho_do_vetor; i++){
            System.out.print("VetA[" + i + "]: ");
            vetor[i] = s.nextInt();
        }

        return vetor;
    }

    public int[] somarVetores(int[] vetA, int[] vetB, int tamanho_do_vetor){
        int[] vetSoma = new int[tamanho_do_vetor];
        
        if (tamanho_do_vetor == 1){
            vetSoma[0] = vetA[0] + vetB[0];
        }else{
            for (int i = 0, j = tamanho_do_vetor - 1; i < tamanho_do_vetor && j >= 0; i++, j--){
            vetSoma[i] = vetA[i] + vetB[j];
        }
        }
        

        return vetSoma;
    }

    public void ordenarVetor(int[] vetSoma, int tamanho_do_vetor){
        int i = 0;
        int bolha = 0;
        
        if (tamanho_do_vetor > 1){
            do {
            if (vetSoma[i] > vetSoma[i + 1]){
                bolha = vetSoma[i];
                vetSoma[i] = vetSoma[i + 1];
                vetSoma[i + 1] = bolha;
                i = 0;
            }else{
                i++;
            }
        }while (i < tamanho_do_vetor - 1);
        }
        
        System.out.println("_ valores ordenados.");
    }

    public void imprimirVetor(int[] vetSoma, int tamanho_do_vetor){
        System.out.println(" __ Resultado __");

        for (int i = 0; i < tamanho_do_vetor; i++){
            System.out.println("VetSoma[" + i + "]: " + vetSoma[i]);
        }
    }
    public static void main(String[] args) {
        new LuizHenriqueMartendal_2();
    }
}
