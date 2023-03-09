import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VetorDeReaisTest {

	@Test
	void test01_VetorDeReais_Rejeita_Divisao_Tamanho_Diferente() {
		//Arrange
		VetorDeReais vr = new VetorDeReais(3);
		vr.setVetor(2, 0);
		vr.setVetor(-1, 1);
		vr.setVetor(3.5, 2);
		VetorDeReais vr2 = new VetorDeReais(1);
		vr2.setVetor(3, 0);
		//Act
		VetorDeReais vr3 = vr.VetoresDivididos(vr2);
		//Assert
		assertEquals(null, vr3 );	
	}
	@Test
	void test02_VetorDeReais_Divide_Vetores() {
		//Arrange
		VetorDeReais vr = new VetorDeReais(3);
		vr.setVetor(2, 0);
		vr.setVetor(-1, 1);
		vr.setVetor(3.5, 2);
		VetorDeReais vr2 = new VetorDeReais(3);
		vr2.setVetor(3, 0);
		vr2.setVetor(2, 1);
		vr2.setVetor(1, 2);
		//Act
		VetorDeReais vr3 = vr.VetoresDivididos(vr2);
		//Assert
		double[] vetor ={0.666666 , -0.5 , 3.5};
		for (int i = 0; i < vetor.length; i++) {
			assertEquals(vetor[i] , vr3.getValor(i), 0.009);
		}
	}
}
