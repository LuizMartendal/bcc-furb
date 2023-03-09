import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;

class AtivoEmRiscoTest {
	private DateTimeFormatter f = DateTimeFormatter.ofPattern("d/M/y");
	
	@Test
	void teste1BoteSeguro() {
		BoteSalvaVidas b = new BoteSalvaVidas(true, 10, 5, "BSV 001", 5);
		String a = "Bote Ok!";
		assertEquals(a, b.verificaSeguranca());
	}
	
	@Test
	void teste2BoteNaoSeguro() {
		BoteSalvaVidas b = new BoteSalvaVidas(true, 10, 4, "BSV 001", 5);
		String a = "Insuficiência de " + 1 + " coletes salva-vidas.";
		assertEquals(a, b.verificaSeguranca());
	}
	
	@Test
	void teste3TrasnatlanticoSeguro() {
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.parse("14/05/2010", f), "FTR 1267", 20);
		BoteSalvaVidas b1 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 10);
		BoteSalvaVidas b2 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 10);
		t.addBote(b1);
		t.addBote(b2);
		String a = "Está em condições adequadas de segurança.";
		assertEquals(a, t.verificaSeguranca());
	}
	
	@Test
	void teste4TransatlanticoNaoSeguroNaoInaugurado() {
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.now().plusDays(1), "FTR 1267", 20);
		BoteSalvaVidas b1 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 5);
		BoteSalvaVidas b2 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 10);
		t.addBote(b1);
		t.addBote(b2);
		String a = "ALERTA: navio necessitando de mais botes.";
		assertEquals(a, t.verificaSeguranca());
	}
	
	@Test
	void teste5TransatlanticoNaoSeguroInaugurado() {
		Transatlantico t = new Transatlantico("Titanic II", LocalDate.parse("17/10/2022", f), "FTR 1267", 20);
		BoteSalvaVidas b1 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 5);
		BoteSalvaVidas b2 = new BoteSalvaVidas(true, 10, 5, "BSV 001", 10);
		t.addBote(b1);
		t.addBote(b2);
		String a = "CUIDADO: navio em perigo.";
		assertEquals(a, t.verificaSeguranca());
	}
}
