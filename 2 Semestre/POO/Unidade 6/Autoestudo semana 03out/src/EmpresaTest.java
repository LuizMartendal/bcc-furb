// Luiz Henrique Martendal; Daniel de Paula;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EmpresaTest {

	@Test
	void teste1ConsultarTelefone() {
		Empresa e = new Empresa();
		e.addUsuario("Luiz");
		Usuario u = e.getUsuario("Luiz");
		u.addTelefone("Luiz", "1234567890", "comercial", "rua 1", LocalDate.of(2019, 10, 10));
		u.addTelefone("Luiz", "0987654321", "especializado", "rua 2", LocalDate.of(2020, 10, 11));
		u.addTelefone("Luiz", "1233211231", "residencial", "rua 3", LocalDate.of(2021, 9, 11));
		LinhaTelefonica t1 = u.getTelefone("1234567890");
		t1.setRamoAtividade("agricultura");
		assertEquals("agricultura", t1.getRamoAtividade());
	}
	
	@Test
	void teste2ConsultarFaturamento() {
		Empresa e = new Empresa();
		e.addUsuario("Luiz");
		Usuario u = e.getUsuario("Luiz");
		u.addTelefone("Luiz", "1234567890", "comercial", "rua 1", LocalDate.of(2019, 10, 10));
		u.addTelefone("Luiz", "0987654321", "especializado", "rua 2", LocalDate.of(2020, 10, 11));
		u.addTelefone("Luiz", "1233211231", "residencial", "rua 3", LocalDate.of(2021, 9, 11));
		LinhaTelefonica t1 = u.getTelefone("1234567890");
		t1.setRamoAtividade("agricultura");
		LinhaTelefonica t2 = u.getTelefone("0987654321");
		t2.setQtdOcorrencias(2);
		LinhaTelefonica t3 = u.getTelefone("1233211231");
		t3.setTemConexaoInternet(true);
		double faturamento = 102.5;
		assertEquals(faturamento, e.getFaturamento());
	}

}
