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
public class RequestDTO {
    
    String requestid,userID,itemID,cateID,status;
    Date createreq;

    public RequestDTO() {
    }

    public RequestDTO(String requestid, String userID, String itemID, String cateID, String status, Date createreq) {
        this.requestid = requestid;
        this.userID = userID;
        this.itemID = itemID;
        this.cateID = cateID;
        this.status = status;
        this.createreq = createreq;
    }

    public RequestDTO(String userID, String itemID, String cateID, String status, Date createreq) {
        this.userID = userID;
        this.itemID = itemID;
        this.cateID = cateID;
        this.status = status;
        this.createreq = createreq;
    }

    public RequestDTO(String itemID, String status) {
        this.itemID = itemID;
        this.status = status;
    }

    public String getRequestid() {
        return requestid;
    }

    public void setRequestid(String requestid) {
        this.requestid = requestid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCateID() {
        return cateID;
    }

    public void setCateID(String cateID) {
        this.cateID = cateID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatereq() {
        return createreq;
    }

    public void setCreatereq(Date createreq) {
        this.createreq = createreq;
    }

   

    
       

    
    
}
