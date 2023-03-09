public class ExemplosVetores{
    public static void main(String[] args) {
        int numero[] = new int[5];
        int quantidade = 10;
        //String[] nomes = new String[quantidade];

        numero[0] = 10;
        numero[1] = 9;
        numero[2] = 8;
        numero[3] = 7;
        numero[4] = 6;

        for (quantidade = 0; quantidade < 5; quantidade++){
            System.out.println(numero[quantidade]);
        }
    }
}