//Luiz Henrique Martendal
public class Estudante extends Passageiro{
	private String escola;
	
	public Estudante(String nome, String telefone, int idade, String escola) {
		super(nome, telefone, idade);
		this.setEscola(escola);
	}
	
	public String getEscola() {
		return this.escola;
	}
	
	public void setEscola(String e) {
		this.escola = e;
	}
	
	public Float getTarifa() {
		return 2.5f;
	}
}
