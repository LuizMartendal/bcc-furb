<%-- 
    Document   : ListaPedidos
    Created on : 06/02/2014, 11:27:20
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import= "com.starksystem.modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb StarkSystem-Pedidos no banco de dados</title>
    </head>
    <body>
        <jsp:include page="cabecalho.jspf"/>
        <h1>Pedidos no banco de dados</h1>
        <Br>
        <h3 align="center">Pedidos:</h3>
        <jsp:useBean id= "ListaPedidosBean" class= "com.starksystem.modelo.ListaPedidos" scope="session"/>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Cliente</th>
                <th>Endereço</th>
                <th>Estado</th>
                <th>Itens</th>
                <th>Total</th>
            </tr>
            <c:forEach var="pedido" items= "${ListaPedidosBean.pedidos}" >
                <tr>
                    <td><c:out value= "${pedido.codigo}" /></td>
                    <td><c:out value= "${pedido.cliente}" /></td>
                    <td><c:out value= "${pedido.endereco}" /></td>
                    <td><c:out value= "${pedido.estado}" /></td>
                    <td><c:out value= "${pedido.itens}" /></td>
                    <td><c:out value= "${pedido.total}" /></td>
                    
                </tr>
            </c:forEach>
        </table>


<br> <a href='index.jsp'> Voltar para a Pagina Inicial</a>



        <jsp:include page="rodape.jspf" />   
    </body>
</html>
