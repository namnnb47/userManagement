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
import namnnb.dtos.UserDTO;

/**
 *
 * @author Admin
 */
public class UserDAO implements Serializable {

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

    public int checkLogin(String userName, String password) throws SQLException, NamingException {
        int roleid = -1;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select roleid from tbl_User where username = ? and password = ? and status = 'Active'";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                rs = pst.executeQuery();

                if (rs.next()) {
                    roleid = rs.getInt("roleid");
                }
            }
        } finally {
            closeConnection();
        }
        return roleid;
    }

    public String getFullName(String username) throws SQLException, NamingException {
        String fullname = "";
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "select fullname from tbl_user where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, username);
                rs = pst.executeQuery();
                if (rs.next()) {
                    fullname = rs.getString("fullname");
                }
            }
        } finally {
            closeConnection();
        }
        return fullname;
    }

    public List<UserDTO> searchUserByName(String name) throws SQLException, NamingException {
        UserDTO dto = null;
        List<UserDTO> listUser = new ArrayList<>();
        try {
            con = DBConnection.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where fullname like ? and status = 'Active'";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            rs = pst.executeQuery();
            while (rs.next()) {

                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                dto = new UserDTO(userName, password, fullName, phone, role, photo, email, status);
                listUser.add(dto);
            }
        } finally {
            closeConnection();
        }
        return listUser;
    }

    public List<UserDTO> searchUserByNameAndRole(String name, int roleId) throws SQLException, NamingException {
        List<UserDTO> result = new ArrayList<>();
        UserDTO dto = null;
        try {
            con = DBConnection.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where fullname like ? and roleid = ? and status = 'Active'";
            pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            pst.setInt(2, roleId);
            rs = pst.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                dto = new UserDTO(userName, password, fullName, phone, role, photo, email, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean deleteUser(String userName) throws SQLException, NamingException {
        boolean check = false;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "update tbl_user set status = ? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, "Inactive");
                pst.setString(2, userName);
                check = pst.executeUpdate() > 0;
            }

        } finally {
            closeConnection();
        }
        return check;
    }

    public UserDTO loadInfor(String username) throws SQLException, NamingException {
        UserDTO dto = null;
        try {
            con = DBConnection.makeConnection();
            String sql = "select username, password, fullname, roleid, email, phone, photo, status from tbl_user where username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            while (rs.next()) {

                String userName = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String phone = rs.getString("phone");
                int role = rs.getInt("roleid");
                String photo = rs.getString("photo");
                String email = rs.getString("email");
                String status = rs.getString("status");
                dto = new UserDTO(userName, password, fullName, phone, role, photo, email, status);               
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateUser(String fullName, String oldUserName, String password, String email, String phone, String photo, int roleId) throws SQLException, NamingException {
        boolean check = false;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "update tbl_user set fullName = ?, password = ?, email = ?, phone = ?, photo = ?, roleid =? where username = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, fullName);
                pst.setString(2, password);
                pst.setString(3, email);
                pst.setString(4, phone);
                pst.setString(5, photo);
                pst.setInt(6, roleId);
                pst.setString(7, oldUserName);
                check = pst.executeUpdate()>0;
            }

        } finally {

            closeConnection();
        }
        return check;
    }

    public boolean isDuplicateUserName(String username) throws SQLException, NamingException {
        boolean check=false;
        try {
            con = DBConnection.makeConnection();
            String sql = "select username from tbl_user where username = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insertUser(String userName, String fullName, String password, String email, String phone, String photo, int roleId) throws SQLException, NamingException {
        boolean check = false;
        try {
            con = DBConnection.makeConnection();
            if (con != null) {
                String sql = "insert tbl_user(username, password,fullname, email, phone, photo, roleid, status) values(?,?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setString(1, userName);
                pst.setString(2, password);
                pst.setString(3, fullName);
                pst.setString(4, email);
                pst.setString(5, phone);
                pst.setString(6, photo);
                pst.setInt(7, roleId);
                pst.setString(8, "Active");

                check = pst.executeUpdate()>0;
            }

        } finally {

            closeConnection();
        }
        return check;
    }

}
