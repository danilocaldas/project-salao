/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.rn;

import br.com.salao.control.dao.EnderecoDAO;
import br.com.salao.control.interfaces.IEnderecoDAO;
import br.com.salao.model.beans.Endereco;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class EnderecoRN {
    
    private IEnderecoDAO dao;

    public EnderecoRN() {
        
        this.dao = new EnderecoDAO();
    }
    
    
    public int save(Endereco endereco){
        return this.dao.save(endereco);
    }
    
    public int update(Endereco endereco){
        return this.dao.update(endereco);
    }
    
    public int delete(Integer codigo){
        return this.dao.delete(codigo);
    }
    
    public List<Endereco> listarTodos(){
        return this.dao.listarTodos();
    }
    
    
}
