import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe a letra: ");
        String letra = ler.nextLine().toLowerCase();
        if (letra.equals("a") || letra.equals("e") || letra.equals("i") || letra.equals("o") || letra.equals("u")){
            System.out.println("É vogal");
        }else{
            System.out.println("É consoante");
        }
        ler.close();
    }
}
