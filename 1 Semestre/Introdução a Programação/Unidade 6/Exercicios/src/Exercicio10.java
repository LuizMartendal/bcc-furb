import java.util.Scanner;

public class Exercicio10{
    public Exercicio10(){
        Scanner s = new Scanner(System.in);
        
        int elementos = 0;
        do{
            System.out.print("Adicione a quantidade de elementos para o vetor: ");
            elementos = s.nextInt();

            if (elementos < 1 || elementos > 50){
                System.out.println("O número de elementos precisa ser maior que 0 e menor ou igual a 50");
            }
        }while (elementos < 1 || elementos > 50);

        int vetor[] = new int[elementos];
        int contador = 0;
        int escolha = 0;
        int retornaqtd = 0;
        int qtd_excluida = 0;

        do{
            System.out.println("Escolha uma das opções abaixo: ");
        
            System.out.println("1 - Incluir valor;\n"
            + "2 - Pesquisar valor;\n"
            +"3 - Alterar valor;\n"
            +"4 - Excluir valor;\n"
            +"5 - Mostrar valores;\n"
            +"6 - Ordenar valores;\n"
            +"7 - Inverter valores;\n"
            +"8 - Sair do sistema”: nesta opção deve ser finalizada a execução do programa.");
            System.out.print("Escolha: ");
            escolha = s.nextInt();
            switch (escolha){
                case 1:
                retornaqtd = incluir(vetor, elementos, s, contador);
                contador = retornaqtd;
                break;
                case 2:
                if (contador > 0){
                    pesquisar(vetor, contador, s);
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção!");
                }
                break;
                case 3:
                if (contador > 0){
                    alterar(vetor, contador, s);
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção!");
                }
                break;
                case 4:
                if (contador > 0){
                    qtd_excluida = excluir(s, vetor, elementos);
                    contador += qtd_excluida;
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção!");
                }
                break;
                case 5:
                if (contador > 0){
                    mostrar(vetor, contador);
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção!");
                }
                break;
                case 6:
                if (contador > 0){
                    ordenar(vetor, contador);
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção!");
                }
                break;
                case 7:
                if (contador > 1){
                    inverter(vetor);
                }else {
                    System.out.println("Você precisa incluir um valor primeiro para usar está opção! Ou você usou incluiu apenas um número!");
                }
                break;
                case 8:
                System.out.println("Programa finalizado!");
                break;
                default:
                System.out.println("Número incorreto!!");
                break;
            }
            
        }while (escolha != 8);
        s.close();
    }

    public int incluir(int vetor[], int elementos, Scanner s, int contador){
        int valor = 0;
        int cont = 0;
        String resposta = "sim";
        while (resposta.equals("sim")){
            if (contador < elementos){
                System.out.print("Inclua um valor ao vetor: ");
                valor = s.nextInt();
                for (int i = 0; i < elementos; i++){
                    if (valor == vetor[i] && i != contador){
                        System.out.println("Esse valor já existe no vetor!!");
                        break;
                    }else if (valor != vetor[i]){
                        cont++;
                    }
                }
                if (cont == elementos){
                    vetor[contador] = valor;
                }
                cont = 0;
                if (vetor[contador] == valor){
                    contador++;
                }
            }else if (contador == elementos){
                System.out.println("Vetor está cheio!!! Exclua um valor primeiro.");
            }

            System.out.println("Deseja adicionar algum valor? (sim) (nao)");
            resposta = s.next();
        }
        return contador;
    }

    public void pesquisar(int vetor[], int incluirValor, Scanner s){
        String resposta = "sim";
        int cont = 0;

        while (resposta.equals("sim")){
            System.out.print("Entre com o número que deseja pesquisar no vetor: ");
            int pesquisa = s.nextInt();
            for (int i = 0; i < incluirValor;i++){
                if (vetor[i] == pesquisa){
                    System.out.println(vetor[i] + " está no vetor[" + i + "]");
                    cont++;
                }
        }
            if (cont == 0) {
            System.out.println("Este número não existe!!");
        }

            System.out.println("Deseja pesquisar algum outro número? (sim) (nao)");
            resposta = s.next();
        }
        
    }

    public void alterar(int vetor[], int contador, Scanner s){
        String resposta = "sim";
        
        while (resposta.equals("sim")){
            System.out.println("Escolha o valor que deseja alterar: ");

        for (int i = 0; i < contador; i++){
            System.out.println(vetor[i]);
        }
        int escolha = s.nextInt();

        System.out.println("Deseja alterar por qual valor? ");
        int alterar = s.nextInt();
        int numAdicionado = 0;
        int filtro = 0;
        for (int i = 0; i < contador; i++){
            for (int j = 0; j < contador; j++){
                if (escolha == vetor[i] && alterar != vetor[j]){
                    numAdicionado++;
                    filtro = i;
                }
            }
            
        }
        if (numAdicionado == contador){
            vetor[filtro] = alterar;
        }else{
            System.out.println("Esse número não existe no vetor, ou você tentou alterar por um número que já existe!");
        }
        System.out.println("Deseja alterar algum valor? (sim) (nao)");
        resposta = s.next();
        }
    }

    public int excluir(Scanner s, int vetor[], int elementos){
        System.out.print("Adicone o número que você quer excluir do vetor: ");
        int excluir = s.nextInt();
        int bolha = 0;
        for (int j = 0; j < elementos; j++){
            if (vetor[j] == excluir){
                vetor[j] = 0;
                int i = j;
                while (i < elementos - 1){
                    bolha = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = bolha;
                    i++;
                }
            }
        }
        System.out.println("Número excluido com sucesso!!!");
        int contador = 0;
        contador--;
        return contador;
    }

    public void mostrar(int vetor[], int contador){
        System.out.println("Valores cadastrados no vetor:");
        for (int i = 0; i < contador; i++){
            System.out.println("Vetor[" + i + "] = " + vetor[i]);
        }
    }

    public void ordenar(int vetor[], int contador){
        int i = 0;
        int bolha = 0;
        do {
            if (vetor[i] > vetor[i + 1]){
                bolha = vetor[i];
                vetor[i] = vetor[i + 1];
                vetor[i + 1] = bolha;
                i = 0;
            }else{
                i++;
            }
            
        }while (i < contador - 1);
        System.out.println("Ordenado com sucesso!!!");
    }

    public void inverter(int vetor[]){
        int temp = 0;
        for (int i = 0; i < vetor.length; i++){
            for (int x = 0; x < i; x++){
                temp = vetor[i];
                vetor[i] = vetor[x];
                vetor[x] = temp;
            }
        }
        System.out.println("Vetor invertido!!");
    }

    public static void main(String[] args) {
        new Exercicio10();
    }

}