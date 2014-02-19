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
public class Cidade implements Serializable{
    
    private Integer codigo;
    
    private Integer estadoCodigo;
    
    private String nome;
    
    private String sigla;
    
    
    public Cidade() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getEstadoCodigo() {
        return estadoCodigo;
    }

    public void setEstadoCodigo(Integer estadoCodigo) {
        this.estadoCodigo = estadoCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codigo);
        hash = 59 * hash + Objects.hashCode(this.estadoCodigo);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.sigla);
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
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.estadoCodigo, other.estadoCodigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidade{" + "codigo=" + codigo + ", estadoCodigo=" + estadoCodigo + ", nome=" + nome + ", sigla=" + sigla + '}';
    }

    
    
   
}
