/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.PedidoDAO;
import Model.Pedido;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "PedidosListarServlet", urlPatterns = {"/Pedido/Listar"})
public class PedidosListarServlet extends HttpServlet
{

    

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        List<Pedido> pedidos;
        List<Integer> listaPedidos = null;

        try
        {
           PedidoDAO dao = new PedidoDAO();
            pedidos = dao.listAll();
            listaPedidos = dao.listarPedidos();
        }
        catch (Exception ex)
        {
            Logger.getLogger(PedidosListarServlet.class.getName()).log(Level.SEVERE, null, ex);
            pedidos = new ArrayList<>();
            request.setAttribute("mensagem", ex.getLocalizedMessage());
        }
        
        request.setAttribute("lista", listaPedidos);
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("/WEB-INF/lista-pedidos.jsp").forward(request, response);
        request.getRequestDispatcher("/WEB-INF/criar-pedido.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        Pedido novoPedido = new Pedido();
        novoPedido.setNome(request.getParameter("nome"));
        novoPedido.setDono(request.getParameter("dono"));
        novoPedido.setPedido(Long.parseLong(request.getParameter("pedido")));
        novoPedido.setValor(Float.parseFloat(request.getParameter("valor")));
        
        
        try
        {
            PedidoDAO dao = new PedidoDAO();
            dao.cria(novoPedido);
        } 
        catch (Exception ex) 
        {
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("/WEB-INF/criar-pedido.jsp").forward(request, response);
            return;
        }
        
        response.sendRedirect("contatos.html");
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
