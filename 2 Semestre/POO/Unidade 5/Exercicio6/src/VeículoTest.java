
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class VeículoTest {

	@Test
	void test1QtdServicos() {
		Veículo v = new Veículo();
		Manutencao m1 = new Manutencao();
		m1.setCusto(25);
		m1.setDescricao("facil");
		m1.setNumero(1);
		m1.setTempoParado(60);
		v.addManutencao(m1);
		Manutencao m2 = new Manutencao();
		m2.setCusto(50);
		m2.setDescricao("medio");
		m2.setNumero(2);
		m2.setTempoParado(120);
		v.addManutencao(m2);
		Manutencao m3 = new Manutencao();
		m3.setCusto(25);
		m3.setDescricao("muito facil");
		m3.setNumero(1);
		m3.setTempoParado(60);
		v.addManutencao(m3);
		
		double esperado = 100 / 3;
		assertEquals(esperado, v.getCustoMedioManutencao());
	}
	
	@Test
	void test2IndiceSucateamento() {
		Veículo v = new Veículo();
		Manutencao m1 = new Manutencao();
		m1.setCusto(25);
		m1.setDescricao("facil");
		m1.setNumero(1);
		m1.setTempoParado(10);
		v.addManutencao(m1);
		Manutencao m2 = new Manutencao();
		m2.setCusto(50);
		m2.setDescricao("medio");
		m2.setNumero(2);
		m2.setTempoParado(20);
		v.addManutencao(m2);
		Manutencao m3 = new Manutencao();
		m3.setCusto(25);
		m3.setDescricao("muito facil");
		m3.setNumero(1);
		m3.setTempoParado(5);
		v.addManutencao(m3);
		
		float esperado = 0.5f;
		assertEquals(esperado, v.getIndiceSucateamento());
	}
	
	@Test
	void test3ManutencoesIguais() {
		Veículo v = new Veículo();
		Manutencao m1 = new Manutencao();
		m1.setCusto(25);
		m1.setDescricao("facil");
		m1.setNumero(1);
		m1.setTempoParado(60);
		v.addManutencao(m1);
		Manutencao m2 = new Manutencao();
		m2.setCusto(50);
		m2.setDescricao("facil");
		m2.setNumero(2);
		m2.setTempoParado(120);
		v.addManutencao(m2);
		Manutencao m3 = new Manutencao();
		m3.setCusto(25);
		m3.setDescricao("muito facil");
		m3.setNumero(1);
		m3.setTempoParado(60);
		v.addManutencao(m3);
		
		int esperado = 2;
		assertEquals(esperado, v.getQtdServicos("facil"));
	}
	
	@Test
	void test4CompararVeiculo() {
		Veículo v1 = new Veículo();
		Manutencao m1 = new Manutencao();
		m1.setCusto(25);
		m1.setDescricao("facil");
		m1.setNumero(1);
		m1.setTempoParado(60);
		v1.addManutencao(m1);
		Manutencao m2 = new Manutencao();
		m2.setCusto(50);
		m2.setDescricao("medio");
		m2.setNumero(2);
		m2.setTempoParado(120);
		v1.addManutencao(m2);
		Manutencao m3 = new Manutencao();
		m3.setCusto(25);
		m3.setDescricao("muito facil");
		m3.setNumero(3);
		m3.setTempoParado(60);
		v1.addManutencao(m3);
		
		Veículo v2 = new Veículo();
		Manutencao m4 = new Manutencao();
		m4.setCusto(100);
		m4.setDescricao("medio");
		m4.setNumero(1);
		m4.setTempoParado(5);
		v2.addManutencao(m4);
		Manutencao m5 = new Manutencao();
		m5.setCusto(70);
		m5.setDescricao("dificil");
		m5.setNumero(2);
		m5.setTempoParado(15);
		v2.addManutencao(m5);
		Manutencao m6 = new Manutencao();
		m5.setCusto(20);
		m5.setDescricao("facil");
		m5.setNumero(3);
		m5.setTempoParado(30);
		v2.addManutencao(m6);
		
		int esperado = 1;
		assertEquals(esperado, v1.comparaVeiculo(v2));
	}

}
