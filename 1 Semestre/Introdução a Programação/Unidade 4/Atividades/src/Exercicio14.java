import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o dia:");
        int dia = ler.nextInt();
        System.out.println("Digite o mês:");
        int mes = ler.nextInt();
        System.out.println("Digite o ano:");
        int ano = ler.nextInt();
        if (dia > 0 && dia < 32 && mes > 0 && mes < 13 && ano > 0){
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
                System.out.println("Válida");
            }else if (mes != 2 && dia < 31){
                System.out.println("Válida");
            }else if (mes == 2 && dia < 29){
                System.out.println("Válida");
            }else if (ano % 4 == 0 && dia == 29 && !(ano % 100 == 0 && ano % 400 != 0)){
                System.out.println("Válida");
            }else{
                System.out.println("Não válida");
            }
        }else{
            System.out.println("Não válida");
        }
        ler.close();
    }
}
