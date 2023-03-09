import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n = ler.nextInt(), numero2 = 10, numero1 = 8;
        if (n > 2){
           for (int sequencia = 0; sequencia < n; sequencia++){
            if (sequencia % 2 == 0){
                System.out.print(numero1 + " ");
                numero1 = numero1 * 2;
                
            }else{
                System.out.print(numero2 + " ");
                numero2 = numero1 + 2;
                
            }
            
        } 
        }else{
            System.out.println("O número deve ser maior que 2!!");
        }
        
        ler.close();
    }
}
