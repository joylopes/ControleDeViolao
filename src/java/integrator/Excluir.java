/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrator;

//import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
//import java.io.PrintWriter;
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
public class Excluir extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain");

        String id = request.getParameter("excluirProdutoId");

        int idInt = Integer.parseInt(id);
        Aluno p = new Aluno();
        AlunoDAO dao = new AlunoDAO();

        p.setId(idInt);

        dao.delete(p);
        response.sendRedirect("index.jsp");
    }

}
