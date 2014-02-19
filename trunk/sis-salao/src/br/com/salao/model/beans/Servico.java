/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.model.beans;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ritacosta
 */
public class Servico implements Serializable{
    
    private Integer codigo;
    
    private Integer categoriaCodigo;
    
    private String descricao;
    
    private Double preco; 
 
    public Servico() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCategoriaCodigo() {
        return categoriaCodigo;
    }

    public void setCategoriaCodigo(Integer categoriaCodigo) {
        this.categoriaCodigo = categoriaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        hash = 79 * hash + Objects.hashCode(this.categoriaCodigo);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.preco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.categoriaCodigo, other.categoriaCodigo)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "codigo=" + codigo + ", categoriaCodigo=" + categoriaCodigo + ", descricao=" + descricao + ", preco=" + preco + '}';
    }
    

}
