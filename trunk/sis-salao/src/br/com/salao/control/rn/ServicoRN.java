/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.rn;

import br.com.salao.control.dao.ServicoDAO;
import br.com.salao.control.interfaces.IServicoDAO;
import br.com.salao.model.beans.Servico;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ServicoRN {

    private IServicoDAO dao;

    public ServicoRN() {
        this.dao = new ServicoDAO();
    }
    
    public int save(Servico servico){
       return this.dao.save(servico);
    }
    
    public int update(Servico servico){
        
       return this.dao.update(servico);
    }
    
    public int delete(Integer codigo){
       return this.dao.delete(codigo);
    }
    
    public List<Servico> listarServicos(Integer categoriaCodigo){
        return this.dao.listAll(categoriaCodigo);
    }
    
}
