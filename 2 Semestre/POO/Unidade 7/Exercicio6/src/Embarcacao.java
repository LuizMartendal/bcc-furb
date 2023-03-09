
public abstract class Embarcacao implements AtivoEmRisco{
	private String registroCapitania;
	private int qtdPessoas;
	
	public Embarcacao(String registroCapitania, int qtdPessoas) {
		this.setRegistroCapitania(registroCapitania);
		this.setQtdPessoas(qtdPessoas);
	}

	public String getRegistroCapitania() {
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) {
		if (registroCapitania != null) {
			this.registroCapitania = registroCapitania;
		}else {
			throw new IllegalArgumentException("Registro não informado.");
		}
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		if (qtdPessoas >= 0) {
			this.qtdPessoas = qtdPessoas;
		}else {
			throw new IllegalArgumentException("Quantidade de pessoas não informado.");
		}
	}
	
	@Override
	public abstract String verificaSeguranca();
}
