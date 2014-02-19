/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Pais;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IPaisDAO {
    
    public int save(Pais pais);
    public int update(Pais pais);
    public int delete(Integer codigo);
    public List<Pais> listarTodos();
    
}
