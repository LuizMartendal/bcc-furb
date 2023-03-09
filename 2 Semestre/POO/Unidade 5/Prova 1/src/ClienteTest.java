import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	void teste1TransferenciaEntreContas() {
		Cliente c = new Cliente("Luiz", "123455-6");
		c.criarConta("40028922");
		c.criarConta("211205122022");
		c.depositar("40028922", 100);
		c.transferir("40028922", "211205122022", 50);
		
		float valor = 50;
		
		assertEquals(valor, c.getSaldo("211205122022"));
	}
	
	@Test
	void teste1SaqueEspecial() {
		Cliente c = new Cliente("Luiz", "123455-6");
		c.criarConta("40028922");
		c.criarConta("211205122022");
		c.depositar("40028922", 120);
		c.depositar("211205122022", 50);
		c.sacar(150);
		
		float valor = 20;
		
		assertEquals(valor, c.getSaldo("211205122022"));
	}
}
