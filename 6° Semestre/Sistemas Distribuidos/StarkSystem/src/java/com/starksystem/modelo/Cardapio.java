/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starksystem.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author joaosantanna
 */
public class Cardapio {

    private List<Produto> cardapio;

    public Cardapio() {
        this.cardapio = new ArrayList<Produto>();
        this.montarCardapio();
    }

    private void montarCardapio() {
        Produto prod;

        prod = new Produto(1, "Reator Ark", "Energia limpa sem necessidade de recarga por anos",2000.0);
        this.cardapio.add(prod);
        prod = new Produto(2, "Gerador Solar", "Transforma a energia do sol em energia eletrica", 1000.0);
        this.cardapio.add(prod);
       
        
    }

    public List<Produto> getCardapio() {
        return this.cardapio;
    }

    public Produto getRobo(long codigo) {
        Produto prod;
        Iterator<Produto> iterator = this.getCardapio().iterator();
        while (iterator.hasNext()) {
            prod = (Produto) iterator.next();
            if (prod.getCodigo() == codigo) {
                return prod;
            }
        }
        return null;
    }
}
