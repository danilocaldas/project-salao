/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.model.beans;

import java.util.Objects;

/**
 *
 * @author ritacosta
 */
public class Estado {
    
    
    private Integer codigo;
    
    private Integer paisCodigo;
    
    private String nome;
    
    private String sigla;
    
    

    public Estado() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getPaisCodigo() {
        return paisCodigo;
    }

    public void setPaisCodigo(Integer paisCodigo) {
        this.paisCodigo = paisCodigo;
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
        hash = 59 * hash + Objects.hashCode(this.paisCodigo);
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
        final Estado other = (Estado) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.paisCodigo, other.paisCodigo)) {
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
        return "Estado{" + "codigo=" + codigo + ", paisCodigo=" + paisCodigo + ", nome=" + nome + ", sigla=" + sigla + '}';
    }

   
}
