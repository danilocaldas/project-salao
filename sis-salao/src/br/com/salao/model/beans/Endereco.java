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
public class Endereco implements Serializable {

    private Integer codigo;
    private Integer cidadeCodigo;
    private String rua;
    private String complemento;
    private Integer numero;
    private String bairro;
    private Integer cep;
   
    public Endereco() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCidadeCodigo() {
        return cidadeCodigo;
    }

    public void setCidadeCodigo(Integer cidadeCodigo) {
        this.cidadeCodigo = cidadeCodigo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        hash = 43 * hash + Objects.hashCode(this.cidadeCodigo);
        hash = 43 * hash + Objects.hashCode(this.rua);
        hash = 43 * hash + Objects.hashCode(this.complemento);
        hash = 43 * hash + Objects.hashCode(this.numero);
        hash = 43 * hash + Objects.hashCode(this.bairro);
        hash = 43 * hash + Objects.hashCode(this.cep);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.cidadeCodigo, other.cidadeCodigo)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "codigo=" + codigo + ", cidadeCodigo=" + cidadeCodigo + ", rua=" + rua + ", complemento=" + complemento + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + '}';
    }

   

  
}
