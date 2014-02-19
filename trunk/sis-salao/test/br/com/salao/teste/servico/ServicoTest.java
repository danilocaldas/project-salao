/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.teste.servico;

import br.com.salao.control.rn.ServicoRN;
import br.com.salao.model.beans.Servico;
import org.junit.Test;

/**
 *
 * @author ritacosta
 */
public class ServicoTest {

  //@Test
    public void save() {
        

        Servico servico = new Servico();
        servico.setDescricao("Tratamento de Hidratação");
        servico.setPreco(350.00);
        servico.setCategoriaCodigo(1);
        
        Servico servico2 = new Servico();
        servico2.setDescricao("Tratamento de Queratinização");
        servico2.setPreco(280.00);
        servico2.setCategoriaCodigo(1);

        ServicoRN rn = new ServicoRN();
        //rn.save(servico);
        rn.save(servico2);

    }

    //@Test
    public void update() {

        Servico servico = new Servico();
        servico.setCategoriaCodigo(1);
        servico.setPreco(400.00);
        servico.setDescricao("Tratamento de Hidratação");
        servico.setCodigo(2);

        ServicoRN rn = new ServicoRN();
        rn.update(servico);

    }

    //@Test
    public void delete() {
        int codigo = 3;
        Servico servico = new Servico();
        servico.setCodigo(codigo);

        ServicoRN rn = new ServicoRN();
        rn.delete(codigo);


    }

    @Test
    public void listar(){
         
        ServicoRN rn = new ServicoRN();
        System.out.println(rn.listarServicos());
       
    }
}
