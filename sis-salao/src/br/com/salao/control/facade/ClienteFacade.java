/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.facade;

import br.com.salao.control.rn.ClienteRN;
import br.com.salao.model.beans.Cliente;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ClienteFacade {

    private ClienteRN rn;

    public ClienteFacade() {
        this.rn = new ClienteRN();
    }

    public int save(Cliente cliente) {
        return this.rn.save(cliente);
    }

    public int update(Cliente cliente) {
        return this.rn.update(cliente);

    }

    public int delete(Integer codigo) {
        return this.rn.delete(codigo);
    }
    
    public List<Cliente> listarTodos(){
        return this.rn.listarTodos();
    }
}
