/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.teste.categoria;

import br.com.salao.control.rn.CategoriaRN;
import br.com.salao.model.beans.Categoria;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author ritacosta
 */
public class CategoriaTest {

    //@Test
    public void salvar() {
        Categoria categoria1 = new Categoria();
        categoria1.setDescricao("tratamento");

        Categoria categoria2 = new Categoria();
        categoria2.setDescricao("depilação");

        CategoriaRN rn = new CategoriaRN();
        rn.save(categoria1);
        rn.save(categoria2);
    }
    //@Test

    public void update() {
        Categoria categoria = new Categoria();
        categoria.setDescricao("tratamento");
        categoria.setCodigo(4);

        CategoriaRN rN = new CategoriaRN();
        rN.update(categoria);
    }

   // @Test
    public void delete() {
        int codigo = 5;
        Categoria categoria = new Categoria();
        categoria.setCodigo(codigo);

        CategoriaRN rN = new CategoriaRN();
        rN.delete(codigo);

    }
    
    //@Test
    public void listar(){
        //Categoria categoria = new Categoria();
        CategoriaRN rN = new CategoriaRN();
        System.out.println(rN.listarTodas());
    }
}
