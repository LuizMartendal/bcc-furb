import java.util.Scanner;

public class Exercicio24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int contador = 1;
        double limite_diario = 0, peso = 0, peso_total = 0, detector_limite = 0;
        String resposta = "";
        System.out.print("Limite diário (em quilogramas): ");
        limite_diario = sc.nextDouble();
        limite_diario *= 1000;
        while (limite_diario > detector_limite){
            peso_total = peso + peso_total;
            System.out.print("Digite o peso do " + contador + "° peixe (em gramas): ");
            peso = sc.nextDouble();
            detector_limite = peso + detector_limite;
            System.out.print("Deseja informar o peso de mais um peixe: s (SIM) / n (NÃO)? ");
            resposta = sc.next();
            
            if (resposta.equals("s")){
                contador++;
                
            }else if (resposta.equals("n")){
                break;
            }
            
        }
        limite_diario /= 1000;
        detector_limite /= 1000;
        peso_total = peso_total / 1000; 
        if (detector_limite < limite_diario){
            System.out.println("Peso total da pesca: " + peso_total + "kg");
        }else if (detector_limite > limite_diario){
            System.out.println("Com a soma do último peixe, você ultrapassou o limite de peso. Alcançando " + detector_limite + "kg. O limite é " + limite_diario + "kg");

        }
        

        sc.close();
    }
}
