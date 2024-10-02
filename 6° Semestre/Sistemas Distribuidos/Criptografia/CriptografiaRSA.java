package classes;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class CriptografiaRSA {
    
   public static void main(String args[]) throws Exception {
       
         // Gera um par de chaves RSA de 1024 bits  
         KeyPairGenerator gerador = KeyPairGenerator.getInstance("RSA");  
         gerador.initialize(1024);  
         KeyPair chaves = gerador.generateKeyPair();  

         // Cria uma implementa��o do RSA  
         Cipher cifra = Cipher.getInstance("RSA");  

         //Inicializa o algoritmo para criptografiar a mensagem com a chave p�blica  
         cifra.init(Cipher.ENCRYPT_MODE,chaves.getPublic());  

         // Criptgrafa o texto inteiro  
         byte[] mensagemCifrada = cifra.doFinal("teste".getBytes());  

         // Inicializa o algoritmo para decriptografar com a chave privada
         cifra.init(Cipher.DECRYPT_MODE,chaves.getPrivate());  
         
         // Decifra a mensagem
         byte[] mensagemOriginal = cifra.doFinal(mensagemCifrada);  

         //sa�das do exemplo        
         System.out.println("Chave Publica: "+chaves.getPublic().toString());  
         System.out.println("Chave Privada: "+chaves.getPrivate().toString());  

         System.out.print("A mensagem cifrada fica: ");  
         System.out.println(new String(mensagemCifrada));  
         
         System.out.print("A mensagem original era: ");  
         System.out.println(new String(mensagemOriginal));        
  }
   
}