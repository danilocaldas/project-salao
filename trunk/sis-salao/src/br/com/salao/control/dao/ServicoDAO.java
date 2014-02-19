/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.IServicoDAO;
import br.com.salao.model.beans.Categoria;
import br.com.salao.model.beans.Servico;
import br.com.salao.model.utils.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ServicoDAO implements IServicoDAO {

    private static final String sqlInsert = "insert into servico (categoria_codigo, descricao, preco) values (?, ?, ?)";
    private static final String sqlUpdate = "update servico set categoria_codigo = ? ,descricao = ?, preco = ? where codigo = ?";
    private static final String sqlDelete = "delete from servico where codigo = ?";
    private static final String sqlList = "select * from servico";

    @Override
    public int save(Servico servico) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(1, servico.getCategoriaCodigo());
            pstm.setString(2, servico.getDescricao());
            pstm.setDouble(3, servico.getPreco());
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
    public int update(Servico servico) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setInt(1, servico.getCategoriaCodigo());
            pstm.setString(2, servico.getDescricao());
            pstm.setDouble(3, servico.getPreco());
            pstm.setInt(4, servico.getCodigo());
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
    public int delete(Integer id) {
         Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlDelete);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                
                ex1.printStackTrace();
            } finally {
              
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
            
        }
        return result;
    }

    @Override
    public List<Servico> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        List<Servico> servicos = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico();
                servico.setCodigo(rs.getInt("codigo"));
                servico.setCategoriaCodigo(rs.getInt("categoria_codigo"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                servicos.add(servico);
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
        return servicos;
    }
}
