import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String codigo;
	private HashMap<String, Conta> contas = new HashMap<>();
	
	public Cliente(String nome, String codigo) {
		super();
		this.setCodigo(codigo);
		this.setNome(nome);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome.isBlank()) {
			throw new IllegalArgumentException("Nenhum nome escrito.");
		}
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		if (codigo.isBlank()) {
			throw new IllegalArgumentException("Código não escrito.");
		}
		this.codigo = codigo;
	}
	
	public void criarConta(String numero) {
		if (contas.containsKey(numero)) {
			throw new IllegalArgumentException("Tem alguma conta com o mesmo número...");
		}
		Conta c = new Conta(numero, LocalDate.now());
		contas.put(c.getNumero(), c);
	}
	
	public void depositar(String numero, float valor) {
		if (contas.containsKey(numero)) {
			contas.get(numero).depositar(valor);
		}else {
			throw new IllegalArgumentException("Conta não existe.");
		}
	}
	
	public void sacar(String numero, float valor) {
		if (contas.containsKey(numero)) {
			float i = contas.get(numero).getSaldo();
			
			if (i >= valor) {
				contas.get(numero).sacar(valor);
			}else {
			 throw new IllegalArgumentException("Valor insuficiente.");	
			}
				
		}else {
			throw new IllegalArgumentException("Conta não existe.");
		}
	}
	
	public void sacar(float valor) {
		for (Conta c: contas.values()) {
			if (c.getSaldo() >= valor) {
				c.sacar(valor);
				break;
			}
			valor = valor - c.getSaldo();
			c.sacar(c.getSaldo());
		}
	}
	
	public void transferir(String c1, String c2, float valor) {
		if (contas.get(c1).getSaldo() >= valor) {
			contas.get(c1).sacar(valor);
			contas.get(c2).depositar(valor);
		}
	}
	
	public float getSaldo(String numero) {
		if (contas.containsKey(numero)) {
			return contas.get(numero).getSaldo();
		}
		throw new IllegalArgumentException("Conta não existe.");
	}
	@Override
	public String toString() {
		String str = "";
		for (Conta c: contas.values()) {
			str += "\nSaldo da conta " + c.getNumero() + ": " + c.getSaldo();
		}
		return "Cliente [nome=" + nome + ", codigo=" + codigo + "]\n" + str;
	}
	
	
}
