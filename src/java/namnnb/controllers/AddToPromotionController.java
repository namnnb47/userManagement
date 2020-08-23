/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namnnb.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import namnnb.promotion.PromotionObj;
import namnnb.promotion.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AddToPromotionController", urlPatterns = {"/AddToPromotionController"})
public class AddToPromotionController extends HttpServlet {

    private static final String DISPATCH_CONTROLLER = "DispatchController";

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
        
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        String role = request.getParameter("roleId");
        String searchValue = request.getParameter("searchValue");
        String urlRewriting = "DispatchController?btAction=Search&searchValue="
                + searchValue + "&roleId=" + role;
        try {

            HttpSession session = request.getSession();
            //2. kh lay xe
            PromotionObj promotion = (PromotionObj) session.getAttribute("PROMOTION");
            if (promotion == null) {
                promotion = new PromotionObj();
            }
            //3. lay hang
            User user = new User(userName, fullName, 5);

            if (promotion.isUserOnList(user)) {

                request.setAttribute("ADDERROR", "User had already added in promotion list !");
            } else {

                promotion.addUserToPromotionList(user);

            }

            //5. di mua tiep
            session.setAttribute("PROMOTION", promotion);

        } finally {
            request.getRequestDispatcher(urlRewriting).forward(request, response);
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
