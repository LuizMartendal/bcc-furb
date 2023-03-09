import java.io.Serializable;
import java.time.LocalDate;

public class Conta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numero;
	private LocalDate dataAber;
	private float saldo = 0;
	
	public Conta(String numero, LocalDate dataAber) {
		super();
		this.setNumero(numero);
		this.setDataAber(dataAber);
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		if (numero.isBlank()) {
			throw new IllegalArgumentException("Número incorreto ou em branco.");
		}
		this.numero = numero;
	}
	
	public LocalDate getDataAber() {
		return dataAber;
	}
	
	public void setDataAber(LocalDate dataAber) {
		this.dataAber = dataAber;
	}
	
	public float getSaldo() {
		return this.saldo;
	}
	
	public void depositar(float valor) {
		if (valor < 1) {
			throw new IllegalArgumentException("Valor insuficiente para deposito.");
		}
		this.saldo += valor;
	}
	
	public void sacar(float valor) {
		if (valor < 1) {
			throw new IllegalArgumentException("Impossivel realizar saque com um valor negativo....");
		}
		if (valor > this.saldo) {
			throw new IllegalArgumentException("Saldo insuficiente.");
		}
		this.saldo -= valor;
	}
}
