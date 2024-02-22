/*
 Bábara Moro
 Luiz Henrique Martendal
 Maria Júlia Testoni
 Nícolas Zimermann
 */

package org.example;

import java.time.LocalDateTime;

public class Veiculo {

    private String modelo;
    private String placa;

    private LocalDateTime entrada = LocalDateTime.now();

    public Veiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }
}
