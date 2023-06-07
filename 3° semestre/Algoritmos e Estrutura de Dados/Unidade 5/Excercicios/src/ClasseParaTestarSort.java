import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;


class ClasseParaTestarSort {

    private static Veiculo[] vetor;
    private static Integer[] vetorInts;
    private static String[] vetorStrings;
    private static int[] tamanhos = {10, 500};

    public static void main(String[] args) {
        initializeClass();

        // a linha abaixo precisa ser alterada para a classe criada pela equipe
        Sort<Veiculo> meuAlgoritmo = new BubbleSort<>();

        long ultimoNanoTime, tempoExecucao;
        for (Integer i : tamanhos) {
            Veiculo[] vetorCopiado = Arrays.copyOf(vetor, i);
            System.out.println("Vetor com " + i + " veiculos");
            System.out.println(Arrays.toString(vetorCopiado));
            ultimoNanoTime = System.nanoTime();
            meuAlgoritmo.sort(vetorCopiado);
            tempoExecucao = System.nanoTime() - ultimoNanoTime;
            System.out.println("Vetor ORDENADO com " + i + " veiculos em "+tempoExecucao+" ns");
            System.out.println(Arrays.toString(vetorCopiado));
        }

        // a linha abaixo precisa ser alterada para a classe criada pela equipe
        Sort<Integer> meuAlgoritmo2 = new BubbleSort<>();

        for (Integer i : tamanhos) {
            Integer[] vetorCopiado = Arrays.copyOf(vetorInts, i);
            System.out.println("Vetor com " + i + " inteiros");
            System.out.println(Arrays.toString(vetorCopiado));
            ultimoNanoTime = System.nanoTime();
            meuAlgoritmo2.sort(vetorCopiado);
            tempoExecucao = System.nanoTime() - ultimoNanoTime;
            System.out.println("Vetor ORDENADO com " + i + " inteiros em "+tempoExecucao+" ns");
            System.out.println(Arrays.toString(vetorCopiado));
        }

        // a linha abaixo precisa ser alterada para a classe criada pela equipe
        Sort<String> meuAlgoritmo3 = new BubbleSort<>();

        for (Integer i : tamanhos) {
            String[] vetorCopiado = Arrays.copyOf(vetorStrings, i);
            System.out.println("Vetor com " + i + " Strings");
            System.out.println(Arrays.toString(vetorCopiado));
            ultimoNanoTime = System.nanoTime();
            meuAlgoritmo3.sort(vetorCopiado);
            tempoExecucao = System.nanoTime() - ultimoNanoTime;
            System.out.println("Vetor ORDENADO com " + i + " Strings em "+tempoExecucao+" ns");
            System.out.println(Arrays.toString(vetorCopiado));
        }
    }

    public static void initializeClass() {
        vetor = new Veiculo[tamanhos[tamanhos.length-1]];
        Veiculo veic;
        // geracao dos dados
        String nome, placa, modelo;
        int ano;

        for (int i = 0; i < vetor.length; i++) {
            nome = GeradorAleatorio.geraNome() + " " + i;
            placa = GeradorAleatorio.geraPlaca();
            modelo = GeradorAleatorio.geraModelo();
            ano = GeradorAleatorio.geraAno();
            vetor[i] = new Veiculo(placa, modelo, ano, nome);
        }

        Random r = new Random();
        vetorInts = new Integer[vetor.length];
        for (int i = 0; i < vetorInts.length; i++) {
            vetorInts[i] = r.nextInt(vetorInts.length*1000);
        }

        vetorStrings = new String[vetor.length];
        for (int i = 0; i < vetorStrings.length; i++) {
            vetorStrings[i] = GeradorAleatorio.geraNome()+" "
                    +GeradorAleatorio.geraModelo()+" "
                    +GeradorAleatorio.geraNome();
        }
    }
}

class GeradorAleatorio {

    private static Random geraNumero = new Random();
    private static String[] nomes = { "Jose", "Maria", "Pedro", "Joao", "Mario", "Paulo", "Paula", "Sandra", "Andre",
            "Carla" };
    private static String[] modelos = { "Gol", "Mobi", "Fox", "F-150", "C3", "Captur", "i30", "Fastback", "HRV",
            "Picanto" };

    private static int anoAtual = (LocalDate.now().getYear());

    public static String geraNome() {
        return nomes[geraNumero.nextInt(10)];
    }

    public static String geraPlaca() {
        String placa = "";
        for (int i = 0; i < 3; i++) {
            placa += (char) (65 + geraNumero.nextInt(26)); // ASCII 65 = A
        }
        placa += "-";
        for (int i = 0; i < 4; i++) {
            placa += (char) (48 + geraNumero.nextInt(10)); // ASCII 48 = 0
        }

        return placa;
    }

    public static String geraModelo() {
        return modelos[geraNumero.nextInt(10)];
    }

    public static int geraAno() {
        int redutor = geraNumero.nextInt(10);
        if (redutor > 8) {
            redutor = geraNumero.nextInt(60);
        } else {
            redutor = geraNumero.nextInt(20);
        }

        return anoAtual - redutor;
    }
}