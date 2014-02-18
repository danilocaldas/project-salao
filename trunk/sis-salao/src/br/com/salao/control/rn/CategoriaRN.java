/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.rn;

import br.com.salao.control.dao.CategoriaDAO;
import br.com.salao.control.interfaces.ICategoriaDAO;
import br.com.salao.model.beans.Categoria;
import java.util.List;



/**
 *
 * @author ritacosta
 */
public class CategoriaRN {
    
    private ICategoriaDAO dao;

    public CategoriaRN() {
        this.dao = new CategoriaDAO();
    }
    
    
    public int save(Categoria categoria){
        return this.dao.save(categoria);
    }
    
    
    public int update(Categoria categoria){
       return this.dao.udpate(categoria);
    }
    
    
    public int delete(Integer codigo){
       return this.dao.delete(codigo);
    }
    
    public List<Categoria> listarTodas(){
        return this.dao.listCategoriaAll();
    }
    
}
