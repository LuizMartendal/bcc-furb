import java.util.Scanner;

public class Exercicio32 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int p = 0, n = 0, l = 0, c = 0, dia = 0, dia_semana = 7;
        String espaco = "";
        
        System.out.print("Especifique em que dia da semana cai o primeiro dia do mês (1=Domingo, 2=Segunda,...,7=Sábado): ");
        p = ler.nextInt();
        System.out.print("Quantos dias têm o mês? ");
        n = ler.nextInt();
        if (n >= 28 && n <= 31){
            System.out.print("D   S   T   Q   Q   S   S");
        }
        
        while (dia < n){
            if (n <= 27 || n > 31){
                System.out.println("Dia incorreto!");
                break;
            }
            while (l < 4){
                System.out.println("");
                while (l < 1){
                    for (c = p; c <= dia_semana; c++){
                        dia++;
                        if (dia == 1){
                            if (p > 1){
                                for (int conta = 1; conta < p; conta++){
                                espaco += "    ";
                            }
                            }
                            System.out.print(espaco + dia + "   ");
                        }else if (dia > 1 && dia < 10){     
                            System.out.print(dia + "   ");
                        }else{
                            System.out.print(dia + "  ");
                        }
                    } 
                    l++;
                    if (l == 1){
                        System.out.println("");
                    }
                }
                for (c = 1; c <= dia_semana; c++){
                    dia++;
                    if (dia > 0 && dia < 10){     
                        System.out.print(dia + "   ");
                    }else{
                        System.out.print(dia + "  ");
                    }
                }
                l++;
                if (l == 4){
                    System.out.println("");
                }
            }
            dia++;
            System.out.print(dia + "  ");
            l++;     
        }
        ler.close();       
    } 
}
    

