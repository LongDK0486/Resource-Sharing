/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DTO.UserDTO;
import DTO.UserError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRREDETOR
 */
public class CreateController extends HttpServlet {
     private static final String SUCCESS="VerifymailController";
    private static final String ERROR="CreateUser.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        UserError error=new UserError("", "", "", "", "", "", "");
        try {            
            String userid=request.getParameter("userID");
            String name=request.getParameter("fullName");
            String address=request.getParameter("address");
             String email=request.getParameter("email");
            int phone =Integer.parseInt("0");
            String password=request.getParameter("password");
            String confirm=request.getParameter("confirm");
            boolean flag=true;
            if(userid.length()<2||userid.length()>20){
                flag=false;
               error.setUserIDERROR("Id not must below than 2  and lager than 20 word ");
            }
            if(name.length()>30){
                flag=false;
                error.setFullnamERROR("Name must not lager than 30");
            }
            if(address.length()<3||address.length()>50){
                flag=false;
                error.setAddressERROR("Address must not below than 3 and lager than 500");
            }           
            if(!password.equals(confirm)){
                flag=false;
                error.setConfirmERROR("password not confirm");
            }
            try {
                phone =Integer.parseInt(request.getParameter("phone"));
                if(phone<=0){
                    flag=false;
                    error.setPhoneERROR("Phone number must be 11 digit");
                }
            } catch (Exception e) {
                flag=false;
                error.setPhoneERROR("Phone number must be digit");
            }
            long millis=System.currentTimeMillis();
            java.sql.Date Date=new java.sql.Date(millis);
            if(flag){
                UserDTO dto=new UserDTO(userid, name, password, "EP", email, address, phone, false, Date);
                UserDAO dao=new UserDAO();
                dao.insert(dto);
                request.setAttribute("NEW_ACCOUNT", dto);
                url=SUCCESS;
                
            }else{
                request.setAttribute("ERROR", error);
            }
        } catch (Exception e) {
            log("Error at CreateController"+e.toString());
            if(e.toString().contains("duplicate")){
                error.setUserIDERROR("UserID duplicate");
                request.setAttribute("ERROR", error);
            }
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
