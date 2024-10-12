/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.ws;

import com.brrobotics.dao.DAOPedido;
import com.brrobotics.modelo.Pedido;
import javax.jws.WebService;
import javax.jws.WebParam;

/**
 *
 * @author Roque
 */
@WebService(serviceName = "BrRoboticsService")
public class BrRoboticsService {

    private final DAOPedido dao = DAOPedido.getInstance();

    public BrRoboticsService() {
        System.out.println("Webservice BrRobiticsService criado");
    }

    public Pedido inserirPedido(@WebParam(name = "pedido") Pedido pedido) {
        System.out.println("[BrRobiticsService] - " + pedido);
        return dao.insert(pedido);
    }
}
