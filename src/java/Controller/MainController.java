/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRREDETOR
 */
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String Search = "SearchController";
    private static final String Booking = "BookingitemController";
    private static final String Create = "CreateController";
    private static final String SearchREQ = "SearchrequestController";
    private static final String Approve = "ApproveController";
    private static final String Reject = "RejectController";
    private static final String Delete = "DeleteController";
    private static final String History = "HistoryController";
    private static final String SearchHistory = "SearchHistoryController";
    private static final String Verify = "VerifyaccountController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        try {
            String action=request.getParameter("action");
            if("Login".equals(action)){
                url=LOGIN;
            }else if("Logout".equals(action)){
                url=LOGOUT;
            }else if("Search".equals(action)){
                url=Search;
            }else if("Booking".equals(action)){
                url=Booking;
            }else if("Create".equals(action)){
                url=Create;
            }else if("SearchRequest".equals(action)){
                url=SearchREQ;
            }else if("Approve".equals(action)){
                url=Approve;
            }else if("Reject".equals(action)){
                url=Reject;
            }else if("History".equals(action)){
                url=History;
            } else if ("Delete".equals(action)) {
                url = Delete;
            }else if("Verify".equals(action)){
                url=Verify;
            }else if("SearchDay".equals(action)){
                url=SearchHistory;
            }

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
