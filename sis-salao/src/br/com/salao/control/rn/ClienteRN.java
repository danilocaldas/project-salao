/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.rn;

import br.com.salao.control.dao.ClienteDAO;
import br.com.salao.control.interfaces.IClienteDAO;
import br.com.salao.model.beans.Cliente;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ClienteRN {
    
    private IClienteDAO dao;

    public ClienteRN() {
        this.dao = new ClienteDAO();
    }
    
    public int save (Cliente cliente){
        return this.dao.save(cliente);
    }
    
    
    public int update(Cliente cliente){
        return this.dao.save(cliente);
    }
    
    public int delete(Integer codigo){
        return this.dao.delete(codigo);
    }
    
    public List<Cliente> listarTodos(){
        return this.dao.listarTodos();
    }
    
    
}
