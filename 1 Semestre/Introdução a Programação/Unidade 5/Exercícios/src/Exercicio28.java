import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        String resposta = "s";
        int voto_1 = 0, voto_2 = 0, voto_3 = 0, voto_4 = 0;
        double percentual_1 = 0, percentual_2 = 0, percentual_3 = 0, percentual_4 = 0, contador = 0;
        System.out.println("Informe o seu voto: ");
        System.out.println("Código   Conjunto");
        System.out.println("1        Nenhum de Nós\n2        CPM22\n3        Stank\n4        Jota Quest");
        System.out.print("Voto: ");
        
        while (resposta.equals("s")){
            int codigo = sc.nextInt();
            if (codigo == 1){
                voto_1++;
                contador++;
            }else if (codigo == 2){
                voto_2++;
                contador++;
            }else if (codigo == 3){
                voto_3++;
                contador++;
            }else if (codigo == 4){
                voto_4++;
                contador++;
            }
            System.out.println("Mais um voto: s (SIM) / n (NÃO)?");
            resposta = sc.next().toLowerCase();
            if (resposta.equals("s")){
                System.out.println("Informe o seu voto: ");
                System.out.println("Código   Conjunto");
                System.out.println("1        Nenhum de Nós\n2        CPM22\n3        Stank\n4        Jota Quest");
                System.out.print("Voto: ");
            }else if (resposta.equals("n")){
                break;
            }
        }
        percentual_1 = (voto_1 / contador) * 100;
        percentual_2 = (voto_2 / contador) * 100;
        percentual_3 = (voto_3 / contador) * 100;
        percentual_4 = (voto_4 / contador) * 100;
        System.out.println("Total de votos do grupo Nenhum de Nós: " + voto_1 + "\nPercentual dos votos do grupo: " + df.format(percentual_1) + "%");
        System.out.println("Total de votos do grupo CPM22: " + voto_2 + "\nPercentual dos votos do grupo: " + df.format(percentual_2) + "%");
        System.out.println("Total de votos do grupo Stank: " + voto_3 + "\nPercentual dos votos do grupo: " + df.format(percentual_3) + "%");
        System.out.println("Total de votos do grupo: Jota Quest: " + voto_4 + "\nPercentual dos votos do grupo: " + df.format(percentual_4) + "%");
        if (voto_1 > voto_2 && voto_1 > voto_3 && voto_1 > voto_4){
            System.out.println("O grupo Nenhum de Nós é o vencedor!");
        }else if (voto_2 > voto_1 && voto_2 > voto_3 && voto_2 > voto_4){
            System.out.println("O grupo CPM22 é o vencedor!");
        }else if (voto_3 > voto_1 && voto_3 > voto_4 && voto_3 > voto_2){
            System.out.println("O grupo Stank é o vencedor!");
        }else if (voto_4 > voto_1 && voto_4 > voto_2 && voto_4 > voto_3){
            System.out.println("O grupo Jota Quest é o vencedor!");
        }else {
            System.out.println("Não houve um ganhador!");
        }
        sc.close();
    }
}
