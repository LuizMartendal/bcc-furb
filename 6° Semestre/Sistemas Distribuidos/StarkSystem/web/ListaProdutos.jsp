<%-- 
    Document   : ListaPizzas
    Created on : 18/07/2013, 12:17:48
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.starksystem.modelo.Produto" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb StarkSystem - Menu</title>
    </head>
    <body style="width: 750px">

        <jsp:include page="cabecalho.jspf"/>
        
        
        
        <h1>StarkSystem - Venda de geradores de energia</h1>
        <div>
            <p>Bem vindo a StarkSystem lider mundial em
                energia limpa.<br>
                Escolha um dos nosso produtos abaixo.<br>


            </p>

        </div>
        <h3 align="center">Nossos Geradores !!!</h3>
        <jsp:useBean id= "CardapioBean" class= "com.starksystem.modelo.Cardapio" scope="session"/>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Ação</th>
            </tr>
            <c:forEach var="produto" items= "${CardapioBean.cardapio}" >
                <tr>
                    <td><c:out value= "${produto.codigo}" /></td>
                    <td>
                        <c:if test="${produto.codigo == 1}"> <img src="images/ReatorArc.png" width="50" height="50" alt="domestico"/> 
                        </c:if>
                        <c:if test="${produto.codigo == 2}"> <img src="images/reatorSolar.jpeg" width="60" height="60" alt="seguranca"/>
                        </c:if>
                                             

                        <c:out value= "${produto.nome}" />
                    </td>
                    <td><c:out value= "${produto.descricao}" /></td>
                    <td><c:out value= "${produto.preco}" /></td>
                    <td>
                        <input type="button" value="Adicionar ao carrinho" onclick= "javascript:document.location = 'ServletController?cmd=AdicionarItem&codigo=${produto.codigo}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br />
        
        <br> <a href='ListaPedidos.jsp'> Visualizar pedidos</a><br><br>
        <jsp:include page="rodape.jspf" />



    </body>
</html>
