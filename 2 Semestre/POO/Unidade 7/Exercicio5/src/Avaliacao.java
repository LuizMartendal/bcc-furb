
public class Avaliacao {
	private int qtdPagantes;
	private String opniaoGeral;
	
	public Avaliacao(int pag, String opn) {
		this.setQtdPagantes(pag);
		this.setOpniaoGeral(opn);
	}
	
	public int getQtdPagantes() {
		return this.qtdPagantes;
	}
	
	public void setQtdPagantes(int pag) {
		if (pag >= 0) {
			this.qtdPagantes = pag;
		}else {
			throw new IllegalArgumentException("Quantidade inválida.");
		}
	}
	
	public String getOpniaoGeral() {
		return this.opniaoGeral;
	}
	
	public void setOpniaoGeral(String opn) {
		if (!opn.isBlank()) {
			this.opniaoGeral = opn;
		}else {
			throw new IllegalArgumentException("Opinião não informada.");
		}
	}
}
