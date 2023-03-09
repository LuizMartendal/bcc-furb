import java.util.Scanner;

public class Exercicio23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int contador_de_vendedores = 1, qtd_produtos = 0, produto = 0, contador_produto = 0;
        double preco = 0, valor_vendido = 0, salario = 0, total_vendas = 0;
        String vendedor, resposta = "s".toLowerCase(), dados = "";
        
        System.out.print("Digite o nome do vendedor " + contador_de_vendedores + ": ");
        vendedor = sc.next();
        
        while (resposta.equals("s")){
           
            System.out.print("Entre com a quantidade de produtos: ");
            qtd_produtos = sc.nextInt();
            
            for (contador_produto = 1; contador_produto <= qtd_produtos; contador_produto++){
                System.out.print("Entre com a preço do " + contador_produto + "° produto: ");
                preco = sc.nextDouble();
                System.out.print("Entre com a quantidade vendida desse produto: ");
                produto = sc.nextInt();
                valor_vendido = preco * produto;
                total_vendas = valor_vendido + total_vendas;
                salario = valor_vendido * 0.30 + salario;
            }
            
            dados = dados + "Nome do vendedor: " + vendedor + "\nSalário: R$ " + salario + "\nTotal em vendas: R$ " + total_vendas + "\n";
            
            valor_vendido = 0;
            salario = 0;
            total_vendas = 0;
            
            System.out.println("Deseja digitar os dados de mais um vendedor: s (SIM) / n (NÃO)?");
            resposta = sc.next();
            
            if (resposta.equals("s")){
                contador_de_vendedores++;
                System.out.print("Digite o nome do vendedor " + contador_de_vendedores + ": ");
                vendedor = sc.next();
            }else if (resposta.equals("n")){
                break;
            }else {
                System.out.println("Resposta incorreta!!");
                break;
            }
            }
        
        System.out.println(dados);
        System.out.println(total_vendas );
        System.out.println(valor_vendido);
        sc.close();
        }
    }

