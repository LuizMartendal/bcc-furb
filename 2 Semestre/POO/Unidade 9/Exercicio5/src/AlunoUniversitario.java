import java.io.Serializable;
import java.time.LocalDate;

public class AlunoUniversitario extends Aluno implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char formaIngresso;
	private Curso curso;
	
	public AlunoUniversitario(String nome, LocalDate data, char i, Curso curso) {
		this.setNome(nome);
		this.setDataNascimento(data);
		this.setFormaIngresso(i);
		this.addCurso(curso);
	}
	
	public String getFormaIngresso() {
		if (this.formaIngresso == 'V') {
			return "Vestibular";
		}else if (this.formaIngresso == 'E') {
			return "Enem";
		}else if (this.formaIngresso == 'S') {
			return "Seletivo especial";
		}else if (this.formaIngresso == 'T') {
			return "Transferência externa";
		}else {
			return "Transferência interna";
		}
	}
	
	public void setFormaIngresso(char i) {
		if (i == 'V' || i == 'E' || i == 'S' || i == 'T' || i == 'I') {
			this.formaIngresso = i;
		}else {
			throw new IllegalArgumentException("Tipo incorreto.");
		}
	}
	
	public void addCurso(Curso c) {
		if (c != null) {
			this.curso = c;
		}else {
			throw new IllegalArgumentException("Curso não adicionado. Porque é nulo.");
		}
	}
	
	public String mostra() {
		return this.getNome() + " é aluno universitário do curso de " + this.curso.getSigla() + " - " + this.curso.getNome() + ", ingressado pot " + this.getFormaIngresso();
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Destrutor do aluno: " + this.getNome());
	}
}
