import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PassageirosHora ph = new PassageirosHora();
		int escolha = 0;
		System.out.print("Escolha uma das opções:"
				+ "\n 1. adicione mais um passageiro em determinada hora;"
				+ "\n 2. retorne a quantidade de passageiros transportados em determinado dia;"
				+ "\n 3. retorne o mês em que houve o menor fluxo de passageiros."
				+ "\n 4. retorne o dia, mês e hora em que houve a maior quantidade transportada de passageiros;"
				+ "\n 5. encerrar programa;"
				+"\n Escolha: ");
		escolha = s.nextInt();
		while (escolha != 5) {
			int mes, dia, hora = 0;
			switch (escolha) {
				case 1:
					System.out.print("Entre com o mês: ");
					mes = s.nextInt();
					System.out.print("Entre com o dia: ");
					dia = s.nextInt();
					System.out.print("Entre com a hora: ");
					hora = s.nextInt();
					ph.adiciona(dia, mes, hora);
				break;
				case 2:
					System.out.print("Entre com o mês: ");
					mes = s.nextInt();
					System.out.print("Entre com o dia: ");
					dia = s.nextInt();
					int qtde = ph.quantosPassageiros(dia, mes);
					System.out.println(qtde + " passageiros transportados no dia " + dia + " do mês " + mes);
				break;
				case 3:
					int menorFluxo = ph.mesMenorFluxo();
					System.out.println("O mês com menor fluxo foi: " + menorFluxo);
				break;
				case 4:
					int momento[] = new int[3];
					momento[0] = ph.picoTransporte()[0];
					momento[1] = ph.picoTransporte()[1];
					momento[2] = ph.picoTransporte()[2];
					System.out.println("Mês: " + momento[2] + " dia: " + momento[1] + " hora: " + momento[2] + " teve o maior fluxo");
				break;
				case 5:
					System.out.println("Programa encerrado");
				break;
				default:
					System.out.println("Opção incorreta!");
			}
			System.out.print("Escolha uma das opções:"
					+ "\n 1. adicione mais um passageiro em determinada hora;"
					+ "\n 2. retorne a quantidade de passageiros transportados em determinado dia;"
					+ "\n 3. retorne o mês em que houve o menor fluxo de passageiros."
					+ "\n 4. retorne o dia, mês e hora em que houve a maior quantidade transportada de passageiros;"
					+ "\n 5. encerrar programa;"
					+"\n Escolha: ");
			escolha = s.nextInt();
		}
		s.close();
	}
}
