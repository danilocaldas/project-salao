/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Cliente;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IClienteDAO {
    
    public int save(Cliente cliente);
    
    public int update(Cliente cliente);
    
    public int delete(Integer codigo);
    
    public List<Cliente> listarTodos();
    
}
