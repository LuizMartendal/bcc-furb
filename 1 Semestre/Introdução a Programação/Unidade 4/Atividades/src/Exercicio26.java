import java.util.Scanner;

public class Exercicio26 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escolha uma opção: ");
        System.out.println("T: calcular a área de um triângulo");
        System.out.println("Q: calcular a área de um quadrado");
        System.out.println("R: calcular a área de um retângulo");
        System.out.println("C: calcular a área de um círculo");
        System.out.print("Opção: ");
        char opcao = ler.next().trim().charAt(0);
        switch (opcao){
            case 'T':
            System.out.println("Digite a base e a altura do triângulo: ");
            int base = ler.nextInt(), altura = ler.nextInt();
            System.out.println("Área do triângulo = " + (base * altura) / 2);
            break;
            case 'Q':
            System.out.println("Digite o lado: ");
            int lado = ler.nextInt();
            System.out.println("Área do quadrado: " + (lado * lado));
            break;
            case 'R':
            System.out.println("Digite a base e a altura do retângulo:");
            int b = ler.nextInt(), h = ler.nextInt();
            System.out.println("Área do retângulo: " + (b * h));
            break;
            case 'C':
            System.out.println("Digite o raio: ");
            int raio = ler.nextInt();
            System.out.println("Área do círculo: " + (Math.PI*Math.pow(raio, 2)));
            break;
        }
        ler.close();
    }
}
