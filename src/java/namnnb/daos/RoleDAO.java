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
import namnnb.dtos.RoleDTO;

/**
 *
 * @author Admin
 */
public class RoleDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public void closeConnection() throws SQLException, NamingException{
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
    
//   List<RoleDTO> listRole;

    public List<RoleDTO> getListRole() throws SQLException, NamingException {
        RoleDTO dto = null;
        List<RoleDTO> listRole = new ArrayList<>();
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select roleid, rolename from tbl_role";
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery(sql);
                while (rs.next()) {
                    int roleid = rs.getInt("roleid");
                    String rolename = rs.getString("rolename");
                    dto = new RoleDTO(roleid, rolename);                   
                    listRole.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return listRole;
    }

    public String getRoleName(int roleId) throws SQLException, NamingException{
        String rolename = "";
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select rolename from tbl_role where roleid = ?";
                pst = con.prepareStatement(sql);
                pst.setInt(1, roleId);
                rs = pst.executeQuery();
                if (rs.next()) {
                    rolename = rs.getString("rolename");
                }
            }
        } finally {
            closeConnection();
        }
        return rolename;
    }
}
