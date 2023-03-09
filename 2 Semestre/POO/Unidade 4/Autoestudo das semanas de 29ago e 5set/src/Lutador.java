
public class Lutador {
	//Atributos
	private String nome;
	private String nacionalidade;
	private int idade;
	private double altura;
	private double peso;
	private String categoria;
	private int vitorias;
	private int derrotas;
	private int empates;
	//Métodos especiais
	public Lutador(String no, String na, int id, double al, double pe, int vi, int de, int em) {
		setNome(no);
		setNacionalidade(na);
		setIdade(id);
		setAltura(al);
		setPeso(pe);
		setVitorias(vi);
		setDerrotas(de);
		setEmpates(em);
	}
	public void setNome(String no) {
		this.nome = no;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNacionalidade(String na) {
		this.nacionalidade = na;
	}
	public String getNacionalidade() {
		return this.nacionalidade;
	}
	public void setIdade(int id) {
		this.idade = id;
	}
	public double getIdade() {
		return this.idade;
	}
	public void setAltura(double al) {
		this.altura = al;
	}
	public double getAltura() {
		return this.altura;
	}
	public void setPeso(double pe) {
		this.peso = pe;
		setCategoria();
	}
	public double getPeso() {
		return this.peso;
	}
	private void setCategoria() {
		if (peso < 52.2) {
			this.categoria = "Inválido";
		}else if (peso <= 70.3) {
			this.categoria = "Leve";
		}else if (peso <= 83.9) {
			this.categoria = "Médio";
		}else if (peso <= 120.2) {
			this.categoria = "Pesado";
		}else {
			this.categoria = "Inválido";
		}
	}
	public String getCategoria() {
		return this.categoria;
	}
	public void setVitorias(int vi) {
		this.vitorias = vi;
	}
	public int getVitorias() {
		return this.vitorias;
	}
	public void setDerrotas(int de) {
		this.derrotas = de;
	}
	public int getDerrotas() {
		return this.derrotas;
	}
	public void setEmpates(int em) {
		this.empates = em;
	}
	public int getEmpates() {
		return this.empates;
	}
	//Métodos públicos
	public void apresentar() {
		System.out.println("Lutador: " + getNome());
		System.out.println("Origem: " + getNacionalidade());
		System.out.println(getIdade() + " anos");
		System.out.println(getAltura() + " m  de altura");
		System.out.println("Pesando: " + getPeso() + "Kg");
		System.out.println("Ganhou: " + getVitorias());
		System.out.println("Perdeu: " + getDerrotas());
		System.out.println("Empatou: " + getEmpates());
	}
	public void Status() {
		System.out.println(getNome());
		System.out.println("é um peso " + getCategoria());
		System.out.println(getVitorias() + " vitórias");
		System.out.println(getDerrotas() + " derrotas");
		System.out.println(getEmpates() + " empates");
	}
	public void ganharLuta() {
		setVitorias(this.getVitorias() + 1);
	}
	public void perderLuta() {
		setDerrotas(this.getDerrotas() + 1);
	}
	public void empatarLuta() {
		setEmpates(this.getEmpates() + 1);
	}
}

