import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio7{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double peso, valorPagar;
        System.out.print("Entre com o peso da carta: ");
        peso = ler.nextFloat();
        DecimalFormat formatar = new DecimalFormat("0.00");
        if (peso <= 50){
            valorPagar = 0.45;
            System.out.println("Custo do selo: R$" + valorPagar);
        }else{
            double pesoexcedido  = (peso - 50);
            double qAdicional = (pesoexcedido / 20) + 1;
            valorPagar = ((int)qAdicional * 0.45) + 0.45;
            //Gosto de usar qAdicional como int para o valor ser sempre 0,45, 0,90 e não 0,47, 0,94 ((int)qAdicional)
            System.out.println("Custo do selo: R$" + formatar.format(valorPagar));
        }
        ler.close();

    }
}