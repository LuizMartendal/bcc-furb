
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InteiroPositivoTest {
    @Test
    public void test01_Valor_10_Fatorial(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        //Act
        ip.setValor(10);
        //Assert 
        assertEquals(3628800, ip.fatorial());
    }
    @Test
    public void test02_Valor_20_Fatorial(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        //Act
        ip.setValor(20);
        //Assert
        assertEquals(2432902008176640000L, ip.fatorial());
    }
    @Test
    public void test03_DivisoresInteiros_Valorr_14(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        //Act
        ip.setValor(14);
        //Assert
        assertEquals("Os divisores inteiros são 1, 2, 7, 14 e a quantidade de divisores é 4", ip.divisoresInteiros());
    }
    @Test
    public void test04_DivisoresInteiros_Valorr_18(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        //Act
        ip.setValor(18);
        //Assert
        assertEquals("Os divisores inteiros são 1, 2, 3, 6, 9, 18 e a quantidade de divisores é 6", ip.divisoresInteiros());
    }
    @Test
    public void test05_Fibonacci_Valor_09(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        int[] vetor = {1, 1, 2, 3, 5, 8, 13, 21, 34};
        //Act
        ip.setValor(9);
        //Assert
        assertArrayEquals(vetor, ip.fibonacci());
    }
    @Test
    public void test05_Fibonacci_Valor_15(){
        //Arrange
        InteiroPositivo ip = new InteiroPositivo();
        int[] vetor = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        //Act
        ip.setValor(15);
        //Assert
        assertArrayEquals(vetor, ip.fibonacci());
    }
}
