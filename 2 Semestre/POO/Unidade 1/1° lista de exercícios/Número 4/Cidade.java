
public class Cidade
{
    private String nome;
    private String uf;
    private int popMasc;
    private int popFem;
    private boolean calculado;
    
    public Cidade(){}
    
    public Cidade(String nome, int popFem, int popMasc)
    {
        this.setNome(nome);
        this.setPopFem(popFem);
        this.setPopMasc(popMasc);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setPopFem(int popFem){
        this.popFem = popFem;
    }
    
    public int getPopFem(){
        return this.popFem;
    }
    
    public void setPopMasc(int popMasc){
        this.popMasc = popMasc;
    }
    
    public int getPopMasc(){
        return this.popMasc;
    }
    
    

}
