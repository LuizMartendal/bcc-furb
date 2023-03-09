import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        int pessoas_assistindo = 0, canais = 0, casas = 1, qtd_Canal4 = 0, qtd_Canal5 = 0, qtd_Canal9 = 0, qtd_Canal12 = 0;
        double media_Canal4 = 0, media_Canal5 = 0, media_Canal9 = 0, media_Canal12 = 0;
        
        System.out.println("Casa " + casas);
        System.out.println("Informe o canal: \n Opções: \n Canal 4; \n Canal 5; \n Canal 9; \n Canal 12;");
        System.out.print("Opção: ");
        canais = sc.nextInt();
        
        if (canais == 4 || canais == 5 || canais == 9 || canais == 12){ 
            
            while (canais != 0){      
                
                System.out.print("Informe o número de pessoas que estavam assistindo: ");
                pessoas_assistindo = sc.nextInt(); 
                if (canais == 4){
                    qtd_Canal4 = pessoas_assistindo + qtd_Canal4;
                }else if (canais == 5){
                    qtd_Canal5 = pessoas_assistindo + qtd_Canal5;
                }else if (canais == 9){
                    qtd_Canal9 = pessoas_assistindo + qtd_Canal9;
                }else if (canais == 12){
                    qtd_Canal12 = pessoas_assistindo + qtd_Canal12;
                }else {
                    System.out.println("Esse canal não existe!!");
                }

                casas++;
                System.out.println("Casa " + casas);
                System.out.println("Informe o canal: \n Opções: \n Canal 4; \n Canal 5; \n Canal 9; \n Canal 12;");
                System.out.print("Opção: ");
                canais = sc.nextInt();
                if (canais != 4 && canais != 5 && canais != 9 && canais != 12){
                    System.out.println("Esse canal não existe!!");
                }
            }
            
            double soma = qtd_Canal12 + qtd_Canal4 + qtd_Canal5 + qtd_Canal9;
            
            media_Canal4 = (qtd_Canal4 / soma) * 100;
            media_Canal5 = (qtd_Canal5 / soma) * 100;
            media_Canal9 = (qtd_Canal9 / soma) * 100;
            media_Canal12 = (qtd_Canal12 / soma) * 100;
            
            System.out.println("Percentual de audiência de cada canal:");
            System.out.println("Canal 4 possui " + df.format(media_Canal4) + "% de audiência;");
            System.out.println("Canal 5 possui " + df.format(media_Canal5) + "% de audiência;");
            System.out.println("Canal 9 possui " + df.format(media_Canal9) + "% de audiência;");
            System.out.println("Canal 12 possui " + df.format(media_Canal12) + "% de audiência;");

        }else {
            System.out.println("Esse canal não existe!!!");
        }
        sc.close();
    }
}
