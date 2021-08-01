/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.ItemDTO;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import DTO.UserDTO;
import Utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Google.Constants;
import Google.GooglePojo;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {
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
    
    public UserDTO login(String id,String password) throws SQLException{
        UserDTO user=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql=" Select userID,fullname,email,datecreate,address,phone,roleID,status"
                        + " From tblUser"
                        + " Where userID='" + id + "' And password='" + password + "'";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){         
                    String name =rs.getString("fullname");
                    String email=rs.getString("email");
                    String address=rs.getString("address");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("roleID");
                    Date date=rs.getDate("datecreate");
                    boolean status=rs.getBoolean("status");
                    if(status==true){
                       user=new UserDTO(id,name, "", roleID, email, address, phone, status, date); 
                    }else{
                        return user;
                    }         
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return user;
    }
    
    public static String getToken(final String code) throws ClientProtocolException, IOException {
    String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
        .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
            .add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
            .add("redirect_uri",Constants.GOOGLE_REDIRECT_URI).add("code", code)
            .add("grant_type", Constants.GOOGLE_GRANT_TYPE).build()) .execute().returnContent().asString();
      JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
      String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
      return accessToken;
  }
  public static GooglePojo getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
    String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
    String response = Request.Get(link).execute().returnContent().asString();
    GooglePojo googlePojo = new Gson().fromJson(response, GooglePojo.class);
    System.out.println(googlePojo);
    return googlePojo;
  }
  
  public UserDTO logingoogle(String gmail) throws SQLException{
        UserDTO user=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql=" Select userID,fullname,email,datecreate,address,phone,roleID,status"
                        + " From tblUser"
                        + " Where email = '" + gmail+ "'";
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    String id =rs.getString("userID");
                    String name =rs.getString("fullname");
                    String email=rs.getString("email");
                    String address=rs.getString("address");
                    int phone=rs.getInt("phone");
                    String roleID=rs.getString("roleID");
                    Date date=rs.getDate("datecreate");
                    boolean status=rs.getBoolean("status");
                    if(status==true){
                       user=new UserDTO(id, name,"", roleID, email, address, phone, status, date); 
                    }else{
                        return user;
                    }         
                }
            }
        } catch (Exception e) {
        }finally{
            closeConnection();
        }
        return user;
    }
  public List<UserDTO> getUserName() throws SQLException{
        List<UserDTO> list=null;
        try {
            conn=DBUtils.getConnection();
            if(conn!=null){
                String sql="Select fullname,userID"
                        + " From tblUser";
                ps=conn.prepareStatement(sql);
              
                rs=ps.executeQuery();
                while(rs.next()){       
                    String username=rs.getString("fullname");  
                    String userid=rs.getString("userID");  
                    if(list==null){
                        list=new ArrayList<>();
                    }
                    list.add(new UserDTO(userid, username));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return list;
    }
  public void insert(UserDTO user) throws SQLException{
      try {
          conn=DBUtils.getConnection();
          if(conn!=null){
              String sql="Insert into tblUser(userID,fullname,password,email,datecreate,address,phone,roleID,status)"
                      + " Values(?,?,?,?,?,?,?,?,?)";
              ps=conn.prepareStatement(sql);
              ps.setString(1, user.getUserid());
              ps.setString(2, user.getUsername());
              ps.setString(3, user.getPassword());
              ps.setString(4, user.getEmail());
              ps.setDate(5, user.getCreatedate());
              ps.setString(6, user.getAddress());
              ps.setInt(7, user.getPhone());
              ps.setString(8, user.getRoleID());
              ps.setBoolean(9, user.isStatus());
              ps.executeUpdate();
          }
      } catch (Exception e) {
      }finally{
          closeConnection();
      }
  }
  public boolean updateStatusUSer(String userID) throws SQLException {
        boolean check = false;
       
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblUser SET status = ?"
                        + " WHERE userID = ?";
                ps = conn.prepareStatement(sql);
                ps.setBoolean(1, true);
                ps.setString(2, userID);
                check = ps.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return check;
    }
}
