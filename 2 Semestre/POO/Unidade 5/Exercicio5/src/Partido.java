import java.util.ArrayList;

public class Partido {
	private String nome;
	private int numero;
	private ArrayList<Vereador> vereadores = new ArrayList<>();
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNumero(int numero) {
		if (numero > 9 && numero < 100)
		this.numero = numero;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void addVereador(Vereador vereador) {
		this.vereadores.add(vereador);
		vereador.setPartido(this);
	}
	
	public double getMediaDeDesempenho() {
		double media = 0;
		for (Vereador v: vereadores) {
			media += v.getDesempenho();
		}
		return media / vereadores.size();
	}
	
	public int getTotalProjApres() {
		int soma = 0;
		for (Vereador v: vereadores) {
			soma += v.getQtdProjetosApres();
		}
		
		return soma;
	}
	
	public int getTotalProjAprov() {
		int soma = 0;
		for (Vereador v: vereadores) {
			soma += v.getQtdProjetosAprov();
		}
		return soma;
	}

	public Vereador getVereadorMaisProjAprov() {
		 int qtd = Integer.MIN_VALUE;
		 Vereador vereadorMais = null;
		 
		 for (Vereador v: vereadores) {
			 if (v.getQtdProjetosAprov() > qtd) {
				 qtd = v.getQtdProjetosAprov();
				 vereadorMais = v;
			 }
		 }
		 return vereadorMais;
	}
	
	public Vereador getVerPior() {
		if (this.vereadores.isEmpty()) {
			return null;
		}
		Vereador piorVereador = this.vereadores.get(0);
		double menorDesempenho = piorVereador.getDesempenho();
		for (Vereador v: vereadores) {
			double cmp = v.getDesempenho();
			if (cmp < menorDesempenho) {
				piorVereador = v;
				menorDesempenho = cmp;
			}
		}
		return piorVereador;
	}
	
	public ArrayList<Vereador> getVeresMaiorQMedia(double mediaCamara) {
		double media = mediaCamara;
		ArrayList<Vereador> vereadoresMaior = new ArrayList<>();
		for (Vereador v: vereadores) {
			double cmp = v.getDesempenho();
			if (cmp > media) {
				vereadoresMaior.add(v);
			}
		}
		return vereadoresMaior;
	}
	
	public int getQtdVereadores() {
		return this.vereadores.size();
	}
}
