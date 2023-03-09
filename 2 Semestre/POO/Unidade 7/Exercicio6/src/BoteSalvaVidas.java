
public class BoteSalvaVidas extends Embarcacao{
	private boolean inflavel;
	private int qtdRemos;
	private int qtdColetes;
	
	public BoteSalvaVidas(Boolean inflavel, int qtdRemos, int qtdColetes, String regCapitania, int qtdPessoas) {
		super(regCapitania, qtdPessoas);
		this.setInflavel(isInflavel());
		this.setQtdRemos(qtdRemos);
		this.setQtdColetes(qtdColetes);
	}

	public boolean isInflavel() {
		return inflavel;
	}

	public void setInflavel(boolean inflavel) {
		this.inflavel = inflavel;
	}

	public int getQtdRemos() {
		return qtdRemos;
	}

	public void setQtdRemos(int qtdRemos) {
		if (qtdRemos >= 0) {
			this.qtdRemos = qtdRemos;
		}else {
			throw new IllegalArgumentException("Quantidade não informada.");
		}
	}

	public int getQtdColetes() {
		return qtdColetes;
	}

	public void setQtdColetes(int qtdColetes) {
		if (qtdColetes >= 0) {
			this.qtdColetes = qtdColetes;
		}else {
			throw new IllegalArgumentException("Quantidade não informada.");
		}
	}
	
	@Override
	public String verificaSeguranca() {
		if (this.getQtdColetes() >= this.getQtdPessoas()) {
			return "Bote Ok!";
		}else {
			int n = this.getQtdPessoas() - this.getQtdColetes();
			return "Insuficiência de " + n + " coletes salva-vidas.";
		}
	}
	
}
