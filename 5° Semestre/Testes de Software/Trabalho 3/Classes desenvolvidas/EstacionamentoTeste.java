    /*
 Bábara Moro
 Luiz Henrique Martendal
 Maria Júlia Testoni
 Nícolas Zimermann
 */

package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EstacionamentoTeste {
    private Estacionamento estacionamento;

    @Before
    public void configurarEstacionamento() {
        this.estacionamento = new Estacionamento(2);
    }

    @Test
    public void inserirVeiculoNoEstacionamentoVazio() {
        assertTrue(this.estacionamento.getVagasOcupadas() == 0);
        this.estacionamento.inserirVeiculo(new Veiculo("Opala", "ABC-1234"));
        assertEquals(1, this.estacionamento.getVagasOcupadas());
    }


    @Test(expected = RuntimeException.class)
    public void inserirVeiculoNoEstacionamentoCheio() {
        this.estacionamento.inserirVeiculo(new Veiculo("Opala", "ABC-1234"));
        this.estacionamento.inserirVeiculo(new Veiculo("Fusca", "ABC-1233"));
        this.estacionamento.inserirVeiculo(new Veiculo("Brasília", "ABC-1233"));
    }

    @Test
    public void removerVeiculoDoEstacionamento() {
        Veiculo veiculo = new Veiculo("Opala", "ABC-1233");
        this.estacionamento.inserirVeiculo(veiculo);
        this.estacionamento.removerVeiculo("ABC-1233");
        assertEquals(0, this.estacionamento.getVagasOcupadas());
    }

    @Test
    public void inserirVeiculoNoEstacionamentoJaOcupado() {
        this.estacionamento.inserirVeiculo(new Veiculo("Opala", "ABC-1233"));
        this.estacionamento.inserirVeiculo(new Veiculo("Fiat Uno", "ABC-1233"));
        assertEquals(2, this.estacionamento.getVagasOcupadas());
    }

    @Test
    public void calcularValorDoEstacionamento() {
        Veiculo veiculo = new Veiculo("Opala", "ABC-1233");
        this.estacionamento.inserirVeiculo(veiculo);
        //this.estacionamento.removerVeiculo("ABC-1233");
        assertEquals(10, this.estacionamento.removerVeiculo("ABC-1233"));
    }

}
