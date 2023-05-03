package Exercicio2;

public class Veiculo implements Comparable<Veiculo> {

    private String placa;
    private String modelo;
    private int ano;
    private String proprietario;

    public Veiculo(String placa, String modelo, int ano, String proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Veículo: " + this.modelo +
                "\nPlaca: " + this.placa +
                "\nAno: " + this.ano +
                "\nDe: " + this.proprietario;
    }

    @Override
    public int compareTo(Veiculo v) {
        if (this.placa.compareTo(v.placa) == 0) {
            return 0;
        }
        if (this.placa.compareTo(v.placa) > 1) {
            return 1;
        }
        return -1;
    }
}
