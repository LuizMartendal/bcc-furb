
public class Pessoa
{
    
    private String nome;
    private char sexo;
    private String dataNascimento;
    private String estadoCivil = "Solteiro";
    
    public Pessoa(String nome, String dataNascimento, char sexo)
    {
        this.setNome(nome);
        this.setSexo(sexo);
        this.setDataNascimento(dataNascimento);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setSexo(char sexo){
        if (sexo == 'F' || sexo == 'M'){
            this.sexo = sexo;
        }
    }
    
    public char getSexo(){
        return this.sexo;
    }
    
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
    
    public String getEstadoCivil(){
        return this.estadoCivil;
    }
    
    public void setDataNascimento(String dataNascimento){
        this.dataNascimento = dataNascimento;
    }
    
    public String getDataNascimento(){
        return this.dataNascimento;
    }
    
    

    
}

