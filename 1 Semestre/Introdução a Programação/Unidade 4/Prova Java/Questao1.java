public class Questao1 {
    public static void main(String[] args) {
        String cor = "Vermelha";
        String carro = "Fusca";
        if ((cor.equals("")) && (carro.equals(""))){
            System.out.println("Cor e Carro");
        }else{
            System.out.println("Teste Carro");
            if (carro.equals("")){
                System.out.println("Carro Vazio");
                System.out.println("Cor Vazia");
            }else{
                System.out.println("Carro Cadastrado");
            }
        }
        System.out.println("Outro Carro");
    }   
}
