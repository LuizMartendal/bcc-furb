//Luiz Henrique Martendal
public class Idoso extends Passageiro{
	private String rg;
	
	public Idoso(String nome, String telefone, int idade, String rg) {
		super(nome,telefone,idade);
		this.setRg(rg);
	}
	
	public String getRg() {
		return this.rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public Float getTarifa() {
		float valor = 0f;
		if (this.getIdade() >= 60) {
			return (float) valor;
		}
		throw new IllegalArgumentException("É considerado um idoso, uma pessoa com 60 anos ou mais");
	}
}
