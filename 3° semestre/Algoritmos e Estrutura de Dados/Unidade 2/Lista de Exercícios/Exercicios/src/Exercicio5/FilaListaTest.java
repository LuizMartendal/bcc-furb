package Exercicio5;

import Exercicio4.FilaVetor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaListaTest {

    @Test
    void inserir() {
        FilaLista<Integer> filaLista = new FilaLista<>();

        filaLista.inserir(1);
        filaLista.inserir(2);

        assertNotNull(filaLista.peek());
        assertEquals(1, filaLista.peek());
    }

    @Test
    void retirar() {
        FilaLista<Integer> filaLista = new FilaLista<>();

        filaLista.inserir(1);
        filaLista.inserir(2);

        assertEquals(1, filaLista.peek());

        filaLista.retirar();

        assertEquals(2, filaLista.peek());
    }

    @Test
    void estaVazia() {
        FilaLista<Integer> filaLista = new FilaLista<>();

        assertTrue(filaLista.estaVazia());

        filaLista.inserir(1);
        filaLista.inserir(2);

        assertFalse(filaLista.estaVazia());
    }

    @Test
    void liberar() {
        FilaLista<Integer> filaLista = new FilaLista<>();

        assertTrue(filaLista.estaVazia());

        filaLista.inserir(1);
        filaLista.inserir(2);

        assertFalse(filaLista.estaVazia());
    }

    @Test
    void testToString() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);

        String str = "1, 2, 3, 4, 5";

        assertEquals(str, filaVetor.toString());
    }

    @Test
    void concatenar() {
        FilaLista<Integer> filaLista = new FilaLista<>();
        filaLista.inserir(1);
        filaLista.inserir(2);
        filaLista.inserir(3);
        filaLista.inserir(4);
        filaLista.inserir(5);

        FilaLista<Integer> filaLista2 = new FilaLista<>();
        filaLista2.inserir(1);
        filaLista2.inserir(2);
        filaLista2.inserir(3);
        filaLista2.inserir(4);
        filaLista2.inserir(5);

        FilaLista<Integer> filaLista3 = filaLista.concatenar(filaLista2);

        String str = "1, 2, 3, 4, 5, 1, 2, 3, 4, 5";

        assertEquals(str, filaLista3.toString());
    }
}