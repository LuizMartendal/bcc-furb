/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.modelo;

/**
 *
 * @author joaosantanna
 */
public class Pedido {

    private Integer codigo;
    private String cliente;
    private String endereco;
    private String estado;
    private String itens;
    private double total;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", endereco=" + endereco + ", estado=" + estado + ", itens=" + itens + ", total=" + total + '}';
    }

}
