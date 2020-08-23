/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namnnb.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import namnnb.datasource.DBConnection;
import namnnb.dtos.PromotionDTO;

/**
 *
 * @author Acer
 */
public class PromotionDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public void closeConnection() throws SQLException, NamingException {
        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public boolean insertToPromotionList(String username, int rank, String date) throws SQLException, NamingException {
        boolean check = false;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "insert tbl_promotion(username, rank, date) values(?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                pst.setInt(2, rank);
                pst.setString(3, date);
                check = pst.executeUpdate() > 0;
            }
        } finally {

            closeConnection();
        }
        return check;
    }

    public boolean isAddedToPromotionList(String username) throws SQLException, NamingException {
        boolean check = false;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select username from tbl_promotion where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateUserOnPromotionList(String username, int rank, String date) throws SQLException, NamingException {
        boolean check = false;

        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "update tbl_promotion set rank = ?, date = ? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(3, username);
                pst.setInt(1, rank);
                pst.setString(2, date);
                check = pst.executeUpdate() > 0;
            }
        } finally {

            closeConnection();
        }
        return check;
    }

    public List<PromotionDTO> loadHistory() throws SQLException, NamingException {
        PromotionDTO dto = null;
        List<PromotionDTO> result = new ArrayList<>();
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select username, rank, date from tbl_promotion ORDER BY CONVERT(DATE, date) asc";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery(sql);
                while (rs.next()) {
                    String username = rs.getString("username");
                    int rank = rs.getInt("rank");
                    String date = rs.getString("date");
                    dto = new PromotionDTO(username, rank, date);
                    result.add(dto);
                }

            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
