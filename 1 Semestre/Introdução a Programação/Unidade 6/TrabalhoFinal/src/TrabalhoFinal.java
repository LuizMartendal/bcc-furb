import java.util.Scanner;

public class TrabalhoFinal {
    TrabalhoFinal(){
        Scanner s = new Scanner(System.in);

        String palavras[][] = new String[5][2];
        palavrasEntrada(palavras);
        char mapa[][] = new char[10][5];
        mapaEntrada(mapa);
        mapaPesquisa(palavras, mapa);
        
    int opcao = 0;  
    do{
        System.out.println("_____ Menu: Caça Palavras _____");
        System.out.println("opção 1: chamar o método palavrasImprimir;\n"+ 
                           "opção 2: chamar o método mapaImprimir;\n" +
                           "opção 3: chamar o método palavrasRepostas;\n"+
                           "opção 4: sair;\n");
        System.out.print("Digite a opção: ");
        opcao = s.nextInt();
        
        switch (opcao) {
            case 1:
                palavrasImprimir(palavras);
                break;
            
            case 2:
                mapaImprimir(mapa);
                break;
            
            case 3:
                palavrasRespostas(palavras, mapa);
                break;
            
            case 4:
            break;

            default:
                System.out.println("Opção inválida;");
                break;
        }

    } while (opcao != 4);
        s.close();
    }

    public String[][] palavrasEntrada(String palavras[][]){
        palavras[0][0] = "IFELSE";  
        palavras[1][0] = "FORA";  
        palavras[2][0] = "WHILE";  
        palavras[3][0] = "OBJ";  
        palavras[4][0] = "VETOR";   

        return palavras;
    }

    public char[][] mapaEntrada(char mapa[][]){
        mapa[ 0][ 0]='C';  mapa[ 0][ 1]='D';  mapa[ 0][ 2]='O';  mapa[ 0][ 3]='A';  mapa[ 0][ 4]='A';
        mapa[ 1][ 0]='I';  mapa[ 1][ 1]='X';  mapa[ 1][ 2]='F';  mapa[ 1][ 3]='O';  mapa[ 1][ 4]='R';
        mapa[ 2][ 0]='F';  mapa[ 2][ 1]='F';  mapa[ 2][ 2]='R';  mapa[ 2][ 3]='G';  mapa[ 2][ 4]='F';
        mapa[ 3][ 0]='E';  mapa[ 3][ 1]='L';  mapa[ 3][ 2]='I';  mapa[ 3][ 3]='H';  mapa[ 3][ 4]='W';
        mapa[ 4][ 0]='L';  mapa[ 4][ 1]='S';  mapa[ 4][ 2]='F';  mapa[ 4][ 3]='O';  mapa[ 4][ 4]='U';
        mapa[ 5][ 0]='S';  mapa[ 5][ 1]='D';  mapa[ 5][ 2]='G';  mapa[ 5][ 3]='T';  mapa[ 5][ 4]='S';
        mapa[ 6][ 0]='E';  mapa[ 6][ 1]='J';  mapa[ 6][ 2]='H';  mapa[ 6][ 3]='E';  mapa[ 6][ 4]='T';
        mapa[ 7][ 0]='I';  mapa[ 7][ 1]='I';  mapa[ 7][ 2]='I';  mapa[ 7][ 3]='J';  mapa[ 7][ 4]='M';
        mapa[ 8][ 0]='X';  mapa[ 8][ 1]='C';  mapa[ 8][ 2]='K';  mapa[ 8][ 3]='B';  mapa[ 8][ 4]='G';
        mapa[ 9][ 0]='P';  mapa[ 9][ 1]='E';  mapa[ 9][ 2]='T';  mapa[ 9][ 3]='O';  mapa[ 9][ 4]='R';

        return mapa;
    }

    public void mapaPesquisa(String palavras[][], char mapa[][]){
        String textoStr = "";
        int linha = 0, coluna = 0;
        int i = 0;

        do{
            char textoChar = palavras[i][0].charAt(0);
            for (int c = 0; c < 5; c++){
                for (int l = 0; l < 10; l++){
                    if (textoChar == mapa[l][c]){
                        for (int li = l; li < l + palavras[i][0].length() && li < 10; li++){ //verifica de cima para baixo
                            textoStr = textoStr +  mapa[li][c];
                        }
                        if (textoStr.equals(palavras[i][0])){
                            linha = l; coluna = c;
                            palavras[i][1] = "[" + linha + "] " + "[" + coluna + "]";
                        }
                        textoStr = "";
                        
                        for (int li = l; li > l - palavras[i][0].length() && li >= 0; li--){ //verifica de baixo para cima
                            textoStr = textoStr + "" + mapa[li][c] + "";
                        }
                        if (textoStr.equals(palavras[i][0])){
                            linha = l; coluna = c;
                            palavras[i][1] = "[" + linha + "] " + "[" + coluna + "]";
                        }
                        textoStr = "";

                        for (int co = c; co < c + palavras[i][0].length() && co < 5; co++){ //verifica da esquerda para direita
                            textoStr = textoStr + "" + mapa[l][co] + "";
                        }
                        if (textoStr.equals(palavras[i][0])){
                            linha = l; coluna = c;
                            palavras[i][1] = "[" + linha + "] " + "[" + coluna + "]";
                        }
                        textoStr = "";

                        for (int co = c; co > l - palavras[i][0].length() && co >= 0; co--){ //verifica da direita para esquerda
                            textoStr = textoStr + "" + mapa[l][co] + "";
                        }
                        if (textoStr.equals(palavras[i][0])){
                            linha = l; coluna = c;
                            palavras[i][1] = "[" + linha + "] " + "[" + coluna + "]";
                        }
                        textoStr = "";
                    }
                }
            }
            i++;
        } while (i < 5);   
    }

    public void palavrasImprimir(String palavras[][]){
        for (int i = 0; i < palavras.length; i++){
            System.out.println(palavras[i][0]);
        }
    }

    public void mapaImprimir(char mapa[][]){
        for (int i = 0; i < 10; i++){
            System.out.println(" --------------------------------- ");
            for (int j = 0; j < 5; j++){
                System.out.print(" | " + mapa[i][j]+ " | ");
            }
            System.out.println("");
        }
        System.out.println(" --------------------------------- ");
    }

    public void palavrasRespostas(String palavras[][], char mapa[][]){
        for (int i = 0; i < 5; i++){
            System.out.println(palavras[i][0] + " = " + palavras[i][1]);
        }
    }

    public static void main(String[] args) {
        new TrabalhoFinal();
    }
}
