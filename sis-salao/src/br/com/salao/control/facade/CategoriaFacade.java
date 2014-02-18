/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.facade;

import br.com.salao.control.rn.CategoriaRN;
import br.com.salao.model.beans.Categoria;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class CategoriaFacade {
    
    private CategoriaRN rN;

    public CategoriaFacade() {
      this.rN = new CategoriaRN();
    }
    
    public int save(Categoria categoria){
       return this.rN.save(categoria);
    }
    
    public int update(Categoria categoria){
       return this.rN.update(categoria);
    }
    
    public int delete(Integer codigo){
       return this.rN.delete(codigo);
    }
    
    public List<Categoria> listaTodas(){
        return this.rN.listarTodas();
    }
}
