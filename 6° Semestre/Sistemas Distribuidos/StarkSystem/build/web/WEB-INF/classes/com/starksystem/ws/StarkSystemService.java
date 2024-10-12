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
        System.out.println("[StarkSystemService] - " + pedido);
        return dao.insert(pedido);
    }
}
