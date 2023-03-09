import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class VendedorTest {

	@Test
	void teste01_Viagem_Menor_Km() {
		HashMap<String,Vendedor> vendedores = new HashMap<>();
		Vendedor vendedor = new Vendedor();
		
		//vendedor 1
		vendedor.setNome("João da Silva");
		Viagens viagem = new Viagens(400, 2, 500);
		vendedor.addViagem(viagem);
		Viagens viagem2 = new Viagens(150, 1, 620);
		vendedor.addViagem(viagem2);
		Viagens viagem3 = new Viagens(100, 2, 130);
		vendedor.addViagem(viagem3);
		vendedores.put(vendedor.getNome(), vendedor);
		//vendedor 2
		vendedor.setNome("Maria Pedrosa");
		Viagens viagem4 = new Viagens(145, 1, 900);
		vendedor.addViagem(viagem4);
		vendedores.put(vendedor.getNome(), vendedor);
		
		Viagens resultado = null;
		for (Vendedor v: vendedores.values()) {
			resultado = v.getViagemMenorQuilometragem();
		}
		
		assertEquals(viagem3, resultado);
	}

}
