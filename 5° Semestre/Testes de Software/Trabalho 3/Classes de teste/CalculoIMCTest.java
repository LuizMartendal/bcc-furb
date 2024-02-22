/* 
 Bábara Moro
 Luiz Henrique Martendal
 Maria Júlia Testoni
 Nícolas Zimermann
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculoIMCTest {
	
	CalculoIMC calculadora;

	@BeforeEach
	void setUp() {
		calculadora = new CalculoIMC();
	}
	
	@Test
	void testeAlturaMinima() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			double peso = 80;
			double altura = 0.39;
			calculadora.calcular(altura, peso);
		});
		assertEquals("Altura não pode ser menor que 0.40", exception.getMessage());
	}
	
	@Test
	void testeAlturaMaxima() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			double peso = 80;
			double altura = 2.51;
			calculadora.calcular(altura, peso);
		});
		assertEquals("Altura não pode ser maior que 2.50", exception.getMessage());
	}
	
	@Test
	void testePesoMinimoComPeso0() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			double peso = 0;
			double altura = 2.51;
			calculadora.calcular(altura, peso);
		});
		assertEquals("Peso não pode ser menor ou igual a 0", exception.getMessage());
	}
	
	@Test
	void testePesoMinimoComPesoNegativo() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			double peso = -1;
			double altura = 2.51;
			calculadora.calcular(altura, peso);
		});
		assertEquals("Peso não pode ser menor ou igual a 0", exception.getMessage());
	}
	
	@Test
	void testeParametrosInvalidos() {
		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
			String peso = "60";
			String altura = "1.90a";
			calculadora.calcular(altura, peso);
		});
		assertEquals("Os inputs precisam ser valores numéricos", exception.getMessage());
	}
	
	@Test
	void testeCalculoImcValido() {
		double peso = 80;
		double altura = 1.80;
		assertEquals(24.69, calculadora.calcular(altura, peso), 0.00);
	}

}
