/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.ICidadeDAO;
import br.com.salao.model.beans.Cidade;
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
public class CidadeDAO implements ICidadeDAO {

    public static final String sqlInsert = "";
    public static final String sqlUpdate = "";
    public static final String sqlDelete = "";
    public static final String sqlList = "";

    @Override
    public int save(Cidade cidade) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(1, cidade.getEstadoCodigo());
            pstm.setString(2, cidade.getNome());
            pstm.setString(3, cidade.getSigla());
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
    public int update(Cidade cidade) {
         Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setInt(1, cidade.getEstadoCodigo());
            pstm.setString(2, cidade.getNome());
            pstm.setString(3, cidade.getSigla());
            pstm.setInt(4, cidade.getCodigo());
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
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
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
    public List<Cidade> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cidade> cidades = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cidade cidade = new Cidade();
                cidade.setCodigo(rs.getInt("codigo"));
                cidade.setEstadoCodigo(rs.getInt("estado_codigo"));
                cidade.setNome(rs.getString("nome"));
                cidade.setSigla(rs.getString("sigla"));
                cidades.add(cidade);
            }
        } catch (SQLException ex) {
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally{
                ConnectionFactory.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
        return cidades;
    }
}
