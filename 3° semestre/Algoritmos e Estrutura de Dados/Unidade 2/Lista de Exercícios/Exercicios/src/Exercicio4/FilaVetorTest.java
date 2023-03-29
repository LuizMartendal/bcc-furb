package Exercicio4;

import static org.junit.jupiter.api.Assertions.*;

class FilaVetorTest {

    @org.junit.jupiter.api.Test
    void inserir() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        assertEquals(1, filaVetor.peek());
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);
        assertEquals(1, filaVetor.peek());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);

        assertEquals(1, filaVetor.peek());
    }

    @org.junit.jupiter.api.Test
    void retirar() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        filaVetor.inserir(2);

        assertEquals(1, filaVetor.peek());

        int number = filaVetor.retirar();

        assertEquals(1, number);
        assertEquals(2, filaVetor.peek());
    }

    @org.junit.jupiter.api.Test
    void estaVazia() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);

        assertTrue(filaVetor.estaVazia());

        filaVetor.inserir(1);
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);

        assertFalse(filaVetor.estaVazia());
    }

    @org.junit.jupiter.api.Test
    void liberar() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);

        assertEquals(1, filaVetor.peek());
        assertFalse(filaVetor.estaVazia());

        filaVetor.liberar();
        assertTrue(filaVetor.estaVazia());
    }

//    @org.junit.jupiter.api.Test
//    void testToString() {
//        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
//        filaVetor.inserir(1);
//        filaVetor.inserir(2);
//        filaVetor.inserir(3);
//        filaVetor.inserir(4);
//        filaVetor.inserir(5);
//
//        String str = "1, 2, 3, 4, 5";
//
//        assertEquals(str, filaVetor.toString());
//    }

    @org.junit.jupiter.api.Test
    void concatenar() {
        FilaVetor<Integer> filaVetor = new FilaVetor<>(5);
        filaVetor.inserir(1);
        filaVetor.inserir(2);
        filaVetor.inserir(3);
        filaVetor.inserir(4);
        filaVetor.inserir(5);

        FilaVetor<Integer> filaVetor2 = new FilaVetor<>(5);
        filaVetor2.inserir(1);
        filaVetor2.inserir(2);
        filaVetor2.inserir(3);
        filaVetor2.inserir(4);
        filaVetor2.inserir(5);

        FilaVetor<Integer> filaVetor3 = filaVetor.concatenar(filaVetor2);
    }
}