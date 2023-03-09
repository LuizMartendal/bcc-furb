//Luiz Henrique Martendal
import java.util.ArrayList;

public class Vereador {
	private String nome;
	private Partido partido;
	private ArrayList<ProjetoDeLei> projetos = new ArrayList<>();
	
	public Vereador(String nome) {
		this.setNome(nome);
	}
	
	public double getDesempenho() {
		int aprovado = this.getQtdProjetosAprov();
		int apresentado = this.getQtdProjetosApres();
		if (apresentado == 0) {
			return 0;
		}else if (apresentado > 0 && apresentado <= 5) {
			return ((double)aprovado / apresentado) * 0.80;
		}else if (apresentado > 5 && apresentado <= 10) {
			return ((double)aprovado / apresentado) * 1;
		}else if (apresentado > 10 && apresentado <= 17) {
			return ((double)aprovado / apresentado) * 1.08;
		}else {
			return ((double)aprovado / apresentado) * 1.22;
		}
	}
	
	public void addProjeto(ProjetoDeLei p) {
		if (p != null) {
			boolean existe = false;
			for (ProjetoDeLei a: projetos) {
				if (a.getTitulo().equals(p.getTitulo()) && a.getDataAprovacao() != null) {
					existe = true;
				}
			}
			if (!existe) {
				this.projetos.add(p);
				p.setNumeroProjeto(projetos.size());
			}else {
				throw new IllegalArgumentException("Projeto já cadastrado.");
			}
		}else {
			throw new IllegalArgumentException("Projeto de lei não criado.");
		}
	}
	
	public ProjetoDeLei getProjeto(int n) {
		if (projetos != null) {
			return projetos.get(n);
		}
		throw new IllegalArgumentException("Nenhum projeto cadastrado.");
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isBlank()) {
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("Nome não prenchido.");
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getQtdProjetosAprov() {
		int qtd = 0;
		for (ProjetoDeLei p: projetos) {
			if (p.getDataAprovacao() != null) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public int getQtdProjetosApres() {
		return projetos.size();
	}
	
	public void setPartido(Partido partido) {
		if (partido != null) {
			this.partido = partido;
		}else {
			throw new IllegalArgumentException("Partido não prenchido. Está nulo.");
		}
		
	}
	
	public Partido getPartido() {
		return this.partido;
	}
	
	public String toString() {
		return this.nome;
	}
	
}