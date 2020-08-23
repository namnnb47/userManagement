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
public class PromotionDTO implements Serializable{
    String userName;
    int rank;
    String date;

    public PromotionDTO() {
    }

    public PromotionDTO(String userName, int rank, String date) {
        this.userName = userName;
        this.rank = rank;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
