import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite a altura: ");
        double altura = ler.nextDouble();
        
        double media_feminino = 0, media_grupo = 0, contador_feminino = 0, contador_masculino = 0, soma_feminino = 0, soma_masculino = 0;
        
        while (altura != 0){
            System.out.print("Digite o sexo: ");
            String sexo = ler.next().toUpperCase().trim();
            if (sexo.equals("F")){
                contador_feminino++;
                soma_feminino = altura + soma_feminino;
                media_feminino = soma_feminino / contador_feminino;
            }else if (sexo.equals("M")){
                contador_masculino++;
                soma_masculino = altura + soma_masculino;
            }
            media_grupo = (soma_masculino + soma_feminino) / (contador_feminino + contador_masculino);
            System.out.println("Média de altura das mulheres: " + media_feminino);
            System.out.println("Média de altura do grupo: " + media_grupo);
            System.out.println("Digite a altura: ");
            altura = ler.nextDouble();
        }
        ler.close();
    }
}
