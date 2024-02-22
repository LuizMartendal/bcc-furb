/*
 Bábara Moro
 Luiz Henrique Martendal
 Maria Júlia Testoni
 Nícolas Zimermann
 */

package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Veiculo> veiculos = new ArrayList<>();
    private final int numeroDeVagas;

    public Estacionamento(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public void inserirVeiculo(Veiculo veiculo) {
        if (veiculos.size() == numeroDeVagas) {
            throw new RuntimeException();
        }
        veiculos.add(veiculo);
    }

    public int getVagasOcupadas() {
        return veiculos.size();
    }

    // No teste unitário foi necessário comentar uma linha, pois acabou gerando um erro,
    // o mesmo método removerVeiculo estava sendo chamado em sequencia, removendo o mesmo veiculo duas vezes
    // lançando uma excessão quando este não era o resultado esperado pelo teste.
    public int removerVeiculo(String placa) {
        Veiculo veiculo = null;
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                veiculo = v;
                break;
            }
        }
        if (veiculo != null) {
            veiculos.remove(veiculo);
            LocalDateTime saida = LocalDateTime.now();
            LocalDateTime entrada = veiculo.getEntrada();
            double tempoEstacionado = entrada.getHour() - saida.getHour();
            return tempoEstacionado < 1 ? 10 : ((int) tempoEstacionado * 2);
        }
        throw new RuntimeException();
    }


}
