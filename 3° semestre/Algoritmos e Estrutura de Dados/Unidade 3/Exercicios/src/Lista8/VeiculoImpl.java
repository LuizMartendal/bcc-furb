package Lista8;

public class VeiculoImpl implements Comparable<VeiculoImpl> {

    private final Veiculo veiculo;

    public VeiculoImpl(String placa, String modelo, int ano, String proprietario) {
        veiculo = new Veiculo(placa, modelo, ano, proprietario);
    }

    @Override
    public String toString() {
        return "Veículo: " + veiculo.getModelo() + "\n" +
                "Placa: " + veiculo.getPlaca() + "\n" +
                "Ano: " + veiculo.getAno() + "\n" +
                "de : " + veiculo.getProprietario();
    }

    @Override
    public int compareTo(VeiculoImpl o) {
        if (this.veiculo.getAno() < o.veiculo.getAno()) {
            return -1;
        }
        if (this.veiculo.getAno() == o.veiculo.getAno()) {
            return 0;
        }
        return 1;
    }
}
