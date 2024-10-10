/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starksystem.controle;

import com.starksystem.modelo.CarrinhoDeCompras;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joaosantanna
 */
public class ServletController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // captura objeto da sessao
        HttpSession sessao = request.getSession();
        // verifica se ja tem um carrinho de compras criado nesta sessao
        CarrinhoDeCompras carrinho = (CarrinhoDeCompras) sessao.getAttribute("carrinho");
        //se nao tiver cria um...
        if (carrinho == null) {
            carrinho = new CarrinhoDeCompras();
        }
        //captura o comando que veio no pedido
        String cmd = request.getParameter("cmd");
        
        
        //se o comando for de adicionar um item ao carrinho faz o seguinte...
        
        if (cmd.equals("AdicionarItem")) {
            //pega o codigo que vem com o pedido
            long codigo = Long.parseLong(request.getParameter("codigo"));

            // passa o numero do item para a lista do carrinho
            carrinho.adicionarItem(codigo);
            //adiciona esse carrinho a sessao
            sessao.setAttribute("carrinho", carrinho);
            // chama a pagina para mostrar o item adicionado ao carrinho
            RequestDispatcher view = request.getRequestDispatcher("MostraCarrinho.jsp");
            view.forward(request, response);

            // se o comando for para excluir um item faca...   
        } else if (cmd.equals("ExcluirItem")) {

            //pega o codigo que vem com o pedido
            long codigo = Long.parseLong(request.getParameter("codigo"));
            carrinho.removerItem(codigo);
            sessao.setAttribute("carrinho", carrinho);
            // chama a pagina para mostrar o item adicionado ao carrinho
            RequestDispatcher view = request.getRequestDispatcher("MostraCarrinho.jsp");
            view.forward(request, response);
        } else if (cmd.equals("FecharPedido")) {

            // chama a pagina para mostrar o pedido fechado
            RequestDispatcher view = request.getRequestDispatcher("SeuPedido.jsp");
            view.forward(request, response);
        }




    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
