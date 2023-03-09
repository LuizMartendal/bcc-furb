import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String nome, nome_mostrar = "";
        double pc, pv;
        double total_compra = 0, total_venda = 0;
        double lucro_10 = 0, lucro_10_20 = 0, lucro_20 = 0, lucro = 0, lucro_total;
        
        for (int qtd_mercadorias = 1; qtd_mercadorias <= 20; qtd_mercadorias++){
            System.out.print("Adicione o nome da mercadoria: ");
            nome = sc.next();
            nome_mostrar = nome_mostrar + nome + "\n";
            System.out.print("Adicione o preço de compra: R$");
            pc = sc.nextDouble();
            total_compra = pc + total_compra; 
            System.out.print("Adicione o preço de venda: R$");
            pv = sc.nextDouble();
            total_venda = pv + total_venda;
            lucro = (pv - pc) / pc * 100;
            if (lucro < 10){
                lucro_10++;
            }else if (lucro >= 10 && lucro <= 20){
                lucro_10_20++;
            }else if (lucro > 20){
                lucro_20++;
            }
        }
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println();            
            System.out.println("Quantidade de mercadorias que proporcionam lucro de menos de 10%: " + (int)lucro_10);
            System.out.println("Quantidade de mercadorias que proporcionam lucro entre 10% e 20%: " + (int)lucro_10_20);
            System.out.println("Quantidade de mercadorias que proporcionam lucro de mais de 20%: " + (int)lucro_20);
            System.out.println("Valor total em compras: R$" + df.format(total_compra));
            System.out.println("Valor total em vendas: R$" + df.format(total_venda));
            lucro_total = (total_venda - total_compra);
            System.out.println("Lucro total em vendas: R$" + df.format(lucro_total));
            lucro_total = (total_venda - total_compra) / total_compra * 100;
            System.out.println("Lucro total em vendas (em porcentagem): " + df.format(lucro_total) + "%");
        sc.close();
    }
}
