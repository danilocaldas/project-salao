/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Estado;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IEstadoDAO {
    
    public int save(Estado estado);
    public int update(Estado estado);
    public int delete(Integer codigo);
    public List<Estado> listarTodos();
}
