import java.util.ArrayList;

public class Vendedor {
	private String nome;
	private ArrayList<Viagens> viagens = new ArrayList<>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addViagem(Viagens viagem) {
		this.viagens.add(viagem);
	}
	
	public double getValorAPagar() {
		int quilometragem = 0;
		for(Viagens v: viagens) {
			quilometragem += v.getKm();
		}
		double valorAPagar = 0;
		if (quilometragem >= 0 && quilometragem <= 150) {
			valorAPagar = quilometragem * 0.40;
		}else if (quilometragem > 150 && quilometragem <= 600) {
			valorAPagar = quilometragem * 0.38;
		}else if (quilometragem > 600) {
			valorAPagar = quilometragem * 0.35;
		}
		return valorAPagar;
	}
	
	public Viagens getViagemMenorQuilometragem() {
		int menor = Integer.MAX_VALUE;
		Viagens viagemMenor = null;
		for (Viagens v: viagens) {
			if (v.getKm() < menor) {
				viagemMenor = v;
				menor = v.getKm();
			}
		}
		return viagemMenor;
	}
	
	public int getTotalKm() {
		int total = 0;
		for (Viagens v: viagens) {
			total += v.getKm();
		}
		return total;
	}
	
	public Viagens getViagem(int numero) {
		return this.viagens.get(numero);
	}
	
	public int getQtdViagens() {
		return this.viagens.size();
	}
}
