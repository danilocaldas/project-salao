/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.IPaisDAO;
import br.com.salao.model.beans.Pais;
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
public class PaisDAO implements IPaisDAO {

    private static final String sqlInsert = "";
    private static final String sqlList = "";
    private static final String sqlUpdate = "";
    private static final String sqlDelete = "";
    

    @Override
    public int save(Pais pais) {
        Connection conn = null;
        PreparedStatement pstm = null;
        int result = 0;
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(1,  pais.getNome());
            pstm.setString(2, pais.getSigla());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Pais pais) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(1,  pais.getNome());
            pstm.setString(2, pais.getSigla());
            pstm.setInt(3, pais.getCodigo());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
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
                if(conn != null){
                    conn.rollback();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                ConnectionFactory.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Pais> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Pais> paises = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pais pais = new Pais();
                pais.setCodigo(rs.getInt("codigo"));
                pais.setNome(rs.getString("nome"));
                pais.setSigla(rs.getString("sigla"));
                paises.add(pais);
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionFactory.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
        return paises;
    }
}
