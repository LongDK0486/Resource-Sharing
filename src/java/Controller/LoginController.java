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
import Google.GooglePojo;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PRREDETOR
 */
@WebServlet("/login-google")
public class LoginController extends HttpServlet {
    private static final String ERROR="Login.jsp";
    private static final String SUCCESS1="bookingpge.jsp";
    private static final String SUCCESS2="Manager.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String code = request.getParameter("code");
        try {
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            UserDAO dao = new UserDAO();
            UserDTO user = dao.login(userID, password);           
            HttpSession session = request.getSession();
           
            if (!(code == null || code.isEmpty())) {
                String accessToken = UserDAO.getToken(code);
                GooglePojo googlePojo = UserDAO.getUserInfo(accessToken);
                UserDTO googleuser =dao.logingoogle(googlePojo.getEmail());
                if(dao.logingoogle(googlePojo.getEmail())!=null){
                    session.setAttribute("LOGIN_USER", googleuser); 
                    session.setAttribute("History", googleuser.getUserid());
                    url=SUCCESS1;
                }else{
                    url=ERROR;
                }                         
            } else if (user != null) {
                session.setAttribute("LOGIN_USER", user);     
                 session.setAttribute("History", userID);
                String captcha = request.getParameter("g-recaptcha-response");
                if (!(captcha == null || captcha.length() == 0)) {
                    if ("EP".equals(user.getRoleID())) {
                        url = SUCCESS1;
                    } else if ("MN".equals(user.getRoleID())) {
                        RequestDAO req=new RequestDAO();
                        List<RequestDTO> list =req.getREQ();
                        if(list !=null){
                            request.setAttribute("List_Request", list);
                            url=SUCCESS2;
                        }                       
                         List<ItemDTO> list2=req.getitemName();
                        session.setAttribute("Item_name", list2);
                        List<UserDTO> list3=dao.getUserName();
                        session.setAttribute("User_Name", list3);
        
                    }
                }
            }
            CateDAO catedao=new CateDAO();
            List<CateDTO> cate=catedao.getCate();
            session.setAttribute("Category", cate);
        } catch (Exception e) {
            log("Error at login" + e.toString());
        } finally {
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
