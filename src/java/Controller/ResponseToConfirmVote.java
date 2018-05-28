/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Welcome
 */
public class ResponseToConfirmVote extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            UserDao dao = new UserDao();
            List<String> session = new ArrayList<String>();
            String user_response = request.getParameter("btn");
            System.out.println(user_response);
            session = dao.getSessionData();
            String ano = session.get(0);
            String cname = session.get(1);
            System.out.println(ano + " " + cname);
            int vc = 1;
            dao.castVote(ano,vc);
            
            if("yes".equalsIgnoreCase(user_response)){
                dao.updateParty(cname);
                out.println("<h1 align='center' style='color:green'>Success</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
                rd.include(request, response);
            }
            else{
                dao.castFakeVote();
                out.println("<h1 align='center' style='color:red'> Descrepency Noted</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("Final.jsp");
                rd.include(request, response);
            }
            dao.truncate();
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResponseToConfirmVote</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResponseToConfirmVote at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
