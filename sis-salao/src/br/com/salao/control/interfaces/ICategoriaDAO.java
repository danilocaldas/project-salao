/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Categoria;
import br.com.salao.model.beans.Servico;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface ICategoriaDAO {
    
    public int save(Categoria categoria);
    
    public int udpate(Categoria categoria);
    
    public int delete(Integer codigo);
    
    public List<Categoria> listCategoriaAll();
    
    public List<Servico> listServicoAll();
    
}
