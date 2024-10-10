/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starksystem.controle;

import com.starksystem.dao.DAOPedido;
import com.starksystem.modelo.CarrinhoDeCompras;
import com.starksystem.modelo.ItemDoPedido;
import com.starksystem.modelo.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author joaosantanna
 */
public class ManageDBServlet extends HttpServlet {

    private DAOPedido dao;

    @Override
    public void init() {
        dao = new DAOPedido(); //conecta no banco de dados
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            insertRecord(request, response, out);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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

    private void insertRecord(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {

        String cliente = request.getParameter("cliente");
        String endereco = request.getParameter("endereco");
        String estado = request.getParameter("estado");

        System.out.println("cliente: " + cliente);
        System.out.println("endereco: " + endereco);
        System.out.println("estado: " + estado);

        // captura objeto da sessao
        HttpSession sessao = request.getSession();
        // verifica se ja tem um carrinho de compras criado nesta sessao
        CarrinhoDeCompras carrinho = (CarrinhoDeCompras) sessao.getAttribute("carrinho");

        // depois de pegar o carrinho de compras pegar os itens
        //no carrinho e preparar a string ... bem como o total da compra
        double total = carrinho.getTotal();
        //carregar todos os valores e criar o pedido para ser armazenado no
        //banco

        Pedido pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setEndereco(endereco);
        pedido.setEstado(estado);

        List<ItemDoPedido> itensPedido = carrinho.getItens();

        for (int i = 0; i < itensPedido.size(); i++) {
            ItemDoPedido item = carrinho.getItens().get(i);

            if ("Reator Ark".equals(item.getNome())) {
                pedido.setQtdReatorArk(item.getQuantidade());
                pedido.setTotalReatorArk(pedido.getQtdReatorArk() * item.getPreco());
            } else if ("Gerador Solar".equals(item.getNome())) {
                pedido.setQtdReatorSolar(item.getQuantidade());
                pedido.setTotalReatorSolar(pedido.getQtdReatorSolar() * item.getPreco());
            }
        }

        pedido.setTotal(total);

        //feito isso basta passar para o DAO gravar no banco de dados
        dao.insert(pedido);

        //resetar o carrinho de compras
        sessao.removeAttribute("carrinho");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ManageDBServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Compra gravada no banco de dados com sucesso!</h1>");
        out.println("<br> <a href='index.jsp'> Voltar para a Pagina Inicial</a>");
        out.println("</body>");
        out.println("</html>");

    }

}
