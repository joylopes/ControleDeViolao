/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Aluno;
import model.dao.AlunoDAO;

/**
 *
 * @author Joice
 */
public class ListarProdutos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            AlunoDAO dao = new AlunoDAO();
            List<Aluno> lista = new ArrayList();
            lista = dao.read();
            for (int i = 0; i < lista.size(); i++) {
                out.print("<tr>");
                out.print("<td class='codigoTd'>");
                out.println(lista.get(i).getId());
                out.print("</td>");
                out.print("<td class='editavel nomeTd' name='nome/" + lista.get(i).getId() + "' contenteditable='' >");
                out.println(lista.get(i).getNome());
                out.print("</td>");
                out.print("<td class='editavel ' name='obs/" + lista.get(i).getId() + "' contenteditable=''>");
                out.println(lista.get(i).getObs());
                out.print("</td>");
                out.print("<td >");
                String v = lista.get(i).getViolao();
                if("Sim".equals(v)){
                out.println("<button class='btn btn-block btnViolao btn-success' name='violao/" + lista.get(i).getId() + "' >"+v+"</button>");
                } else {
                out.println("<button class='btn btn-block btnViolao btn-danger' name='violao/" + lista.get(i).getId() + "' >"+v+"</button>");
                }
                out.print("</td>");
                out.print("<td>"
                        + "<input type='submit' class='btn btn-danger btn-block excluirAluno' name='" + lista.get(i).getId() + "' value='Excluir'> "
                        + "</td>");
                out.print("</tr>");
            }

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

}
