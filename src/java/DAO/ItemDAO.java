/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ItemDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRREDETOR
 */
public class ItemDAO {
    Connection conn=null;
    PreparedStatement ps =null;
    ResultSet rs=null;
    public void closeConnection() throws SQLException{
        if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
    }
    /*public List<ItemDTO>Search(String search) throws SQLException{
        List<ItemDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select itemID,itemName,categoryID,color,usingdate"
                        + " From tblItem"
                        + " Where itemName Like ? ";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+ search +"%");
                rs=ps.executeQuery();
                while(rs.next()){
                    String itemid=rs.getString("itemID");
                    String itemname=rs.getString("itemName");
                    String cateid=rs.getString("categoryID");
                    String color=rs.getString("color");
                    int useday=rs.getInt("usingdate");
                    if(list==null){
                        
                        list=new ArrayList<>();
                    }
                   
                    list.add(new ItemDTO(itemid, itemname, cateid, color, useday));                   
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }*/
    public List<ItemDTO>Search2(String search,String searchcate,int index) throws SQLException{
        List<ItemDTO> list=null;       
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select itemID,itemName,categoryID,color,usingdate"
                        + " From tblItem"
                        + " Where itemName Like ? ORDER BY itemID OFFSET ? ROWS FETCH NEXT 2 ROWS ONLY";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+ search +"%");
                ps.setInt(2, (index - 1) * 2);
                //ps.setString(2,searchcate);
                rs=ps.executeQuery();
                
                while(rs.next()){
                    String itemid=rs.getString("itemID");
                    String itemname=rs.getString("itemName");
                    String cateid=rs.getString("categoryID");
                    String color=rs.getString("color");
                    int useday=rs.getInt("usingdate");
                    if(list==null){     
                        list=new ArrayList<>();
                    }
                    if(searchcate.equals("0")||cateid.equals(searchcate)){
                    list.add(new ItemDTO(itemid, itemname, cateid, color, useday));
                    }
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
    public List<ItemDTO>Search3(String search,String searchcate,int day,int index) throws SQLException{
        List<ItemDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select itemID,itemName,categoryID,color,usingdate"
                        + " From tblItem"
                        + " Where itemName Like ? and usingdate=? ORDER BY itemID OFFSET ? ROWS FETCH NEXT 2 ROWS ONLY";
                ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+ search +"%");
                ps.setInt(2,day );
                ps.setInt(3, (index - 1) * 2);
                rs=ps.executeQuery();
                while(rs.next()){
                    String itemid=rs.getString("itemID");
                    String itemname=rs.getString("itemName");
                    String cateid=rs.getString("categoryID");
                    String color=rs.getString("color");
                    int useday=rs.getInt("usingdate");
                    if(list==null){                        
                        list=new ArrayList<>();
                    }
                    if(searchcate.equals("0")||cateid.equals(searchcate)){
                    list.add(new ItemDTO(itemid, itemname, cateid, color, useday));
                    }                   
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return list;
    }
    public int count(String search, int useday) throws SQLException{
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select COUNT(*)"
                        + " From tblItem"                       
                        + " Where itemName Like ?  and usingdate >=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");               
                ps.setInt(2, useday);
                rs=ps.executeQuery();
                while(rs.next()){
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return -1;
    }
    
}
