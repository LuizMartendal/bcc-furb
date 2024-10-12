<%-- 
    Document   : MostraCarrinho
    Created on : 18/07/2013, 12:31:25
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import= "com.starksystem.modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb StarkSystem - Carrinho</title>
    </head>
    <body style="width: 750px">
        <jsp:include page="cabecalho.jspf"/>
        <h3 align="center">Seu carrinho de compras</h3>

        <c:choose>
            <c:when test="${empty carrinho.itens}">
                <h3 align="center">Seu carrinho está vazio! Você ainda não
                    escolheu nenhum gerador!</h3>
                </c:when>
                <c:otherwise>
                <table border="1" align="center">
                    <tr>
                        <th>Nome</th>
                        <th>Preço unitário</th>
                        <th>Quantidade</th>
                        <th>Total</th>
                        <th>Ação</th>
                    </tr>
                    <c:forEach var="item" items="${carrinho.itens}">
                        <tr>
                            <td><c:out value="${item.nome}" /></td>
                            <td><c:out value="${item.preco}" /></td>
                            <td><c:out value="${item.quantidade}"/></td>
                            <td><c:out value="${item.total}" /></td>
                            <td><input type="button" value="Excluir do carrinho" onclick="javascript:document.location = 'ServletController?cmd=ExcluirItem&codigo=${item.codigo}'" />
                            </td>
                        </tr>   
                    </c:forEach>
                </table>   
            </c:otherwise>
        </c:choose>
        <p align="center">
            <input type="button" value="Continuar comprando" onclick="javascript:document.location = 'ListaProdutos.jsp'" />
            <input type="button" value="Ir ao caixa" onclick="javascript:document.location = 'ServletController?cmd=FecharPedido'" />
        </p>
        <jsp:include page="rodape.jspf" />
        

    </body>
</html>
