/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author joaosantanna
 */
public class Cardapio {

    private List<Robo> cardapio;

    public Cardapio() {
        this.cardapio = new ArrayList<Robo>();
        this.montarCardapio();
    }

    private void montarCardapio() {
        Robo rob;

        rob = new Robo(1, "Robo Domestico", "Para automatiza a limpesa da casa, processar o lixo e lavar a louça",800.0);
        this.cardapio.add(rob);
        rob = new Robo(2, "Robo Seguranca", "Para vigiar a casa e expantar intrusos", 1500.0);
        this.cardapio.add(rob);
        rob = new Robo(3, "Robo Medico", "Para cuidar de você quando estiver doente", 2000.0);
        this.cardapio.add(rob);
        
    }

    public List<Robo> getCardapio() {
        return this.cardapio;
    }

    public Robo getRobo(long codigo) {
        Robo pizza;
        Iterator<Robo> iterator = this.getCardapio().iterator();
        while (iterator.hasNext()) {
            pizza = (Robo) iterator.next();
            if (pizza.getCodigo() == codigo) {
                return pizza;
            }
        }
        return null;
    }
}
