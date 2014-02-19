/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.facade;

import br.com.salao.control.rn.EnderecoRN;
import br.com.salao.model.beans.Endereco;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class EnderecoFacade {
    
    private EnderecoRN rn;

    public EnderecoFacade() {
        this.rn = new EnderecoRN();
    }
    
    
    public int save (Endereco endereco){
       return this.rn.save(endereco);
    }
    
    public int update(Endereco endereco){
        return this.rn.update(endereco);
    }
    
    public int delete(Integer codigo){
        return this.rn.delete(codigo);
    }
    
    public List<Endereco> listarTodos(){
        return this.rn.listarTodos();
    }
  
}
