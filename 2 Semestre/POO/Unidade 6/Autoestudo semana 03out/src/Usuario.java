// Luiz Henrique Martendal; Daniel de Paula;
import java.time.LocalDate;
import java.util.HashMap;

public class Usuario {
    private String nome;
    private HashMap<String, LinhaTelefonica> telefones = new HashMap<>();

    public Usuario(String nome) {
        this.setNome(nome);
    }

    public String getNome() {
    	return nome;
    }

    public void setNome(String nome) {
    	if (!nome.isBlank() || !nome.isEmpty()) {
    		this.nome = nome;
    	}else {
    		throw new IllegalArgumentException("Nome precisa ser prenchido.");
    	}
    	
    }
    
    public void addTelefone(String nome, String numero, String tipo, String endereco, LocalDate data) {
    	LinhaTelefonica t = new LinhaTelefonica(nome, numero, tipo, endereco, data);
    	if (!telefones.containsKey(numero)) {
    		telefones.put(numero, t);
    	}else {
    		throw new IllegalArgumentException("Número já cadastrado.");
    	}
    }
    
    public LinhaTelefonica getTelefone(String numero) {
    	return this.telefones.get(numero);
    }
    
    public double valorPagar() {
    	double valor = 0;
    	if (!telefones.isEmpty()) {
    		for (LinhaTelefonica t: telefones.values()) {
    			valor += t.getValorFixo();
    		}
    		return valor;
    	}
    	return 0;
    }
}
