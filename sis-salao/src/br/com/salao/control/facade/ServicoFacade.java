/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.facade;

import br.com.salao.control.rn.ServicoRN;
import br.com.salao.model.beans.Servico;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ServicoFacade {
    
    private ServicoRN rn;

    public ServicoFacade() {
    
        this.rn = new ServicoRN();
    }
    
    
    public int save(Servico servico){
        return this.rn.save(servico);
    }
    
    public int update(Servico servico){
        return this.rn.update(servico);
    }
 
    public int delete(Integer codigo){
        return this.rn.delete(codigo);
    }
    
    public List<Servico> listarTodos(Integer categoriaCodigo){
        return this.rn.listarServicos(categoriaCodigo);
    }
    
    
}
