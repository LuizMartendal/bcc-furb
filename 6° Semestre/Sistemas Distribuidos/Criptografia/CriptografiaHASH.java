package classes;
import java.security.*;

public class CriptografiaHASH {
    public static void main(String [] args)
    {
        //define a vari�vel do hash
        MessageDigest md = null;
        
        //cria uma mensagem
        String mensagem = "teste teste teste";
        
        try {
            //cria uma inst�ncia do gerador de hash
            md = MessageDigest.getInstance("SHA-1");
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //coloca a mensagem no gerador de hash
        md.update(mensagem.getBytes());
        
        //gera o hash
        byte [] resumo = md.digest();
        
        //sa�da do exemplo
        System.out.print("Resumo: ");
        for(int i = 0; i < resumo.length; i++)
            System.out.print((resumo[i] + 128) + " ");
     }
}