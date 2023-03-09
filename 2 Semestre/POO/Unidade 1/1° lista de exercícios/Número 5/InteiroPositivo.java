//Aluno: Luiz Henrique Martendal

public class InteiroPositivo
{
    private int x;

    public void setValor(int valor){
        if (valor >= 0){
            this.x = valor;
        }else{
            System.out.print("O número precisa ser positivo!");
        }
    }
    
    public int getValor(){
        return this.x;
    }
    
    public long multiplicar(InteiroPositivo outro){
        return this.x * outro.getValor();
    }
    
    public long fatorial(){
        long fat = 1;
        for (int i = this.x; i > 1; i--){
            fat = fat * i;
        }
        return fat;
    }
    
    public String divisoresInteiros(){
        String divisores = "", resultado = "";
        int numero = this.x, quantidade = 0;
        
        for (int i = this.x; i > 0; i--){
            if(numero % i == 0){
                if(i == 1){
                   divisores = divisores + (numero / i);
                    quantidade++; 
                }else{
                    divisores = divisores + (numero / i) + ", ";
                    quantidade++;   
                }
            }
        }
        resultado = "Os divisores inteiros são " + divisores + " e a quantidade de divisores é " + quantidade;
        
        return resultado;
    }
    
    public int[] fibonacci(){
        int[] vetor = new int[this.x];
        vetor[0] = 1;
        vetor[1] = 1;
        for (int i = 2; i < this.x; i++){
            vetor[i] = vetor[i - 2] + vetor[i - 1];
        }
        
        return vetor;
    }
    
    public double valorH(){
        double h = 1;
        for (double i = 2; i <= this.x; i++){
            h = h + (1 / i);
            
        }
        
        return h;
    }
    
    public double valorI(){
        double i = 0;
        for (double j = 1; j <= this.x; j++){
            if (j > 1){
                i = i - (this.x - (j - 1)) / j; 
            }else{
                i = i + (this.x - (j - 1)) / j; 
            }
            
        }       

        return i;
    }
    
    public double valorP(){
        double p = 0;
        long vetorFat[] = new long[this.x];
            
        for (int i = 0; i < this.x; i++){
            vetorFat[i] = (i + 1) * 2;
            for (long j = vetorFat[i] - 1; j > 1; j--){
                vetorFat[i] = (vetorFat[i] * j);
                System.out.println(vetorFat[i]);
            }
            vetorFat[i] = vetorFat[i] / (i + 1);
        }
            
        for (int i = 0; i < this.x; i++){
            if(i > 1 && (i + 1) % 2 != 0){
                p = p - vetorFat[i];
            }else{
                p = p + vetorFat[i];
            }
        }
        
        return p;
    }
}



