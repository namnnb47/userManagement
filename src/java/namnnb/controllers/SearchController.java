/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namnnb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import namnnb.daos.RoleDAO;
import namnnb.daos.UserDAO;
import namnnb.dtos.RoleDTO;
import namnnb.dtos.UserDTO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String SEARCH_PAGE = "adSearch.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String searchValue = request.getParameter("searchValue");
        String url = SEARCH_PAGE;
        String role = request.getParameter("roleId");
        
        UserDAO userDao = new UserDAO(); 
        RoleDAO roleDao = new RoleDAO();
        List<UserDTO> result = null;
        List<RoleDTO> listRole = null;

        try {
            if (searchValue == null) {          
                listRole = roleDao.getListRole();
                request.setAttribute("LISTROLE", listRole);
                
                result = userDao.searchUserByName("");
                
            } else {               
                listRole = roleDao.getListRole();
                request.setAttribute("LISTROLE", listRole);
                if (role == null) {
                    result = userDao.searchUserByName(searchValue.trim());
                } else if (role.isEmpty()) {
                    result = userDao.searchUserByName(searchValue.trim());
                } else {
                    int roleId = Integer.parseInt(role);
                    result = userDao.searchUserByNameAndRole(searchValue.trim(), roleId);
                }              
//                request.setAttribute("SEARCHRESULT", result);
            }
            request.setAttribute("SEARCHRESULT", result);

        } catch (SQLException ex) {
            log("SearchController _ SQLException" + ex.getMessage());
        } catch (NamingException ex) {
            log("SearchController _ NamingException" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
            out.close();
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
