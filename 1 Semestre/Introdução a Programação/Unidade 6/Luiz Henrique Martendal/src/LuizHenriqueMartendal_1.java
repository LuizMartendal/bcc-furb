import java.util.Scanner;

public class LuizHenriqueMartendal_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int opcao = 0, diarias = 0,  contas_encerradas = 0;
        double valor_diaria = 10;
        String nome = "";

        do{
            System.out.println("_________Controle de Hópedes_________");
            System.out.println("1. encerrar a conta de um hóspede" + "\n2. verificar número de contas encerradas" + "\n3. sair");
            System.out.print(" __opção: ");
            opcao = s.nextInt();

            switch (opcao){
                case 1:
                System.out.println(" _ Hóspede _ ");
                
                System.out.print("nome: ");
                nome = s.next();
                
                System.out.print("diárias: ");
                do{
                    diarias = s.nextInt();
                    if (diarias <= 0){
                        System.out.println("O número de diárias deve ser maior que zero!!");
                    }
                }while (diarias <= 0);
                
                System.out.println(" ___________\n");

                if (diarias < 7){
                    valor_diaria = valor_diaria * diarias + 7.30;
                }else if (diarias == 7){
                    valor_diaria = valor_diaria * diarias + 6.30;
                }else if (diarias > 7){
                    valor_diaria = valor_diaria * diarias + 5.30;
                }

                System.out.println("Nome : " + nome);
                System.out.println("Total: " + valor_diaria);
                contas_encerradas++;
                valor_diaria = 10;
                break;

                case 2:
                System.out.println(" _ Número de contas encerradas: " + contas_encerradas);
                break;

                case 3:
                break;

                default: 
                System.out.println("opção errada!");
            }

        }while (opcao != 3);

        s.close();
    }
}
