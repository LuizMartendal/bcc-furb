/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starksystem.ws;

import com.starksystem.dao.DAOPedido;
import com.starksystem.modelo.Pedido;
import javax.jws.WebService;
import javax.jws.WebParam;

/**
 *
 * @author Roque
 */
@WebService(serviceName = "StarkSystemService")
public class StarkSystemService {

    private final DAOPedido dao = DAOPedido.getInstance();

    public StarkSystemService() {
        System.out.println("Webservice StarkSystemService criado");
    }

    public Pedido inserirPedido(@WebParam(name = "pedido") Pedido pedido) {

        double totalReatorSolar = pedido.getQtdReatorSolar() * 1500;
        double totalReatorArk = pedido.getQtdReatorArk() * 2500;

        pedido.setTotalReatorSolar(totalReatorSolar);
        pedido.setTotalReatorArk(totalReatorArk);

        pedido.setTotal(totalReatorSolar + totalReatorArk);

        pedido = dao.insert(pedido);

        System.out.println("[StarkSystemService] - " + pedido);

        return pedido;
    }
}
