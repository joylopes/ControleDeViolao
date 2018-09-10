/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Aluno;

/**
 *
 * @author Joice
 */
public class AlunoDAO {

    Connection con;
    
    public AlunoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Aluno a) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO alunos (obs,nome,violao)VALUES(?,?,?)");
            stmt.setString(1, a.getObs());
            stmt.setString(2, a.getNome());
            stmt.setString(3, a.getViolao());
          
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Aluno> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setObs(rs.getString("obs"));
                aluno.setNome(rs.getString("nome"));
                aluno.setViolao(rs.getString("violao"));
                produtos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }
    public List<Aluno> readForDesc(String desc) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno produto = new Aluno();

                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Aluno p ,String coluna) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE alunos SET "+coluna+" = ? WHERE id = ?");
            stmt.setString(1, p.getTransferenciaString());
            stmt.setInt(2, p.getId());

            stmt.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Aluno p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM alunos WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
