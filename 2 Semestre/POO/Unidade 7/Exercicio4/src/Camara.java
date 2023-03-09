//Luiz Henrique Martendal
import java.util.ArrayList;

public class Camara {
	private ArrayList<Partido> partidos = new ArrayList<>();
	
	public void addPartido(Partido partido) {
		if (partido != null) {
			if (partidos == null ) {
				this.partidos.add(partido);
			}else {
				boolean existe = false;
				for (Partido p: partidos) {
					if (partido.getNome().equals(p.getNome())) {
						existe = true;
					}
					if (partido.getNumero() == p.getNumero()) {
						existe = true;
					}
				}
				if (!existe) {
					this.partidos.add(partido);
				}else {
					throw new IllegalArgumentException("Valores repetidos...");
				}
			}
		}else {
			throw new IllegalArgumentException("Partido não prenchido.");
		}
	}
	
	public int getTotalProjApres() {
		int soma = 0;
		if (partidos != null) {
			for (Partido p: partidos) {
				soma += p.getTotalProjApres();
			}
			return soma;
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public Partido getPartido(String nome) { // A interface pediu esse tipo de método. Não achei outra forma de fazer.
		if (partidos != null) {
			for (Partido p: partidos) {
				if (p.getNome().equals(nome)) {
					return p;
				}
			}
			return null;
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public int getTotalProjAprov() {
		int soma = 0;
		if (partidos != null) {
			for (Partido p: partidos) {
				soma += p.getTotalProjAprov();
			}
			return soma;
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public Vereador getVereadorMaisProjAprov() {
		int qtd = Integer.MIN_VALUE;
		Vereador vereadorMais = null;
		if (partidos != null) {
			for (Partido p: partidos) {
				Vereador v = p.getVereadorMaisProjAprov();
				if (p.getTotalProjAprov() > qtd) {
					vereadorMais = v;
					qtd = p.getTotalProjAprov();
				}
			}
			return vereadorMais;
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public Vereador getVerPior() {
		Vereador vereadorPior = null;
		double piorMedia = Double.MAX_VALUE;
		if (partidos != null) {
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
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public ArrayList<Vereador> getVereadoresMaiorDesempenho() {
		double media = this.getMediaDesempenho();
		ArrayList<Vereador> vereadoresMaior = new ArrayList<>();
		if (partidos != null) {
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
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public double getMediaDesempenho() {
		double conta = 0;
		double somaMedia = 0;
		if (partidos != null) {
			for (Partido p: partidos) {
				somaMedia += p.getMediaDeDesempenho() * p.getQtdVereadores();
				conta += p.getQtdVereadores();
			}
			return somaMedia / conta;
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public int getQtdPartidos() {
		if (partidos != null) {
			return this.partidos.size();
		}
		throw new IllegalArgumentException("Não há partidos cadastrados.");
	}
	
	public ArrayList<Partido> getPartidos(){
		if (partidos != null) {
			return this.partidos;
		}
		throw new IllegalArgumentException("Não há nenhum partido cadastrado.");
	}
}
