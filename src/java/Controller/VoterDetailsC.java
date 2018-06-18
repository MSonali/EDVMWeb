/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.UserDao;
import Model.FingerPrint;
import Model.VotingProcess;
//import static Model.VotingProcess.ano;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Welcome
 */
public class VoterDetailsC extends HttpServlet {

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
            HttpSession hs = request.getSession();
            //Get Finger Print Data from Hardware
            FingerPrint fn = new FingerPrint();
            String fp = fn.getFingerPrint();
            System.out.println("Got fp...");
            UserDao dao = new UserDao();
            System.out.println("userfp "+fp);
            String ano = dao.getAno(fp);
            dao.addSessionAno(ano);
            System.out.println(ano);
            
            int age = VotingProcess.getAge(ano);
            String constituency = dao.getConstituencyDetails(ano);
            boolean isVoted = dao.isVotingDone(ano);
            
            if(age>=18&&!(isVoted)){
                request.setAttribute("ano", ano);
                request.setAttribute("const", constituency);
                RequestDispatcher rd = request.getRequestDispatcher("VoterDetails.jsp");
                rd.include(request, response);
            }
            else{
                out.println("<h1 align='center' style='color:red'>Under Age or Already Voted</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("end.jsp");
                rd.include(request, response);
            }
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VoterDetailsC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VoterDetailsC at " + request.getContextPath() + "</h1>");
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
