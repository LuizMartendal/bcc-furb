import java.util.Scanner;

public class Exercicio26 {
 public static void main(String[] args) {
     Scanner ler = new Scanner(System.in);
     
     int valor_negado = 0, contador_de_trechos = 1, contador_negado = 0, contador_concorda = 0;
     double valor_pedagio = 0, km = 0;
     
    System.out.print("Valor de pedágio que Astoufo se nega a pagar: R$ "); 
    valor_negado = ler.nextInt();
    System.out.print("Custo do " + contador_de_trechos + "° pedágio: ");
    valor_pedagio = ler.nextDouble();
    while (valor_pedagio >= 0){
        contador_de_trechos++;
        if (valor_pedagio < 0){
            contador_de_trechos--;
            break;
        }
        System.out.print("Distância em KM: ");
        km = ler.nextDouble();
        

        if (valor_pedagio > valor_negado){
            contador_negado++;
        }else if (km > 150 && valor_pedagio < valor_negado){
            contador_concorda++;
        }
        
        System.out.print("Custo do " + contador_de_trechos + "° pedágio: ");
        valor_pedagio = ler.nextDouble();
        
    }
    System.out.println("Fim do programa.\n");
    System.out.println(contador_negado + " (trechos com valor acima do qual ele nega-se a pagar);");
    System.out.println(contador_de_trechos + " (quantidade de trechos informados);");
    System.out.println(contador_concorda + " (trechos acima de 150km com valor aceito por ele).");
    ler.close();
 }   
}
