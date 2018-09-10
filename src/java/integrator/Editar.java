/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrator;

import java.io.IOException;
import java.io.PrintWriter;
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
public class Editar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        String id;
        String coluna;
        String texto;
        id = request.getParameter("id");
        coluna = request.getParameter("coluna");
        texto = request.getParameter("texto");
        PrintWriter out = response.getWriter();
        int idInt = Integer.parseInt(id);

        
        Aluno a = new Aluno();
        AlunoDAO dao = new AlunoDAO();
        a.setId(idInt);
        a.setTransferenciaString(texto);
        
        dao.update(a,coluna);
        

    }

}
