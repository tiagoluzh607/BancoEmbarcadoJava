/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoembarcado.model;

/**
 *
 * @author tiago
 */
public class Produto {
    
    private int id;
    private String descricao;

    public Produto() {
    }

    public Produto(String descricao) {
        this();
        this.descricao = descricao;
    }
    
    
    public Produto(int id, String descricao) {
        this(descricao);
        this.id = id;
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
    
}
