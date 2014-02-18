/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.ICategoriaDAO;
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
public class CategoriaDAO implements ICategoriaDAO {

    private static final String sqlInsert = "insert into categoria (descricao) values (?)";
    private static final String sqlUpdate = "update categoria set descricao = ? where codigo = ?";
    private static final String sqlDelete = "delete from categoria where codigo = ?";
    private static final String sqlList = "select * from categoria";

    @Override
    public int save(Categoria categoria) {

        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(1, categoria.getDescricao());
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
    public int udpate(Categoria categoria) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(1, categoria.getDescricao());
            pstm.setInt(2, categoria.getCodigo());
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
            pstm.setLong(1, codigo);
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
    public List<Categoria> listCategoriaAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        List<Categoria> categorias = new ArrayList<Categoria>();
        ResultSet rs = null;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Categoria category = new Categoria();
                category.setDescricao(rs.getString("descricao"));
                categorias.add(category);
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
        return categorias;
     
    }

    @Override
    public List<Servico> listServicoAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
