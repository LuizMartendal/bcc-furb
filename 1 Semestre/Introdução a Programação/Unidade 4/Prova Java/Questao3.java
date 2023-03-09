import java.util.Scanner;

public class Questao3{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String tipo = ler.next().toUpperCase();
        if (tipo.equals("A")){
            System.out.println("Azul");
        }else if (tipo.equals("B")){
            System.out.println("Vermelho");
        }else if (tipo.equals("O")){
            System.out.println("Universal");
        }else{
            System.out.println("Tipo Incorreto");
        }
        ler.close();
    }
}