import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero_paradas = 0;
        DecimalFormat df = new DecimalFormat("0.00");
        float combustivel_abastecido = 0, media_parada = 0, media_total = 0, quilometragem_registrada = 0, soma_combustivel = 0, soma_quilometragem = 0;
        System.out.print("Entre com o número total de reabastecimentos ");
        numero_paradas = sc.nextInt();
        for (int reabastecimento = 1; reabastecimento <= numero_paradas; reabastecimento++){
            System.out.print("Litro(s) de combustível abastecidos na " + reabastecimento + "º vez: ");
            combustivel_abastecido = sc.nextFloat();
            soma_combustivel = combustivel_abastecido + soma_combustivel;
            System.out.print("Quilometragem rodada: ");
            quilometragem_registrada = sc.nextFloat();
            soma_quilometragem = quilometragem_registrada + soma_quilometragem;
            media_parada = quilometragem_registrada / combustivel_abastecido;
            System.out.println("Média registrada na " + reabastecimento + "ª parada: " + df.format(media_parada) + "KM/L");
        }
        media_total = soma_quilometragem / soma_combustivel;
        System.out.println("A quilometragem média obtida por litro de combustível em toda viagem: " + df.format(media_total) + "KM/L");
        sc.close();
    }
}
