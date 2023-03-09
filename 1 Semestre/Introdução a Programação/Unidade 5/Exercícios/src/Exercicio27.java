import java.util.Scanner;

public class Exercicio27 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int dia = 0, resposta = 1, turno_manha = 0, turno_tarde = 0, producao = 0;
        double preco_peca = 0, salario = 0, maior_producao = Double.MIN_VALUE, soma_manha = 0, soma_tarde = 0;
        String dia_maior_producao = "";
       
        while (resposta == 1){
            System.out.print("Entre com algum dia de Abril: ");
            dia = ler.nextInt();
           
            if (dia > 0 && dia < 31){
                System.out.print("Total de peças produzidas no turno da manhã: ");
                turno_manha = ler.nextInt();
                soma_manha = soma_manha + turno_manha;
                System.out.print("Total de peças produzidas no turno da tarde: ");
                turno_tarde = ler.nextInt();
                soma_tarde = soma_tarde + turno_tarde;
                if (dia > 0 && dia < 16 && turno_manha + turno_tarde >= 100 && turno_manha >= 30 && turno_tarde >= 30){
                    preco_peca = 0.80;
                    producao = turno_manha + turno_tarde;
                    if (producao > maior_producao){
                        maior_producao = producao;
                        dia_maior_producao = dia_maior_producao + "Dia " + dia + " teve a maior produção. Com um total de: " + maior_producao + " peças.\n";                    }
                    salario = producao * preco_peca;
                    System.out.println("Valor recebido: R$ " + salario);
                }else if (dia > 0 && dia < 16){
                    preco_peca = 0.50;
                    producao = turno_manha + turno_tarde;
                    if (producao > maior_producao){
                        maior_producao = producao;
                        dia_maior_producao = dia_maior_producao + "Dia " + dia + " teve a maior produção. Com um total de: " + maior_producao + " peças.\n";                    }
                    salario = producao * preco_peca;
                    System.out.println("Valor recebido: R$ " + salario);
                }

                if (dia > 15 && dia < 31){
                    producao = turno_manha + turno_tarde;
                    if (producao > maior_producao){
                        maior_producao = producao;
                        dia_maior_producao = dia_maior_producao + "Dia " + dia + " teve a maior produção. Com um total de: " + maior_producao + " peças.\n";
                    }
                    preco_peca = 0.40;
                    turno_manha *= preco_peca;
                    preco_peca = 0.30;
                    turno_tarde *= preco_peca;
                    salario = turno_manha + turno_tarde;
                    System.out.println("Valor recebido: R$ " + salario);
                }
            }else {
                System.out.println("Dia inválido!!");
            }
            System.out.println("Novo funcionário (1.sim 2.não)");
            resposta = ler.nextInt();
        }
        System.out.println(dia_maior_producao);
        if (soma_manha > soma_tarde){
            System.out.println("O período que o funcionário mais produz é manhã. Totalizando com " + soma_manha + " peças.");
        }else if (soma_tarde > soma_manha){
            System.out.println("O período que o funcionário mais produz é tarde. Totalizando com " + soma_tarde + " peças.");
        }
        ler.close();
    }
}
