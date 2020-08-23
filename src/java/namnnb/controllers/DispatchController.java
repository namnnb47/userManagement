/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namnnb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DispatchController", urlPatterns = {"/DispatchController"})
public class DispatchController extends HttpServlet {
    
    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String SEARCH_CONTROLLER = "SearchController";
    private final String DELETE_CONTROLLER = "DeleteController";
    private final String PREPARE_UPDATE_CONTROLLER = "PreUpdateController";
    private final String UPDATE_CONTROLLER = "UpdateController";
    private final String PRE_INSERT_CONTROLLER = "PreInsertController";
    private final String INSERT_CONTROLLER = "InsertController";
    private final String ADD_CONTROLLER = "AddToPromotionController";
    private final String REMOVE_CONTROLLER = "RemovePromtionController";
    private final String UPDATE_PROMOTION_CONTROLLER = "UpdatePromotionController";
    private final String CONFIRM_CONTROLLER = "ConfirmController";
    private final String VIEW_HISTORY_CONTROLLER = "ViewHistoryController";

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
        
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {
            
            if (button == null) {
                
            } else if (button.equals("Login")) {
                url = LOGIN_CONTROLLER;
            } else if (button.equals("Logout")) {
                url = LOGOUT_CONTROLLER;
            } else if (button.equals("Search")) {
                url = SEARCH_CONTROLLER;
            } else if (button.equals("Delete")) {
                url = DELETE_CONTROLLER;
            } else if (button.equals("Update")) {
                url = PREPARE_UPDATE_CONTROLLER;
            } else if (button.equals("Update Information")) {
                url = UPDATE_CONTROLLER;
            } else if (button.equals("Insert")) {
                url = PRE_INSERT_CONTROLLER;
            } else if (button.equals("Create Account")) {
                url = INSERT_CONTROLLER;
            } else if (button.equals("Cancel")) {
                url = SEARCH_CONTROLLER;
            } else if (button.equals("Add To Promotion List")) {
                url = ADD_CONTROLLER;
            } else if (button.equals("Remove")) {
                url = REMOVE_CONTROLLER;
            } else if (button.equals("Update Rank")) {
                url = UPDATE_PROMOTION_CONTROLLER;
            } else if (button.equals("Confirm")) {
                url = CONFIRM_CONTROLLER;
            } else if (button.equals("History")) {
                url = VIEW_HISTORY_CONTROLLER;
            }        
        } finally {
//           request.getRequestDispatcher(url).forward(request, response);
            response.sendRedirect(url);
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
