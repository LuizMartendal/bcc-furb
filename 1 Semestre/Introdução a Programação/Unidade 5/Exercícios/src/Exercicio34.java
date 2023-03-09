import java.util.Scanner;

public class Exercicio34 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double preco = 50;
        int opcao = 0, diaria = 0, contador_de_hospedes = 0;
        String nome = "";
      
        do {
            System.out.println("Selecione a opção: ");
            System.out.println("(1) encerrar a conta de um hóspede; \n(2) verificar número de contas encerradas;\n(3) sair.");
            System.out.print("Opção: ");
            opcao = ler.nextInt();
            
            switch (opcao){
                case 1:
                System.out.print("Nome do hóspede: ");
                nome = ler.next();
                System.out.print("Número de diárias: ");
                diaria = ler.nextInt();
                if (diaria < 15){
                    preco += 7.50 * diaria;
                    System.out.println("Nome: " + nome);
                    System.out.println("Total a ser pago: R$ " + preco);
                    contador_de_hospedes++; 
                }else if (diaria == 15){
                    preco += 6.50 * diaria;
                    System.out.println("Nome: " + nome);
                    System.out.println("Total a ser pago: R$ " + preco); 
                    contador_de_hospedes++; 
                }else if (diaria > 15){
                    preco += 5 * diaria;
                    System.out.println("Nome: " + nome);
                    System.out.println("Total a ser pago: R$ " + preco); 
                    contador_de_hospedes++; 
                }
                break;
                
                case 2:
                    System.out.println("Número de hóspedes que deixaram o hotel (número de contas encerradas): " + contador_de_hospedes);
                    break;
                
                case 3: 
                System.out.println("Programa encerrado!");
                break;

                default:
                System.out.println("Opção errada.");
            }
        } while (opcao != 3);
        ler.close();
    }
}
