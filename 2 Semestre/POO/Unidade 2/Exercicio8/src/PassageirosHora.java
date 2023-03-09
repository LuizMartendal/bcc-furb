
public class PassageirosHora {
	private int[][][] matriz = new int[12][30][24];
	
	public void adiciona(int dia, int mes, int hora) {
		this.matriz[mes - 1][dia - 1][hora]++;
	}
	
	public int quantosPassageiros(int dia, int mes) {
		int qtd_passageiros = 0;
		int d = dia-1;
		int m = mes-1;
		for (int h = 0; h < matriz[m][d].length; h++) {
			qtd_passageiros += this.matriz[m][d][h];
		}
		return qtd_passageiros;
	}
	
	public int mesMenorFluxo() {
		int mesMenor = 1;
		int qtdMenor = this.quantosPassageiros(1);
		for (int mes = 2; mes <= 12; mes++) {
			int qtde = this.quantosPassageiros(mes);
			if (qtde < qtdMenor) {
				qtdMenor = qtde;
				mesMenor = mes;
			}
		}
		return mesMenor;
	}
	
	public int quantosPassageiros(int mes) {
		int qtd_passageiros = 0;
		for (int dia = 1; dia <= matriz[mes - 1].length; dia++) {
			qtd_passageiros += this.quantosPassageiros(dia, mes);
		}
		return qtd_passageiros;
	}
	
	public int[] picoTransporte() {
		int qtd_passageiros = 0;
		int qtd_maior = 0;
		int momento[] = new int[3];
		for (int mes = 0; mes < matriz.length; mes++) {
			for (int dia = 0; dia < matriz[mes].length; dia++) {
				for (int h = 0; h < matriz[mes][dia].length; h++) {
					qtd_passageiros = this.matriz[mes][dia][h];
					if (qtd_passageiros > qtd_maior) {
						qtd_maior = qtd_passageiros;
						momento[0] = mes+1;
						momento[1] = dia+1;
						momento[2] = h;
					}
				}
			}
		}
		
		return momento;
	}
	
}
