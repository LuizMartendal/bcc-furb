import java.util.Scanner;

public class TempoDeJogo {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int hInicial, hFinal, duracao_do_jogo = 0;
        hInicial = ler.nextInt();
        hFinal = ler.nextInt();
        if (hFinal > hInicial){
            duracao_do_jogo = hFinal - hInicial;
        }else if (hInicial > hFinal){
            duracao_do_jogo = 24 - hInicial + hFinal;
        }else if (hFinal == hInicial){
            duracao_do_jogo = 24;
        }
        System.out.println("O JOGO DUROU " + duracao_do_jogo + " HORA(S)");
        ler.close();
    }
}
