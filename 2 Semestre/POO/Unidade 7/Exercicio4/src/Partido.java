//Luiz Henrique Martendal
import java.util.ArrayList;

public class Partido {
	private String nome;
	private int numero;
	private ArrayList<Vereador> vereadores = new ArrayList<>();
	
	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("Nome não prenchido");
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNumero(int numero) {
		if (numero > 9 && numero < 100) {
			this.numero = numero;
		}else {
			throw new IllegalArgumentException("Número não cadastrado. Deve ser maior que 9 e menor que 100.");
		}
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void addVereador(Vereador vereador) {
		if (vereador != null) {
			if (vereadores == null) {
				vereador.setPartido(this);
				vereadores.add(vereador);
			}else {
				boolean existe = false;
				for (Vereador v: vereadores) {
					if (v.getNome().equals(vereador.getNome())) {
						existe = true;
					}
					if (v.getPartido() == vereador.getPartido()) {
						existe = true;
					}
				}
				if (!existe) {
					vereador.setPartido(this);
					vereadores.add(vereador);
				}else {
					throw new IllegalArgumentException("Valores repetidos.");
				}
			}
		}else {
			throw new IllegalArgumentException("Vereador está nulo.");
		}
	}
	
	public Vereador getVereador(String nome) { // A interface pediu esse tipo de método. Não achei outra forma de fazer.
		if (vereadores != null) {
			for (Vereador v: vereadores) {
				if (nome == v.getNome()) {
					return v;
				}
			}
			throw new IllegalArgumentException("Vereador não encontrado.");
		}else {
			throw new IllegalArgumentException("Não há veereadores cadastrados.");
		}
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
	
	public ArrayList<Vereador> getVeresMaiorQMedia(double desempenho) {
		double media = desempenho;
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
	
	public ArrayList<Vereador> getVereadores(){
		if (vereadores != null) {
			return this.vereadores;
		}
		throw new IllegalArgumentException("Não há vereadores cadastrados.");
	}
	
	public String toString() {
		return this.nome;
	}
}