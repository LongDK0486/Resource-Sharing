/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author PRREDETOR
 */
public class UserDTO {
    String userid,username,password,roleID,email,address;
    int phone;
    boolean status;
    Date createdate;
    String verifycode;

    public UserDTO() {
    }

    public UserDTO(String userid, String email, String verifycode) {
        this.userid = userid;
        this.email = email;
        this.verifycode = verifycode;
    }

    
    public UserDTO(String userid, String username, String password, String roleID, String email, String address, int phone, boolean status, Date createdate) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.createdate = createdate;
    }

    public UserDTO(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getVerifycode() {
        return verifycode;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    
}
