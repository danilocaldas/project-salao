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
    private static final String sqlUpdate = "update servico set descricao = ?, preco = ? where codigo = ?";
    private static final String sqlDelete = "delete from servico where codigo = ?";
    private static final String sqlList = "SELECT servico.*, categoria.descricao FROM servico INNER JOIN \n" +
"categoria ON servico.categoria_codigo = categoria.codigo WHERE\n" +
"categoria.codigo like ? ORDER BY servico.descricao ASC";

    @Override
    public int save(Servico servico) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(1, servico.getCategoria().getCodigo());
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
            pstm.setString(1, servico.getDescricao());
            pstm.setDouble(2, servico.getPreco());
            pstm.setInt(3, servico.getCodigo());
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
                //DBConnection.close(conn, pstm, null);
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
            
        }
        return result;
    }

    @Override
    public List<Servico> listAll(Integer categoriaCodigo) {
        Connection conn = null;
        PreparedStatement pstm = null;
        List<Servico> servicos = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm.setInt(1, categoriaCodigo);
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico();
                Categoria categoria = new Categoria();
                servico.setDescricao(rs.getString("descricao"));
                servico.setPreco(rs.getDouble("preco"));
                categoria.setDescricao(rs.getString("descricao"));
                servicos.add(servico);
                categorias.add(categoria);
                
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                
                ex1.printStackTrace();
            } finally {
                //DBConnection.close(conn, pstm, rs);
                ConnectionFactory.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
        return servicos;
    }
}
