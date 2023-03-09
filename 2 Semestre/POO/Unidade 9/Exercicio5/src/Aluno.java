import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Aluno implements Comparable<Aluno>, Serializable{
	@Serial
	private static final long serialVersionUID = 1L;
	private String nome;
	private LocalDate dataNascimento;
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("Nome não digitado.");
		}
		
	}
	
	public LocalDate getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(LocalDate data) {
		if (data != null) {
			this.dataNascimento = data;
		}else {
			throw new IllegalArgumentException("Data não digitada.");
		}
		
	}
	
	public int getIdade() {
		return Period.between(this.dataNascimento, LocalDate.now()).getYears();
	}
	
	public abstract String mostra();
	
	@Override
	public int compareTo(Aluno o) {
		return this.nome.compareTo(o.nome);
	}
}

