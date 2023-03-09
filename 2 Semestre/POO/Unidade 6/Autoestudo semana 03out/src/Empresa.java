// Luiz Henrique Martendal; Daniel de Paula;
import java.util.HashMap;

public class Empresa {
	private HashMap<String, Usuario> usuarios = new HashMap<>();
	 
	public void addUsuario(String nome) {
		Usuario u = new Usuario(nome);
		if (!nome.isBlank() || !nome.isEmpty()) {
			if (!usuarios.containsKey(nome)) {
				this.usuarios.put(nome, u);
			}else {
				throw new IllegalArgumentException("Usuário já cadastrado.");
			}
		}else {
			throw new IllegalArgumentException("O nome do usuário tem que ser prenchido.");
		}
		
	}
	
	public Usuario getUsuario(String nome) {
		if (!nome.equals("")) {
			if (usuarios.containsKey(nome)) {
			return this.usuarios.get(nome);
			}
			throw new IllegalArgumentException("Usuário não cadastrado.");
		}
		throw new IllegalArgumentException("O nome do usuário precisa ser prenchido.");
	}
	
	public double getFaturamento() {
		double valor = 0;
		if (!usuarios.isEmpty()) {
			for (Usuario u: usuarios.values()) {
				valor += u.valorPagar();
			}
			return valor;
		}
		return 0;
	}
	
	public LinhaTelefonica getTelefone(String numero) {
		if (!numero.isBlank() || !numero.isEmpty()) {
			for (Usuario u: usuarios.values()) {
				if (u.getTelefone(numero) != null) {
					return u.getTelefone(numero);
				}
			}
			throw new IllegalArgumentException("Número não encontrado.");
		}
		throw new IllegalArgumentException("Número não prenchido.");
	}
}
