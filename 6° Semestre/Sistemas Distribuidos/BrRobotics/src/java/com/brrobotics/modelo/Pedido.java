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

    private String codigo;
    private String cliente;
    private String endereco;
    private String estado;

    private int qtdRoboDomestico;
    private int qtdRoboMedico;
    private int qtdRoboSeguranca;

    private Double totalRoboDomestico;
    private Double totalRoboMedico;
    private Double totalRoboSeguranca;

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

    public int getQtdRoboDomestico() {
        return qtdRoboDomestico;
    }

    public void setQtdRoboDomestico(int qtdRoboDomestico) {
        this.qtdRoboDomestico = qtdRoboDomestico;
    }

    public int getQtdRoboMedico() {
        return qtdRoboMedico;
    }

    public void setQtdRoboMedico(int qtdRoboMedico) {
        this.qtdRoboMedico = qtdRoboMedico;
    }

    public int getQtdRoboSeguranca() {
        return qtdRoboSeguranca;
    }

    public void setQtdRoboSeguranca(int qtdRoboSeguranca) {
        this.qtdRoboSeguranca = qtdRoboSeguranca;
    }

    public Double getTotalRoboDomestico() {
        return totalRoboDomestico;
    }

    public void setTotalRoboDomestico(Double totalRoboDomestico) {
        this.totalRoboDomestico = totalRoboDomestico;
    }

    public Double getTotalRoboMedico() {
        return totalRoboMedico;
    }

    public void setTotalRoboMedico(Double totalRoboMedico) {
        this.totalRoboMedico = totalRoboMedico;
    }

    public Double getTotalRoboSeguranca() {
        return totalRoboSeguranca;
    }

    public void setTotalRoboSeguranca(Double totalRoboSeguranca) {
        this.totalRoboSeguranca = totalRoboSeguranca;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", cliente=" + cliente + ", endereco=" + endereco + ", estado=" + estado + ", qtdRoboDomestico=" + qtdRoboDomestico + ", qtdRoboMedico=" + qtdRoboMedico + ", qtdRoboSeguranca=" + qtdRoboSeguranca + ", totalRoboDomestico=" + totalRoboDomestico + ", totalRoboMedico=" + totalRoboMedico + ", totalRoboSeguranca=" + totalRoboSeguranca + ", total=" + total + '}';
    }

}
