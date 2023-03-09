import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        double mais_baixo = Double.MAX_VALUE, mais_alto = Double.MIN_VALUE;
        int contador_de_inscricoes = 0;
        double media = 0, soma = 0;
        
        System.out.print("Entre com o número de inscrição do atleta: ");
        int inscricao = ler.nextInt(), mostrar_numero1 = 0, mostrar_numero2 = 0;
        while (inscricao != 0){
            System.out.print("Digite a altura do atleta: ");
            double altura = ler.nextDouble();
            if (altura < mais_baixo){
                mais_baixo = altura;
                mostrar_numero1 = inscricao;
            }
            if (altura > mais_alto){
                mais_alto = altura;
                mostrar_numero2 = inscricao;
            }
            contador_de_inscricoes++;
            soma = altura + soma;
            media = soma / contador_de_inscricoes;
            System.out.print("Entre com o número de inscrição do atleta: ");
            inscricao = ler.nextInt();
        }
        System.out.println(mostrar_numero1 + " é o atleta mais baixo. Com a altura: " + mais_baixo);
        System.out.println(mostrar_numero2 + " é o atleta mais alto. Com a altura: " + mais_alto);
        System.out.println("Altura média dos atletas: " + media);
        System.out.println(contador_de_inscricoes);
        ler.close();
    }    
}
