import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class ViagemTest {

	@Test
	void testeMunicipal() {
		Municipais m = new Municipais("123", "Luiz", LocalDate.now(), LocalTime.now());
		Passageiro p = new Passageiro("Samara", "123", 34);
		m.addPassageiro(p);
		Passageiro p1 = new Passageiro("Samara", "123", 34);
		m.addPassageiro(p1);
		Idoso i = new Idoso("Leonir" , "345", 62, "123");
		m.addPassageiro(i);
		Estudante e = new Estudante("Cleber", "234", 10, "Bl");
		m.addPassageiro(e);
		assertEquals(12.5f, m.getValorTotal());
	}
	
	@Test
	void testeIntermunicipal() {
		Intermunicipal m = new Intermunicipal("123", "Luiz", LocalDate.now(), LocalTime.now());
		Passageiro p = new Passageiro("Samara", "123", 34);
		m.addPassageiro(p);
		Passageiro p1 = new Passageiro("Samara", "123", 34);
		m.addPassageiro(p1);
		Idoso i = new Idoso("Leonir" , "345", 62, "123");
		m.addPassageiro(i);
		Estudante e = new Estudante("Cleber", "234", 10, "Bl");
		m.addPassageiro(e);
		assertEquals(29.379997f, m.getValorTotal());
	}
}
