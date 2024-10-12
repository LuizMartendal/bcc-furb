/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.modelo;

/**
 *
 * @author joaosantanna
 */
public class Robo {

    private long codigo;
    private String nome;
    private String descricao;
    private double preco;

    public Robo() {
    }

    public Robo(long codigo, String nome, String descricao, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
