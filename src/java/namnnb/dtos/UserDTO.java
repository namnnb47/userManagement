/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namnnb.dtos;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserDTO implements Serializable{
    String username;
    String password;
    String fullname;
    String phone;
    int roleID;
    String photo;
    String email;
    String status;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String fullname, String phone, int roleID, String photo, String email, String status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.roleID = roleID;
        this.photo = photo;
        this.email = email;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
