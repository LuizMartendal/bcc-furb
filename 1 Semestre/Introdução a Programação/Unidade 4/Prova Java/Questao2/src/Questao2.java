import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int hora_chegada = ler.nextInt();
        if (hora_chegada < 0 || hora_chegada > 23){
            System.out.println("Hora incorreta!");
        }
        int minutos_chegada = ler.nextInt();
        if (minutos_chegada < 0 || minutos_chegada > 59){
            System.out.println("Minutos Incorretos!");
        }
        int hora_saida = ler.nextInt();
        if (hora_saida < 0 || hora_saida > 23){
            System.out.println("Hora Incorreta!");
        }
        int minutos_saida = ler.nextInt();
        if (minutos_saida < 0 || minutos_saida > 59){
            System.out.println("Minutos Incorretos!");
        }
        int totalHoras = 0;
        int minuto_total = 0;
        double tarifa = 0;
        
        if (hora_chegada < hora_saida){
            totalHoras = hora_saida - hora_chegada;
        }
        if (minutos_chegada < minutos_saida){
                minuto_total = minutos_saida;
            }
        if (minuto_total > 29){
            totalHoras = totalHoras + 1;
        }

        switch (totalHoras){
            case 0:
            case 1:
            tarifa = 3.00;
            break;
            case 2:
            tarifa = 6.00;
            break;
            case 3: 
            tarifa = 14.00;
            break;
            case 4:
            tarifa = 25.50;
            break;
            default:
            tarifa = 25.50 + (totalHoras - 4) * 11.50;
        }
        System.out.println("R$ " + tarifa);
        ler.close();
    }
}

