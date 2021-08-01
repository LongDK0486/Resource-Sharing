/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ItemDAO;
import DTO.ItemDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRREDETOR
 */
public class SearchController extends HttpServlet {
    private final static String ERROR="bookingpge.jsp";
    private final static String SUCCESS="bookingpge.jsp";

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR;
        int count=0;
        try {                     
            String search=request.getParameter("Search");
            String searchcate=request.getParameter("SearchCate");
            String searchday=request.getParameter("Searchday");
            searchday="";
            ItemDAO dao=new ItemDAO();
            List<ItemDTO> list=new ArrayList<>();
            String index=request.getParameter("index");
            if(index == null ){
                index = "1";
            }
           if(searchcate==null){
               searchcate="0";
           }
            if(searchday.isEmpty()||searchday.equals("")){
                list= dao.Search2(search, searchcate,Integer.parseInt(index));
                  searchday="1";
            }else{
                list=dao.Search3(search, searchcate, Integer.parseInt(searchday),Integer.parseInt(index));               
            }          
                 count=dao.count(search, Integer.parseInt(searchday));
            if(list!=null){
                int endPage = count / 2;
                if (endPage % 2 != 0) {
                    endPage++;                   
                }
                request.setAttribute("END_PAGE", endPage);
                request.setAttribute("List_Item", list);                
                url=SUCCESS;
            }        
        } catch (Exception e) {
            log("Error at search page"+e.toString());
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
