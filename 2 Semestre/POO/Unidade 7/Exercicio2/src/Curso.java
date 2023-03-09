
public class Curso {
	private String sigla;
	private String nome;
	
	public Curso(String nome, String sigla) {
		this.setNome(nome);
		this.setSigla(sigla);
	}
	
	public String getSigla() {
		return this.sigla;
	}
	
	public void setSigla(String sigla) {
		if (sigla != null) {
			if (sigla.length() == 3) {
				if (sigla.toUpperCase().matches("[A-Z]*") == true) {
					this.sigla = sigla;
				}else {
					throw new IllegalArgumentException("A sigla deve conter somente letras.");
				}
			}else {	
				throw new IllegalArgumentException("A sigla deve conter 3 letras.");
			}
		}else {
			throw new IllegalArgumentException("Sigla não digitada.");
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		if (nome != null) {
			if (nome.length() > 4) {
				this.nome = nome;
			}else {
				throw new IllegalArgumentException("Nome deve conter ao menos 5 caracteres.");
			}
		}else {
			throw new IllegalArgumentException("Nome não digitado.");
		}
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("Destrutor do curso: " + this.getSigla());
	}
	
	public String toString() {
		return this.sigla;
	}
}