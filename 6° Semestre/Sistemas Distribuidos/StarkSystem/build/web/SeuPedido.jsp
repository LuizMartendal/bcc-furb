<%-- 
    Document   : SeuPedido
    Created on : 18/07/2013, 12:43:40
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import= "com.starksystem.modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb StarkSystem- Seu Pedido</title>
    </head>
    <body style="width: 750px">
        <jsp:include page="cabecalho.jspf"/>

        <h3>Endereço de Entrega </h3><hr><br>

        <form action="ManageDBServlet" method="post">     
            Nome do Cliente: <input type="text" name="cliente"> <br>
            Endereço de entrega: <input type="text" name="endereco"> <br>
            Estado : <input type="text" name="estado" size="2"><br>
            <hr>
           
        <h3 align="center">Seu Pedido</h3>

        <table border="1" align="center">
            <tr>
                <th>Produto</th>
                <th>Preço unitário</th>
                <th>Quantidade</th>
                <th>Total</th>
            </tr>
            <c:forEach var="item" items="${carrinho.itens}">
                <tr>
                    <td><c:out value="${item.nome}" /></td>
                    <td><c:out value="${item.preco}" /></td>
                    <td><c:out value="${item.quantidade}" /></td>
                    <td><c:out value="${item.total}" /></td>
                </tr>
            </c:forEach> 
            <tr>
                <td colspan="4" align="center">
                    <b>Total do pedido:</b>
                    <c:out value="${carrinho.total}" />
                </td>
            </tr>
        </table>
        
          <input type="submit" value="Fechar Pedido">
            <input type="reset" value="Cancel">
        </form>       
                
       
        <jsp:include page="rodape.jspf" />
    </body>
</html>
