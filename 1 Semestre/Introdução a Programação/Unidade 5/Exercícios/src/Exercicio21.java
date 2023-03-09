
public class Exercicio21 {
    public static void main(String[] args) {
        double chico = 1.50, ze = 1.10, chico_centimetros = 0, ze_centimetros = 0;
        int anos = 0;
        chico_centimetros = chico * 100;
        ze_centimetros = ze * 100;
        while (chico >= ze){
            anos++;
            System.out.println("Ano " + anos);
            chico_centimetros += 2;
            ze_centimetros += 3;
            chico = chico_centimetros / 100;
            ze = ze_centimetros / 100;
            System.out.println("Idade de Chico " + chico);
            System.out.println("Idade de Zé " + ze);
        }
        System.out.println("Demorou " + anos + " anos, para que Zé ficasse maior que Chico.");
    }
}
