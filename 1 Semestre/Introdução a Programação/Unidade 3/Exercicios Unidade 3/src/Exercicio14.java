import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        float distancia = ler.nextFloat();
        float tempo = ler.nextFloat();
        float autonomia = 12;
        float velocidademedia = distancia / tempo;
        float consumo = distancia / autonomia;
        System.out.println(velocidademedia);
        System.out.println(consumo);
        ler.close();
    }
}
