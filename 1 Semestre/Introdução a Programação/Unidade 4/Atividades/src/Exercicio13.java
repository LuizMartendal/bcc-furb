import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Carta 1:");
        int carta1 = ler.nextInt();
        System.out.println("Carta 2:");
        int carta2 = ler.nextInt();
        System.out.println("Carta 3:");
        int carta3 = ler.nextInt();
        int qtCartasBoas = 0;
        if (carta1 == 1 || carta1 == 2 || carta1 == 3){
            qtCartasBoas++;
        }
        if (carta2 == 1 || carta2 == 2 || carta2 == 3){
            qtCartasBoas++;
        }
        if ((carta3 == 1) || (carta3 == 2) || (carta3 == 3)){
            qtCartasBoas++;
        }
        if(qtCartasBoas == 1){
            System.out.println("Truco");
        }else if (qtCartasBoas == 2){
            System.out.println("Seis");
        }else if (qtCartasBoas == 3){
            System.out.println("Nove");
        }
        ler.close();
    }
}
