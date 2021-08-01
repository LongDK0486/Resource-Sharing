/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CateDAO;
import DAO.RequestDAO;
import DAO.UserDAO;
import DTO.CateDTO;
import DTO.ItemDTO;
import DTO.RequestDTO;
import DTO.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRREDETOR
 */
public class HistoryController extends HttpServlet {
     private static final String Error="error.jsp";
      private static final String SUCCESS="history.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=Error;
        try {
            String userid=request.getParameter("UserID");
            RequestDAO dao=new RequestDAO();
            List<RequestDTO> list =new ArrayList<>();
            list=dao.searchHistory(userid);       
            HttpSession session = request.getSession();
            if(list!=null){
                request.setAttribute("List_History", list); 
                url=SUCCESS;
            }            
             List<ItemDTO> item=dao.getitemName();             
             session.setAttribute("Item_Name", item);
             CateDAO catedao=new CateDAO();
            List<CateDTO> cate=catedao.getCate();
            session.setAttribute("Category_Name", cate);
            UserDAO user=new UserDAO();
            List<UserDTO> list3=user.getUserName();
            session.setAttribute("user_Name", list3);
        } catch (Exception e) {
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
