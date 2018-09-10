/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Joice
 */
public class Aluno {
    
    private int id;
    private String descricao;
    private String nome;
    private String obs;
    private String violao;
    private String transferenciaString;

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getViolao() {
        return violao;
    }

    public void setViolao(String violao) {
        this.violao = violao;
    }

    public String getTransferenciaString() {
        return transferenciaString;
    }

    public void setTransferenciaString(String transferenciaString) {
        this.transferenciaString = transferenciaString;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    @Override
    public String toString() {
        return getDescricao(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
