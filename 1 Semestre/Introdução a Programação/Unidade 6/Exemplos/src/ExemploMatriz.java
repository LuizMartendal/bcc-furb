import java.util.Scanner;

public class ExemploMatriz{
    
    public ExemploMatriz(){
        Scanner s = new Scanner(System.in);
        int matriz[][] = new int[2][3];

        for (int col = 0; col < matriz.length; col++){
            for (int lin = 0; lin < matriz[col].length; lin++){
                matriz[col][lin] = s.nextInt();
            }
        }

        s.close();
    }

    public static void main(String[] args) {
        new ExemploMatriz();
    }
}