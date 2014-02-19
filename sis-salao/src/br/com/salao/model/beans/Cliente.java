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
public class Cliente implements Serializable {

    private Integer codigo;
    private Integer enderecoCodigo;
    private String nome;
    private Integer telefone;
    private Integer celular;
    private Integer rg;
    private Integer cpf;
    private String email;
    

    public Cliente() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getEnderecoCodigo() {
        return enderecoCodigo;
    }

    public void setEnderecoCodigo(Integer enderecoCodigo) {
        this.enderecoCodigo = enderecoCodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        hash = 43 * hash + Objects.hashCode(this.enderecoCodigo);
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.telefone);
        hash = 43 * hash + Objects.hashCode(this.celular);
        hash = 43 * hash + Objects.hashCode(this.rg);
        hash = 43 * hash + Objects.hashCode(this.cpf);
        hash = 43 * hash + Objects.hashCode(this.email);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.enderecoCodigo, other.enderecoCodigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", enderecoCodigo=" + enderecoCodigo + ", nome=" + nome + ", telefone=" + telefone + ", celular=" + celular + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + '}';
    }

  
}
