import java.util.Scanner;

public class Exercicio9 {
    public Exercicio9(){
        Scanner s = new Scanner(System.in);

        int qtd_pessoas = 30;
        int vetor_sexo[] = new int[qtd_pessoas], vetor_nota[] = new int[qtd_pessoas], vetor_idade[] = new int[qtd_pessoas];

        int contador = qtd_pessoas;
        for (int i = 0; i < qtd_pessoas; i++){
            System.out.println((i+1) + "° pessoa.");
            vetor_sexo[i] = ler_sexo(s);
            vetor_nota[i] = ler_nota(s);
            vetor_idade[i] = ler_idade(s);

            for (int j = 0; j < qtd_pessoas; j++){
                if (vetor_sexo[j] == 1){
                    contador--;
                }
            }
        }

        double media_total = calculo_media(vetor_nota, qtd_pessoas);
        
        double media_homens = 0;

        if (contador > 0){
             media_homens = calculo_m_homens(vetor_sexo, vetor_nota, qtd_pessoas);
        }
        
        int nota_mm_jovem = calculo_mm_jovem(vetor_sexo, vetor_nota, vetor_idade, qtd_pessoas);
        
        int mulheres_50_anos = contador_mulheres(vetor_sexo, vetor_nota, vetor_idade, qtd_pessoas, media_total);

        imprimirDados(media_total, media_homens, nota_mm_jovem, mulheres_50_anos, contador);

        s.close();
    }

    public int ler_sexo(Scanner s){
        int vetor_sexo = 0;
        
        do {
            System.out.print("Sexo (1 feminino 2 masculino): ");
            vetor_sexo = s.nextInt();

            if (vetor_sexo < 1 || vetor_sexo > 2){
                System.out.println("Respostas desejadas: 1 feminino ou 2 masculino!!!");
            }
        }while (vetor_sexo < 1 || vetor_sexo > 2);
        

        return vetor_sexo;
    }

    public int ler_nota(Scanner s){
        int vetor_nota = 0;

        do {
            System.out.print("Nota: ");
            vetor_nota = s.nextInt();

            if (vetor_nota < 0 || vetor_nota > 10){
                System.out.println("Nota deve ser maior ou igual a 0 ou menor que 10!!");
            }
        }while (vetor_nota < 0 || vetor_nota > 10);
    
        return vetor_nota;
    }

    public int ler_idade(Scanner s){
        int vetor_idade = 0;

        do {
            System.out.print("Idade: ");
            vetor_idade = s.nextInt();

            if (vetor_idade < 0){
                System.out.println("Idade tem que ser maior que 0!!");
            }
        }while (vetor_idade < 0);
        

        return vetor_idade;
    }

    public double calculo_media(int vetor_nota[], int qtd_pessoas){
        int soma = 0;
        double media = 0;

        for (int i = 0; i < qtd_pessoas; i++){
            soma += vetor_nota[i];
        }

        media = soma / qtd_pessoas;
        
        return media;
    }

    public double calculo_m_homens(int vetor_sexo[], int vetor_nota[], int qtd_pessoas){
        int soma = 0;
        double media_homens = 0;

        for (int i = 0; i < qtd_pessoas; i++){
            if (vetor_sexo[i] == 2){
                soma += vetor_nota[i];
            }
        }

        media_homens = soma / qtd_pessoas;

        return media_homens;
    }

    public int calculo_mm_jovem(int vetor_sexo[], int vetor_nota[], int vetor_idade[], int qtd_pessoas){
        double idade = Double.MAX_VALUE;
        int nota = 0;
        for (int i = 0; i < qtd_pessoas; i++){
            if (vetor_sexo[i] == 1 && vetor_idade[i] < idade){
                idade = vetor_idade[i];
            }

            if (vetor_sexo[i] == 1 && vetor_idade[i] == idade){
                nota = vetor_nota[i];
            }
        }

        return nota;
    }

    public int contador_mulheres(int vetor_sexo[], int vetor_nota[], int vetor_idade[], int qtd_pessoas, double media_total){
        int contador = 0;

        for (int i = 0; i < qtd_pessoas; i++){
            if (vetor_sexo[i] == 1 && vetor_idade[i] > 50 && vetor_nota[i] > media_total){
                contador++;
            }
        }

        return contador;
    }

    public void imprimirDados(double media_total, double media_homens, int nota_mm_jovem, int mulheres_50_anos, int contador){
        System.out.println("Nota média recebida pelo cinema: " + media_total);
        if (contador > 0){
            System.out.println("Nota média atribuída pelos homens: " + media_homens);
        }else{
            System.out.println("Nenhum homem avaliou...");
        }
        System.out.println("Nota atribuída pela mulher mais jovem: " + nota_mm_jovem);
        System.out.println("Mulheres com mais de 50 anos deram nota superior a média recebida pelo cinema: " + mulheres_50_anos);

    }

    public static void main(String[] args) {
        new Exercicio9();
    }

}
