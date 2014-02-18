/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.teste.servico;

import br.com.salao.control.rn.ServicoRN;
import br.com.salao.model.beans.Categoria;
import br.com.salao.model.beans.Servico;
import org.junit.Test;

/**
 *
 * @author ritacosta
 */
public class ServicoTest {

   //@Test
    public void save() {
        Categoria categoria = new Categoria();
        categoria.setCodigo(1);

        Servico servico = new Servico();
        servico.setDescricao("Escova termica");
        servico.setPreco(350.00);
        servico.setCategoria(categoria);

        ServicoRN rn = new ServicoRN();
        rn.save(servico);

    }

    //@Test
    public void update() {

        Servico servico = new Servico();
        servico.setPreco(400.00);
        servico.setDescricao("Escova Termica");
        servico.setCodigo(7);

        ServicoRN rn = new ServicoRN();
        rn.update(servico);

    }

    //@Test
    public void delete() {
        int codigo = 7;
        Servico servico = new Servico();
        servico.setCodigo(codigo);

        ServicoRN rn = new ServicoRN();
        rn.delete(codigo);


    }

    @Test
    public void listar(){
         
        int codigo = 1;
        
        
        ServicoRN rn = new ServicoRN();
        System.out.println(rn.listarServicos(1)); 
        
    }
}
