/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.ws;

import com.brrobotics.dao.DAOPedido;
import com.brrobotics.modelo.Pedido;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Roque
 */
@Path("/BrRoboticsService")
public class BrRoboticsService {

    private final DAOPedido dao = DAOPedido.getInstance();

    public BrRoboticsService() {
        System.out.println("Webservice REST da BrRobotics criado");
    }

    @POST
    @Path("inserirPedido")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido inserirPedido(Pedido pedido) {

        double totalRoboDomestico = pedido.getQtdRoboDomestico() * 900;
        double totalRoboMedico = pedido.getQtdRoboMedico() * 2500;
        double totalRoboSeguranca = pedido.getQtdRoboSeguranca() * 1800;

        pedido.setTotalRoboDomestico(totalRoboDomestico);
        pedido.setTotalRoboMedico(totalRoboMedico);
        pedido.setTotalRoboSeguranca(totalRoboSeguranca);

        pedido.setTotal(totalRoboDomestico + totalRoboMedico + totalRoboSeguranca);

        pedido = dao.insert(pedido);

        System.out.println("[BrRoboticsService] - " + pedido);

        return pedido;
    }
}
