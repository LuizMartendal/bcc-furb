import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ImprimirTest {

	@Test
	void testFolha() {
		Folha_a4 f = new Folha_a4("1231231231231231231223123123123123");
		f.addFrase("23");
		f.addFrase("3123123123123");
		ArrayList<String> frase = new ArrayList<>();
		frase.add("12312312312312312312");
		frase.add("23123123123123");
		frase.add("23");
		frase.add("3123123123123");
		assertEquals(frase, f.imprimir());
	}
	
	@Test
	void testCarta() {
		Carta c =  new Carta("123123123123123123122");
		c.addFrase("3123123123123");
		c.addFrase("23");
		c.addFrase("3123123123123");
		ArrayList<String> frase = new ArrayList<>();
		frase.add("12312312");
		frase.add("31231231");
		frase.add("23122");
		frase.add("31231231");
		frase.add("23123");
		frase.add("23");
		frase.add("31231231");
		frase.add("23123");
		assertEquals(frase, c.imprimir());
	}

}
