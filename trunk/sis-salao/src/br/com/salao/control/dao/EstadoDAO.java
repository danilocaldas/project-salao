/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.salao.control.dao;

import br.com.salao.control.interfaces.IEstadoDAO;
import br.com.salao.model.beans.Estado;
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
public class EstadoDAO implements IEstadoDAO{

    public static final String sqlInsert = "";
    public static final String sqlUpdate = "";
    public static final String sqlDelete = "";
    public static final String sqlList = "";
    
    
    @Override
    public int save(Estado estado) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setInt(1, estado.getPaisCodigo());
            pstm.setString(2, estado.getNome());
            pstm.setString(3, estado.getSigla());
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
    public int update(Estado estado) {
        Connection conn = null;
        PreparedStatement pstm = null;
        conn = ConnectionFactory.getConnection();
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setInt(1, estado.getPaisCodigo());
            pstm.setString(2, estado.getNome());
            pstm.setString(3, estado.getSigla());
            pstm.setInt(4, estado.getCodigo());
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
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setInt(1, codigo );
            
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
    public List<Estado> listarTodos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Estado> estados = new ArrayList<>();
        try {
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while(rs.next()){
                Estado estado = new Estado();
                estado.setCodigo(rs.getInt("codigo"));
                estado.setPaisCodigo(rs.getInt("pais_codigo"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                estados.add(estado);
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
        return estados;
    }
   
    
}
