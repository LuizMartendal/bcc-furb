
public class Produto
{
    private String nome;
    private String descricao;
    private double precoUnitario;
    private double desconto;
    
    public Produto(String nome, String descricao, float precoUnitario, float desconto)
    {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPrecoUnitario(precoUnitario);
        this.setDesconto(desconto);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public void setPrecoUnitario(double precoUnitario){
        this.precoUnitario = precoUnitario;
    }
    
    public double getPrecoUnitario(){
        return this.precoUnitario;
    }
    
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
    
    public double getDesconto(){
        return this.desconto;
    }

}
