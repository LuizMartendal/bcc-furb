/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starksystem.modelo;

/**
 *
 * @author joaosantanna
 */
public class Pedido {

    private String codigo;
    private String cliente;
    private String endereco;
    private String estado;

    private int qtdReatorArk;
    private int qtdReatorSolar;

    private Double totalReatorArk;
    private Double totalReatorSolar;

    private Double total;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQtdReatorArk() {
        return qtdReatorArk;
    }

    public void setQtdReatorArk(int qtdReatorArk) {
        this.qtdReatorArk = qtdReatorArk;
    }

    public int getQtdReatorSolar() {
        return qtdReatorSolar;
    }

    public void setQtdReatorSolar(int qtdReatorSolar) {
        this.qtdReatorSolar = qtdReatorSolar;
    }

    public Double getTotalReatorArk() {
        return totalReatorArk;
    }

    public void setTotalReatorArk(Double totalReatorArk) {
        this.totalReatorArk = totalReatorArk;
    }

    public Double getTotalReatorSolar() {
        return totalReatorSolar;
    }

    public void setTotalReatorSolar(Double totalReatorSolar) {
        this.totalReatorSolar = totalReatorSolar;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", endereco=" + endereco + ", estado=" + estado + ", qtdReatorArk=" + qtdReatorArk + ", qtdReatorSolar=" + qtdReatorSolar + ", totalReatorArk=" + totalReatorArk + ", totalReatorSolar=" + totalReatorSolar + ", total=" + total + '}';
    }
}
