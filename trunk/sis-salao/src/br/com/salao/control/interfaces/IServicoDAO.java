/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Servico;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IServicoDAO {
    
    public int save(Servico servico);
    
    public int update(Servico servico);
    
    public int delete(Integer id);
    
    public List<Servico> listAll();
    
    
}
