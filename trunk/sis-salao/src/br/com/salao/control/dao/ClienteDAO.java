/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.IClienteDAO;
import br.com.salao.model.beans.Cliente;
import br.com.salao.model.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ritacosta
 */
public class ClienteDAO implements IClienteDAO {

    private static final String sqlInsert = "insert into cliente (endereco_codigo, nome, "
            + "telefone, celular, rg, cpf, email) values (?,?,?,?,?,?,?)";
    private static final String sqlUpdate = "update cliente set endereco_codigo = ?, nome = ?, "
            + "telefone = ?, celular = ?, rg = ?, cpf = ?, email = ? where codigo = ?";
    private static final String sqlDelete = "delete from cliente where codigo = ?";
    private static final String sqlList = "select * from cliente";

    @Override
    public int save(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(++index, cliente.getEnderecoCodigo());
            pstm.setString(++index, cliente.getNome());
            pstm.setInt(++index, cliente.getTelefone());
            pstm.setInt(++index, cliente.getCelular());
            pstm.setInt(++index, cliente.getRg());
            pstm.setInt(++index, cliente.getCpf());
            pstm.setString(++index, cliente.getEmail());
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
    public int update(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setInt(++index, cliente.getEnderecoCodigo());
            pstm.setString(++index, cliente.getNome());
            pstm.setInt(++index, cliente.getTelefone());
            pstm.setInt(++index, cliente.getCelular());
            pstm.setInt(++index, cliente.getRg());
            pstm.setInt(++index, cliente.getCpf());
            pstm.setString(++index, cliente.getEmail());
            pstm.setInt(++index, cliente.getCodigo());
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
    public List<Cliente> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setCodigo(rs.getInt("codigo"));
                cliente.setEnderecoCodigo(rs.getInt("endereco_codigo"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getInt("telefone"));
                cliente.setCelular(rs.getInt("celular"));
                cliente.setRg(rs.getInt("rg"));
                cliente.setCpf(rs.getInt("cpf"));
                cliente.setEmail(rs.getString("email"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                
                ex1.printStackTrace();
            } finally {
                ConnectionFactory.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
         return clientes;
    }
}
