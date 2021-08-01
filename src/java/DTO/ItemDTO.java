/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PRREDETOR
 */
public class ItemDTO {
    String itemID,itemName,cateid,color;
    int useday;

    public ItemDTO() {
    }

    public ItemDTO(String itemID, String itemName, String cateid, String color, int useday) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.cateid = cateid;
        this.color = color;
        this.useday = useday;
    }

    public ItemDTO(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getUseday() {
        return useday;
    }

    public void setUseday(int useday) {
        this.useday = useday;
    }
    
}
