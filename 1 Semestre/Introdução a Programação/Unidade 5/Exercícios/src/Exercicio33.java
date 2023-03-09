import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio33{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        int voto = 0, candidato_1 = 0, candidato_2 = 0, candidato_3 = 0, candidato_4 = 0;
        double votos_nulos = 0, votos_brancos = 0, somador_de_votos = 0;
        System.out.print("Digite o seu voto: ");
        voto = ler.nextInt();
        do {
            switch (voto){
                case 1: 
                candidato_1++;
                somador_de_votos++;
                break;
                case 2: 
                candidato_2++;
                somador_de_votos++;
                break;
                case 3: 
                candidato_3++;
                somador_de_votos++;
                break;
                case 4:
                candidato_4++;
                somador_de_votos++;
                break;
                case 5:
                votos_nulos++;
                somador_de_votos++;
                break;
                case 6:
                votos_brancos++;
                somador_de_votos++;
                break;
                default:
                System.out.println("Opção incorreta!!");
            } 
            System.out.print("Digite o seu voto: ");
            voto = ler.nextInt();
        } while (voto != 0);
        System.out.println("Candidato 1: " + candidato_1 + " votos");
        System.out.println("Candidato 2: " + candidato_2 + " votos");
        System.out.println("Candidato 3: " + candidato_3 + " votos");
        System.out.println("Candidato 4: " + candidato_4 + " votos");
        System.out.println((int)votos_nulos + " votos nulos");
        double percentual_nulo = (votos_nulos / somador_de_votos) * 100;
        System.out.println("Percentual de votos nulos: " + df.format(percentual_nulo) + "%");
        System.out.println((int)votos_brancos + " votos em branco");
        double percentual_branco = (votos_brancos / somador_de_votos) * 100;
        System.out.println("Percentual de votos em branco: " + df.format(percentual_branco) + "%");
        
        ler.close();
    }
}