/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.ItemDTO;
import DTO.RequestDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRREDETOR
 */
public class RequestDAO {
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
    public List<RequestDTO> getREQ() throws SQLException{
        List<RequestDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select requestid,userID,itemID,categoryID,datecreatereq,status"
                        + " From tblrequest";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    String requestid=rs.getString("requestid");
                    String userid=rs.getString("userID");
                    String itemID=rs.getString("itemID");
                    String cateID=rs.getString("categoryID");
                    Date datecreate=rs.getDate("datecreatereq");
                    String status=rs.getString("status");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new RequestDTO(requestid,userid, itemID, cateID, status, datecreate));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
    public void insert(RequestDTO req) throws SQLException{
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Insert into tblrequest(userID,itemID,categoryID,datecreatereq,status)"
                        + " Values(?,?,?,?,?)";
                ps=conn.prepareStatement(sql);
                ps.setString(1, req.getUserID());
                ps.setString(2, req.getItemID());
                ps.setString(3, req.getCateID());
                ps.setDate(4, req.getCreatereq());
                ps.setString(5, req.getStatus());
                ps.executeUpdate();
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
    }
     
     public List<ItemDTO> getitemName() throws SQLException{
        List<ItemDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select itemName,itemID"
                        + " From tblItem";
                ps=conn.prepareStatement(sql);
              
                rs=ps.executeQuery();
                while(rs.next()){       
                    String itemname=rs.getString("itemName");  
                    String itemid=rs.getString("itemID");  
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new ItemDTO(itemid, itemname));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
      public List<RequestDTO> searchREQ(String search,String searchstatus) throws SQLException{
         List<RequestDTO> list = null;           
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select requestid,userID,itemID,categoryID,datecreatereq,status"
                        + " From tblrequest"
                        + " Where status=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, searchstatus);
                
                rs = ps.executeQuery();
                while (rs.next()) {
                    String reqid = rs.getString("requestid");
                    String userid = rs.getString("userID");
                    String itemID = rs.getString("itemID");
                    String cateID = rs.getString("categoryID");
                    Date datecreate = rs.getDate("datecreatereq");
                    String status = rs.getString("status");
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    if (search.equals("0") || search.equals(itemID)) {
                        list.add(new RequestDTO(reqid, userid, itemID, cateID, status, datecreate));
                    }
                }
            }                  
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }
      public String chancestatus(String reqid,String status) throws SQLException{
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Update tblrequest Set status=?"
                        + " Where requestid=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, status);
                ps.setString(2, reqid);
                rs = ps.executeQuery();

            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return null;
    }
      
      public List<RequestDTO> searchHistory(String userID) throws SQLException{
        List<RequestDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select requestid,userID,itemID,categoryID,datecreatereq,status"
                        + " From tblrequest"
                        + " Where userID=? ";
                ps=conn.prepareStatement(sql);
                ps.setString(1, userID);
                rs=ps.executeQuery();
                while(rs.next()){
                    String reqid=rs.getString("requestid");
                    String userid=rs.getString("userID");
                    String itemID=rs.getString("itemID");
                    String cateID=rs.getString("categoryID");
                    Date datecreate=rs.getDate("datecreatereq");
                    String status=rs.getString("status");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    if(status.equals("active")||status.equals("inactive")||status.equals("new")){
                        list.add(new RequestDTO(reqid,userid, itemID, cateID, status, datecreate));
                    }
              
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
      public List<RequestDTO> searchHistorydate(String userID,String date) throws SQLException{
        List<RequestDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select requestid,userID,itemID,categoryID,datecreatereq,status"
                        + " From tblrequest"
                        + " Where userID=? and datecreatereq = ?";
                ps=conn.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, date);
                rs=ps.executeQuery();
                while(rs.next()){
                    String reqid=rs.getString("requestid");
                    String userid=rs.getString("userID");
                    String itemID=rs.getString("itemID");
                    String cateID=rs.getString("categoryID");
                    Date datecreate=rs.getDate("datecreatereq");
                    String status=rs.getString("status");
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    if(status.equals("active")||status.equals("inactive")||status.equals("new")){
                        list.add(new RequestDTO(reqid,userid, itemID, cateID, status, datecreate));
                    }
              
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }

   public int count(String search) throws SQLException{
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select COUNT(*),itemID"
                        + " From tblrequest"                       
                        + " Where status=? ";
                ps = conn.prepareStatement(sql);
                ps.setString(1, search);
                
                rs=ps.executeQuery();
                while(rs.next()){                                       
                         rs.getInt(1);                   
                }
                
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return -1;
    }
  
   
}
