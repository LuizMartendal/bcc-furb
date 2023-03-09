import java.util.Random;

public class Luta {
	//Atributos
	private Lutador desafiado;
	private Lutador desafiante;
	private int rounds;
	private boolean aprovada;
	//Métodos públicos
	public void marcarLuta(Lutador lutador1, Lutador lutador2) {
		if (lutador1.getCategoria().equals(lutador2.getCategoria())
			&& lutador1 != lutador2) {
			this.aprovada = true;
			this.desafiado = lutador1;
			this.desafiante = lutador2;
		}else {
			this.aprovada = false;
			this.desafiado = null;
			this.desafiante = null;
		}
	}
	
	public void lutar() {
		if (this.aprovada) {
			System.out.println("### DESAFIADO ###");
			this.desafiado.apresentar();
			System.out.println("### DESAFIANTE ###");
			this.desafiante.apresentar();
			
			Random aleatorio = new Random();
			int vencedor = aleatorio.nextInt(3);
			System.out.println("===== RESULTADO =====");
			switch (vencedor) {
				case 0: //Empate
					System.out.println("Empatou!!!");
					this.desafiado.empatarLuta();
					this.desafiante.empatarLuta();
					break;
				case 1:
					System.out.println("Venceu " + this.desafiado.getNome() + "!!!");
					this.desafiado.ganharLuta();
					this.desafiante.perderLuta();
					break;
				case 2:
					System.out.println("Venceu " + this.desafiante.getNome() + "!!!");
					this.desafiado.perderLuta();
					this.desafiante.ganharLuta();
					break;
			}
			
		}else {
			System.out.println("A luta não pode acontecer!!!");
		}
	}
	//Métodos especiais
	public void setDesafiado(Lutador desafiado) {
		this.desafiado = desafiado;
	}
	public Lutador getDesafiado() {
		return this.desafiado;
	}
	public void setDesafiante(Lutador desafiante) {
		this.desafiante = desafiante;
	}
	public Lutador getDesafiante() {
		return this.desafiante;
	}
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}
	public int getRounds() {
		return this.rounds;
	}
	public void setAprovada(boolean aprovada) {
		this.aprovada = aprovada;
	}
	public boolean getAprovada() {
		return this.aprovada;
	}
}