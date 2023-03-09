import java.util.Scanner;

public class SortSimples {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int valor1, valor2, valor3, n1 = 0, n2 = 0, n3 = 0;
        
        valor1 = ler.nextInt();
        valor2 = ler.nextInt();
        valor3 = ler.nextInt();
        
        if (valor1 > valor2 && valor1 > valor3){
            n3 = valor1;
        }else if (valor1 < valor2 && valor1 > valor3 || valor1 < valor3 && valor1 > valor2){
            n2 = valor1;
        }else if (valor1 < valor2 && valor1 < valor3){
            n1 = valor1;
        }
        if (valor2 > valor1 && valor2 > valor3){
            n3 = valor2;
        }else if (valor2 > valor1 && valor2 < valor3 || valor2 < valor1 && valor2 > valor3){
            n2 = valor2;
        }else if (valor2 < valor1 && valor2 < valor3){
            n1 = valor2;
        }
        if (valor3 > valor1 && valor3 > valor2){
            n3 = valor3;
        }else if (valor3 > valor1 && valor3 < valor2 || valor3 < valor1 && valor3 > valor2){
            n2 = valor3;
        }else if (valor3 < valor1 && valor3 < valor2){
            n1 = valor3;
        }
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println("");
        System.out.println(valor1);
        System.out.println(valor2);
        System.out.println(valor3);
        ler.close();
    }
}
