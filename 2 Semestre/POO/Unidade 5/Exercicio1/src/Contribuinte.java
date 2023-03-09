
public class Contribuinte {
	
	private String nome = "";
	private String cpf = "";
	private String uf = "";
	private double rendaAnual = 0;
	
	public Contribuinte(String nome, String cpf, String uf, double rendaAnual) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setUf(uf);
		this.setRendaAnual(rendaAnual);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setUf(String uf) {
		if (uf.equals("RS") || uf.equals("PR") || uf.equals("SC")) {
			this.uf = uf;
		}
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setRendaAnual(double rendaAnual) {
		if (rendaAnual >= 0) {
			this.rendaAnual = rendaAnual;
		}
	}
	
	public double getRendaAnual() {
		return rendaAnual;
	}
	
	public double getAliquota() {
		double aliquota = 0;
		
		if (this.rendaAnual >= 0 && this.rendaAnual <= 4000) {
			aliquota = 0;
		}else if (this.rendaAnual >= 4001 && this.rendaAnual <= 9000) {
			aliquota = 0.058;
		}else if (this.rendaAnual >= 9001 && this.rendaAnual <= 25000) {
			aliquota = 0.15;
		}else if (this.rendaAnual >= 25001 && this.rendaAnual <= 35000) {
			aliquota = 0.275;
		}else if (this.rendaAnual > 35000) {
			aliquota = 0.30;
		}
		
		return aliquota;
	}
	
	public double calcularImposto() {
		return this.rendaAnual * this.getAliquota();
	}
	
}
