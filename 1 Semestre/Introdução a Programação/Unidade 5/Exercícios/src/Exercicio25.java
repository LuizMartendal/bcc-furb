import java.util.Scanner;

public class Exercicio25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = 0, e = 0, contador_jogadas = 1;
        String pontuacao;
        System.out.println("Quem marcou ponto na " + contador_jogadas + "ª jogada?");
        pontuacao = sc.next().toUpperCase();
        while (d >= 0 || e >= 0){
            
            if (pontuacao.equals("D")){
                d++;
            }else if (pontuacao.equals("E")){
                e++;
            }else{
                System.out.println("Pontuação errada!!");
            }

            if (d == 21 && d - e >= 2){
                System.out.println("D ganhou!!");
                break;
            }else if (d > 21){
                if (d - e >= 2){
                    System.out.println("D ganhou!!");
                    break;
                }
            }
            if (e == 21 && e - d >= 2){
                System.out.println("E ganhou!!");
                break;
            }else if (e > 21){
                if (e - d >= 2){
                    System.out.println("E ganhou!!");
                    break;
                }
            }
            contador_jogadas++;
            System.out.println("Quem marcou ponto na " + contador_jogadas + "ª jogada?");
            pontuacao = sc.next().toUpperCase();
        }
        sc.close();
    }
}