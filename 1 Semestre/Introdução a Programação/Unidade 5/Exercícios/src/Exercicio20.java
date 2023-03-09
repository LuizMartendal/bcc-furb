import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tempo_segundo = 0;
        double kg = 0, desconto = 0;
        System.out.print("Adicione a massa do material: ");
        kg = sc.nextDouble();
        desconto = kg * 0.01;
        while (kg >= 0.5){
            kg = kg - desconto;
            tempo_segundo += 1;
            System.out.println("Massa se decompondo: " + kg);
            System.out.println("Tempo: " + tempo_segundo + " segundos");
            
        }
        sc.close();
    }
}
