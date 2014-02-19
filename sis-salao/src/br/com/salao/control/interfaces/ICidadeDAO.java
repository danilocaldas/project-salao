/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Cidade;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface ICidadeDAO {
    
    public int save(Cidade cidade);
    public int update(Cidade cidade);
    public int delete(Integer codigo);
    public List<Cidade> listarTodos();
            
    
}
