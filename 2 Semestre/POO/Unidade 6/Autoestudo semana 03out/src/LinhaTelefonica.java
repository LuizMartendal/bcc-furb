// Luiz Henrique Martendal; Daniel de Paula;
import java.time.LocalDate;

public class LinhaTelefonica {
	private String tipo;
	private String nome;
	private String numero;
    private String enderecoInstalacao;
    private boolean temConexaoInternet;
    private int qtdOcorrencias;
    private String ramoAtividade;
    private LocalDate dataInstalacao;
    
    public LinhaTelefonica(String nome, String numero, String tipo, String endereco, LocalDate data) {
    	this.setNome(nome);
    	this.setNumero(numero);
    	this.setEnderecoInstalacao(endereco);
    	this.setTipo(tipo);
    	this.setDataInstalacao(data);
    }
    
	public String getTipo() {
		if (!this.tipo.isBlank() || !this.tipo.isEmpty()) {
			return tipo;
		}
		throw new IllegalArgumentException("Tipo não cadastrado.");
	}
	
	public void setTipo(String tipo) {
		if (!tipo.isBlank() || !tipo.isEmpty()) {
			if (tipo.toLowerCase().equals("comercial") || tipo.toLowerCase().equals("residencial") || tipo.toLowerCase().equals("especializado")) {
				this.tipo = tipo;
			}else {
				throw new IllegalArgumentException("Tipo incorreto.");
			}
		}else {
			throw new IllegalArgumentException("Tipo não prenchido.");
		}		
	}
	
	public String getNome() {
		if (!this.nome.isBlank() || !this.nome.isEmpty()) {
			return this.nome;
		}
		throw new IllegalArgumentException("Nome não foi cadastrado.");
	}
	
	public void setNome(String nome) {
		if (!nome.isBlank() || !nome.isEmpty()) {
			this.nome = nome;
		}else {
			throw new IllegalArgumentException("Nome não foi prenchido.");
		}
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		if (!numero.isBlank() || !numero.isEmpty()) {
			if (numero.length() == 10) {
				this.numero = numero;
			} else {
				throw new IllegalArgumentException("A quantidade de números deve ser 10.");
			}
		}else {
			throw new IllegalArgumentException("Número precisa ser prenchido.");
		}
		
	}
	
	public String getEnderecoInstalacao() {
		if (!this.enderecoInstalacao.isBlank() || !this.enderecoInstalacao.isEmpty()) {
			if (this.enderecoInstalacao != null) {
				return enderecoInstalacao;
			}
			throw new IllegalArgumentException("Cadastre o endereço");
		}
		throw new IllegalArgumentException("Endereço deve ser cadastrado.");
	}
	
	public void setEnderecoInstalacao(String enderecoInstalacao) {
		if (!enderecoInstalacao.isBlank() || !enderecoInstalacao.isEmpty()) {
			this.enderecoInstalacao = enderecoInstalacao;
		}else {
			throw new IllegalArgumentException("Endereço de instalação precisa ser prenchido.");
		}
	}
	
	public String getTemConexaoInternet() {
		if (tipo.toLowerCase().equals("residencial")) {
			if (this.temConexaoInternet == true) {
				return "Sim";
			}
			return "Não";
		}
		throw new IllegalArgumentException("Tipo selecionado deve ser residencial.");
	}
	
	public void setTemConexaoInternet(Boolean temConexaoInternet) {
		if (this.tipo.toLowerCase().equals("residencial")){
			this.temConexaoInternet = temConexaoInternet;
		}else {
			throw new IllegalArgumentException("É necessário que o tipo da linha seja residencial");
		}
	}
	
	public int getQtdOcorrencias() {
		if (tipo.toLowerCase().equals("especializado")) {
			return qtdOcorrencias;
		}
		throw new IllegalArgumentException("É necessário que o tipo de linha seja especializada.");
	}
	
	public void setQtdOcorrencias(int qtdOcorrencias) {
		if (this.tipo.toLowerCase().equals("especializado") && qtdOcorrencias > 0){
			this.qtdOcorrencias = qtdOcorrencias;
		}else {
			throw new IllegalArgumentException("É necessário que o tipo da linha seja especializado");
		}
	}
	
	public String getRamoAtividade() {
		if (!this.ramoAtividade.isBlank() || !this.ramoAtividade.isEmpty()) {
			if (tipo.toLowerCase().equals("comercial")) {
				return ramoAtividade;
			}
			throw new IllegalArgumentException("É necessário que o tipo seja comercial.");
		}
		throw new IllegalArgumentException("Ramo de atividade deve ser cadastrado.");
	}
	
	public void setRamoAtividade(String ramoAtividade) {
		if (!ramoAtividade.isBlank() || !ramoAtividade.isEmpty()) {
			if (this.tipo.toLowerCase().equals("comercial")){
				this.ramoAtividade = ramoAtividade;
			}else {
				throw new IllegalArgumentException("É necessário que o tipo da linha seja comercial");
			}
		}else {
			throw new IllegalArgumentException("Ramo de atividade precisa ser prenchido.");
		}
	}
	
	public LocalDate getDataInstalacao() {
		if (this.dataInstalacao != null) {
			if (this.dataInstalacao != null) {
				return dataInstalacao;
			}
			throw new IllegalArgumentException("É necessário que a data seja adicionada.");
		}
		throw new IllegalArgumentException("Data de instalação deve ser cadastrada.");
	}
	
	public void setDataInstalacao(LocalDate dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
    
	public double getValorFixo() {
		if (this.tipo.toLowerCase().equals("comercial")) {
			if (this.dataInstalacao.isBefore(LocalDate.of(2019, 1, 1))) {
	            return 25;
	        } else {
	            return 37.50;
	        }
		}else if (this.tipo.toLowerCase().equals("especializado")) {
			int qnt = this.getQtdOcorrencias();
	        
	        if (qnt > 0 && qnt < 1001) {
	            return 50;
	        } else if ( qnt < 5001) {
	            return 67.80;
	        } else if ( qnt < 10001) {
	            return 98.50;
	        } else if (qnt < 50001) {
	            return 123.90;
	        } else {
	            return 187.82;
	        }
		}
		return 15;
	}
}
