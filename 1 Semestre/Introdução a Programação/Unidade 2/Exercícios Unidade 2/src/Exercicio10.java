import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int entrada = ler.nextInt();
        int horas = entrada / 3600;
        entrada = entrada % 3600;
        int minutos = entrada / 60;
        entrada = entrada % 60;
        int segundos = entrada / 60;
        DecimalFormat formatar = new DecimalFormat("00");   
        System.out.println(formatar.format(horas) + ":" + formatar.format(minutos) + ":" + formatar.format(segundos));

        ler.close();
    }
}
