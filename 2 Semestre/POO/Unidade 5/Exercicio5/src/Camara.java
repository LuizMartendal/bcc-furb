import java.util.ArrayList;

public class Camara {
	private ArrayList<Partido> partidos = new ArrayList<>();
	
	public void addPartido(Partido partido) {
		this.partidos.add(partido);
	}
	
	public int getTotalProjApres() {
		int soma = 0;
		for (Partido p: partidos) {
			soma += p.getTotalProjApres();
		}
		return soma;
	}
	
	public Partido getPartido(int numero) {
		for (Partido p: partidos) {
			if (p.getNumero() == numero) {
				return p;
			}
		}
		return null;
	}
	
	public int getTotalProjAprov() {
		int soma = 0;
		for (Partido p: partidos) {
			soma += p.getTotalProjAprov();
		}
		return soma;
	}
	
	public Vereador getVereadorMaisProjAprov() {
		int qtd = Integer.MIN_VALUE;
		Vereador vereadorMais = null;
		
		for (Partido p: partidos) {
			Vereador v = p.getVereadorMaisProjAprov();
			if (p.getTotalProjAprov() > qtd) {
				vereadorMais = v;
				qtd = p.getTotalProjAprov();
			}
		}
		return vereadorMais;
	}
	
	public Vereador getVerPior() {
		Vereador vereadorPior = null;
		double piorMedia = Double.MAX_VALUE;
		for (Partido partido: partidos) {
			if (partido != null) {
				double cmp = partido.getVerPior().getDesempenho();
				if (cmp < piorMedia) {
					vereadorPior = partido.getVerPior();
					piorMedia = cmp;
				}
			}
			
		}
		return vereadorPior;
	}
	
	public ArrayList<Vereador> getVereadoresMaiorDesempenho() {
		double media = this.getMediaDesempenho();
		ArrayList<Vereador> vereadoresMaior = new ArrayList<>();
		
		for (Partido p: partidos) {
			for (int i = 0; i < p.getVeresMaiorQMedia(this.getMediaDesempenho()).size(); i++) {
				double cmp = p.getVeresMaiorQMedia(this.getMediaDesempenho()).get(i).getDesempenho();
				if (cmp > media) {
					vereadoresMaior.add(p.getVeresMaiorQMedia(this.getMediaDesempenho()).get(i));
				}
			}
		}
		return vereadoresMaior;
	}
	
	public double getMediaDesempenho() {
		double conta = 0;
		double somaMedia = 0;
		for (Partido p: partidos) {
			somaMedia += p.getMediaDeDesempenho() * p.getQtdVereadores();
			conta += p.getQtdVereadores();
		}
		return somaMedia / conta;
	}
}
