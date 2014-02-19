/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.interfaces;

import br.com.salao.model.beans.Endereco;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public interface IEnderecoDAO {
    
    public int save (Endereco endereco);
    public int update (Endereco endereco);
    public int delete (Integer codigo);
    public List<Endereco> listarTodos ();
}
