import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int horaEntrada, horaSaida, totalHoras = 0, minutoEntrada, minutosSaída, minutoTotal;
        double tarifa;
        System.out.print("Horário de entrada: ");
        horaEntrada = ler.nextInt();
        System.out.print("Minutos de entrada: ");
        minutoEntrada = ler.nextInt();
        System.out.print("Horário de saída: ");
        horaSaida = ler.nextInt();
        System.out.print("Minutos de saída:");
        minutosSaída = ler.nextInt();
        totalHoras = 0;
        
        if (horaEntrada > horaSaida){
            totalHoras = 24 - horaEntrada + horaSaida;
        }else if (horaEntrada < horaSaida){
            totalHoras = horaSaida - horaEntrada;
        }
        
        minutoTotal = Math.abs(minutoEntrada - minutosSaída);
        if (minutoTotal >= 30){
            totalHoras = totalHoras + 1;
        }else if (minutoEntrada < minutosSaída){
            totalHoras = minutosSaída + minutoEntrada;
        }
        
        switch (totalHoras){
            case 0:
            case 1:
            tarifa = 5.00;
            break;
            case 2:
            tarifa = 10.00;
            break;
            case 3:
            tarifa = 17.50;
            break;
            case 4:
            tarifa = 25.00;
            break;
            case 5:
            tarifa = 35.00;
            break;
            default:
            tarifa = 35 + (totalHoras - 5) * 10;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Para a sua felicidade, a tarifa vai custar: R$" + df.format(tarifa));
        
        ler.close();
    }
}
