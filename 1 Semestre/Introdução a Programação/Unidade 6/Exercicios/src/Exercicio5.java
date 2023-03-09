import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String respostaMoca[] = new String[5];
        String respostaRapaz[] = new String[5];

         String respostas[] = {"Gosta de música sertaneja?", "Gosta de futebol?", "Gosta de seriados?" , "Gosta de redes sociais?" , "Gosta da Oktoberfest?"};

        for (int i = 0; i < respostas.length; i++){
            System.out.println(respostas[i]);
            respostaMoca[i] = s.next();
        }

        for (int i = 0; i < respostas.length; i++){
            System.out.println(respostas[i]);
            respostaRapaz[i] = s.next();
        }

        int afinidade = 0;

        for (int i = 0; i < 5; i++){
            if (respostaMoca[i].trim().equalsIgnoreCase(respostaRapaz[i])){
                afinidade += 3;
            }else if (respostaMoca[i].trim().equalsIgnoreCase("Sim") && respostaRapaz[i].trim().equalsIgnoreCase("Nao") || respostaMoca[i].trim().equalsIgnoreCase("Nao") && respostaRapaz[i].trim().equalsIgnoreCase("Nao")){
                afinidade -= 2;
            }else{
                afinidade += 1;
            }
        }

        if (afinidade == 15){
            System.out.println("Casem");
        }else if (afinidade >= 10 && afinidade <= 14){
            System.out.println("Voces tem muita coisa em comum!");
        }else if (afinidade >= 5 && afinidade <= 9 ){
            System.out.println("Talvez não de certo");
        }else if (afinidade <= 0 && afinidade <= 4){
            System.out.println("Vale um encontro");
        }else if (afinidade <= -1 && afinidade >= -9){
            System.out.println("Melhor não perder tempo");
        }else {
            System.out.println("Voces se odeiam!");
        }
        s.close();
    }
}
