//Luiz Henrique Martendal
public class Passageiro {
	private String nome;
	private String telefone;
	private int idade;
	private float tarifaInteira = 5.0f;
	
	public Passageiro(String nome,String telefone, int idade) {
		this.setNome(nome);
		this.setIdade(idade);
		this.setTelefone(telefone);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Float getTarifa() {
		return this.tarifaInteira;
	}
}