public class Exercicio2{
    public static void main(String[] args){
        int somaImpar = 0, somaPar = 0;
        for (int numero = 1; numero <= 100; numero++ ){
            if (numero % 2 == 0){
                somaPar = (numero + somaPar);
            }else {
                somaImpar = numero + somaImpar;
            }
        }
        System.out.println("Soma Pares: ");
        System.out.println(somaPar);
        System.out.println("Soma Impares: ");
        System.out.println(somaImpar);
    }
}