import java.text.DecimalFormat;

public class Exercicio22 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        double salario = 2000, aumento = 0;
        int ano = 1995;
        System.out.println("Ano " + ano);
        System.out.println("Sálario R$ " + df.format(salario));
        aumento = 0.015;
        ano += 1;
        while (ano <= 2022){
            salario = salario + (salario * aumento);
            System.out.println("Ano " + ano);
            System.out.println("Sálario R$ " + df.format(salario));
            System.out.println("Aumento " + df.format(aumento * 100) + "%");
            ano++;
            aumento = aumento + aumento;
        }
    }
}
