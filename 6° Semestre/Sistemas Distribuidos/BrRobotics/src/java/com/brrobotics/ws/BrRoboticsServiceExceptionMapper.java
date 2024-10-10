/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brrobotics.ws;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author roqbez
 */
@Provider
public class BrRoboticsServiceExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {

        String msg = e.getMessage() != null ? e.getMessage() : "ERRO PROCESSANDO A REQUISI\u00C7\u00C3O";

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR) //
                .entity("{\"erro:\":\"" + msg + "\"}").type("application/json;charset=UTF-8") //
                .build();
    }

}
