/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.IEnderecoDAO;
import br.com.salao.model.beans.Endereco;
import br.com.salao.model.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class EnderecoDAO implements IEnderecoDAO {

    public static final String sqlInsert = "insert into endereco (cidade_codigo, rua, complemento, numero, bairro, cep)"
            + " values(?,?,?,?,?,?)";
    public static final String sqlUpdate = "update endereco set cidade_codigo = ?, rua = ?, complemento = ?, "
            + "numero = ?, numero = ?, bairro = ? where codigo = ?";
    public static final String sqlDelete = "delete from endereco where codigo = ?";
    public static final String sqlList = "";

    @Override
    public int save(Endereco endereco) { 
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(++index, endereco.getCidadeCodigo());
            pstm.setString(++index, endereco.getRua());
            pstm.setString(++index, endereco.getComplemento());
            pstm.setInt(++index, endereco.getNumero());
            pstm.setString(++index, endereco.getBairro());
            pstm.setInt(++index, endereco.getCep());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }

        return result;

    }

    @Override
    public int update(Endereco endereco) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(++index, endereco.getCidadeCodigo());
            pstm.setString(++index, endereco.getRua());
            pstm.setString(++index, endereco.getComplemento());
            pstm.setInt(++index, endereco.getNumero());
            pstm.setString(++index, endereco.getBairro());
            pstm.setInt(++index, endereco.getCep());
            pstm.setInt(++index, endereco.getCodigo());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(Integer codigo) {
       Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlDelete);
            pstm.setInt(1, codigo);
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Endereco> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
