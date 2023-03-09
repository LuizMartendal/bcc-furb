import java.util.Scanner;

public class ExemploMetodos {
    public ExemploMetodos(){

    }


    public int[] lerDados(){
        Scanner s = new Scanner(System.in);
        
        int dados[] = new int[3];
        System.out.println("Digite o número 1: ");
        int numero1 = s.nextInt();
        System.out.println("Digite o número 2: ");
        int numero2 = s.nextInt();
        System.out.println("Digite o sinal: + = 1, - = 2, * = 3, / = 4");
        int sinal = s.nextInt();

        dados[0] = numero1;
        dados[1] = numero2;
        dados[2] = sinal;


        s.close();

        return dados;
    }

    public int calculadora(char sinal, int numero1, int numero2){
        //int resultado = 0;

        switch (sinal){
            case 1: 
            return  numero1 + numero2;

            case 2: 
            return  numero1 - numero2;

            case 3: 
            return  numero1 * numero2;
            
            case 4:
            if (numero2 != 0){
                return  numero1 / numero2;
            }else{
                System.out.println("Número 2 não pode ser 0!");
            }
            
            default:
            System.out.println("Sinal errado!");
        }
        return 0;
    }

    public void imprimirValor(int resultado){
        System.out.println("Resultado: " + resultado);
    }
    public static void main(String[] args) {
        
        
    }
}
