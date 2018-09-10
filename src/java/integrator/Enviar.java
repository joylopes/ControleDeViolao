package integrator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class Enviar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String obs = request.getParameter("obs");
        String violao = request.getParameter("violao");

        
        Aluno a = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        a.setNome(nome);
        a.setObs(obs);
        a.setViolao(violao);
//        
        dao.create(a);
        
        
        
//        try (PrintWriter out = response.getWriter()) {
//
//            out.print(nome);
//            out.print(obs);
//            out.print(violao);
//
//        }
        
        
        

    }

}
