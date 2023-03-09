import java.io.Serializable;
import java.time.LocalDate;

public class AlunoEnsinoMedio extends Aluno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ano;
	
	public AlunoEnsinoMedio(String nome, LocalDate data, int ano) {
		this.setNome(nome);
		this.setDataNascimento(data);
		this.setAno(ano);
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public void setAno(int ano) {
		if (ano > 0 && ano < 4) {
			this.ano = ano;
		}else {
			throw new IllegalArgumentException("Ano deve ser um número de 1 até 3.");
		}
	}
	
	public String mostra() {
		return this.getNome() + " está cursando o " + this.getAno() + "° ano do ensino médio e tem " + this.getIdade();
	}
	
	@Override
	protected void finalize() throws Throwable{
		System.out.println("Destrutor do aluno: " + this.getNome());
	}
}
