import java.text.DecimalFormat;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat formatar = new DecimalFormat("0.000");
        double A = ler.nextDouble(); 
        double B = ler.nextDouble();
        double C = ler.nextDouble();
        double triangulo = (A * C) / 2;
        double raio = (C * C) * 3.14159;
        double trapezio = ((A + B) * C) / 2;
        double quadrado = B * B;
        double retangulo = A * B;
        System.out.println("TRIANGULO: " + formatar.format(triangulo));
        System.out.println("CIRCULO: " + formatar.format(raio));
        System.out.println("TRAPEZIO: " + formatar.format(trapezio));
        System.out.println("QUADRADO: " + formatar.format(quadrado));
        System.out.println("RETANGULO: " + formatar.format(retangulo));  
        ler.close();
    }
}
