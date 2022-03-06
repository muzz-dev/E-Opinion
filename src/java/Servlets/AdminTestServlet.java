/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblQuestion;
import Entity.TblQuestionType;
import Entity.TblTaluka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author HP
 */
@WebServlet(name = "AdminTestServlet", urlPatterns = {"/AdminTestServlet"})
public class AdminTestServlet extends HttpServlet {

    @EJB
    AdminSessionBeanLocal asb;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminTestServlet</title>");
            out.println("</head>");
            out.println("<body>");
//            asb.getResonseByQuestionId(2);
//            asb.updateState("Andhra Pradesh1",2);
//            asb.UpdateVillage(4, "Dhoraji", 1);
//            asb.updateState("Andaman Nicobar", 2);
//            Collection<Integer> st= new ArrayList();
//            Collection<Integer> ds= new ArrayList();
//            Collection<Integer> tt= new ArrayList();
//            Collection<Integer> vv= new ArrayList();
//            Collection<Integer> zz= new ArrayList();
//            Collection<Integer> ww= new ArrayList();
//            Collection<Integer> cast= new ArrayList();
//            Collection<Integer> occu= new ArrayList();
//            Collection<Integer> quali= new ArrayList();
//            
//            
//            TblQuestion question = new TblQuestion();
//            TblQuestionType ques = new TblQuestionType();
//            ques.setQuestionTypeId(3);
//            question.setQuestionTypeId(ques);
//            question.setTitle("Hello World");
//            question.setDescription("Desc");
//            question.setState("All");
//            question.setDistrict("Selected");
//            question.setTaluka("All");
//            question.setVillage("All");
//            question.setZone("All");
//            question.setWard("All");
//            question.setCast("Selected");
//            question.setQualification("Selected");
//            question.setOccupation("Selected");
//            question.setOptionA("Option A");
//            question.setOptionB("Option B");
//            question.setOptionC("Option C");
//            question.setOptionD("Option D");
//            question.setDate("15/01/2021");
//            question.setIsActive("Y");
//            asb.InsertQuestion(question, st, ds, tt, vv, zz, ww, cast, occu, quali);

//            asb.DeleteZone(11);
            System.out.println(asb.getResonseByQuestionId(2));

            out.println("<h1>Servlet AdminTestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        AdminClient client = new AdminClient();
        Response res;
        Collection<TblTaluka> talukas;
        GenericType<Collection<TblTaluka>> gtalukas = new GenericType<Collection<TblTaluka>>() {
        };
        res = client.findByTalukaid(Response.class, "4");
        talukas = res.readEntity(gtalukas);
        for (TblTaluka taluka : talukas) {
            System.out.println(taluka.getTalukaName());
        }
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
