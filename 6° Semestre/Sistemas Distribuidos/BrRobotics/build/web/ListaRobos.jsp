<%-- 
    Document   : ListaPizzas
    Created on : 18/07/2013, 12:17:48
    Author     : joaosantanna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.brrobotics.modelo.Robo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AppWeb BrRobotics - Menu</title>
    </head>
    <body style="width: 750px">

        <jsp:include page="cabecalho.jspf"/>

        <h1>BrRobotics - Venda kits roboticos</h1>
        <div>
            <p>Bem vindo a BrRobotics lider regional em
                robotica.<br>
                Escolha um dos nosso produtos abaixo.<br>


            </p>

        </div>
        <h3 align="center">Nossos Robos - desenvolvidos com tecnologia nacional!!!</h3>
        <jsp:useBean id= "CardapioBean" class= "com.brrobotics.modelo.Cardapio" scope="session"/>
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Ação</th>
            </tr>
            <c:forEach var="robo" items= "${CardapioBean.cardapio}" >
                <tr>
                    <td><c:out value= "${robo.codigo}" /></td>
                    <td>
                        <c:if test="${robo.codigo == 1}"> <img src="images/domestico.jpeg" width="50" height="50" alt="domestico"/> 
                        </c:if>
                        <c:if test="${robo.codigo == 2}"> <img src="images/seguranca.jpeg" width="60" height="60" alt="seguranca"/>
                        </c:if>
                        <c:if test="${robo.codigo == 3}"> <img src="images/medico.jpeg" width="50" height="50" alt="medico"/>
                        </c:if>                       

                        <c:out value= "${robo.nome}" />
                    </td>
                    <td><c:out value= "${robo.descricao}" /></td>
                    <td><c:out value= "${robo.preco}" /></td>
                    <td>
                        <input type="button" value="Adicionar ao carrinho" onclick= "javascript:document.location = 'ServletController?cmd=AdicionarItem&codigo=${robo.codigo}'"/>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <br />
        <jsp:include page="rodape.jspf" />



    </body>
</html>
