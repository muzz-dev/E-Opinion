/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Entity.TblCast;
import Entity.TblDistrict;
import Entity.TblFeedback;
import Entity.TblGroup;
import Entity.TblOccupation;
import Entity.TblQualification;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblUser;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import User.UserSessionBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "UserTestServlet", urlPatterns = {"/UserTestServlet"})
public class UserTestServlet extends HttpServlet {
 @EJB UserSessionBeanLocal usb;
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
            out.println("<title>Servlet UserTestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //              Answer
//            usb.Answer(1, 12, "D");

           //Feedback
            DateFormat df = new SimpleDateFormat("DD-MM-YYYY");
            Date today = Calendar.getInstance().getTime();
            String RegiDate = df.format(today);
            
            TblFeedback feedback = new TblFeedback();
            feedback.setEmailId("anas@gmail.com");
            feedback.setDescription("good");
            feedback.setIsactive("Y");
            feedback.setUserName("anas");
            feedback.setDate(RegiDate);
          usb.AddFeedback(feedback);
            
             //Registration
            TblUser user=new TblUser();
            
            TblGroup group = new TblGroup();
            TblCast cast=new TblCast();
            TblOccupation occupation=new TblOccupation();
            TblDistrict district=new TblDistrict();
            TblQualification qualification = new TblQualification();
            TblTaluka taluka=new TblTaluka();
            TblState state=new TblState();
            TblVillage village = new TblVillage();
            TblWard ward= new TblWard();
            TblZone zone=new TblZone();
            
            cast.setCastId(2);
            district.setDistrictId(12);
            occupation.setOccupationId(5);
            qualification.setQualificationId(6);
            taluka.setTalukaId(11);
            village.setVillageId(3);
            ward.setWardId(1);
            zone.setZoneId(1);
            state.setStateId(7);
            group.setGroupId(2);
            
            user.setUserId(11);
            user.setUserName("aman");
            user.setPassword("aman123");
            user.setUserFullName("aman shah");
            user.setAadharNumber("43256710");
            user.setMobileNumber("6532581004");
            user.setEmailId("aman@gmail.com");
            user.setAddress("Jahangirpura");
            user.setGender("Male");
            user.setReligion("hindu");
            user.setWardId(ward);
            user.setCastId(cast);
            user.setIsblock("N");
//            usb.Registration(user);
            out.println("<h1>State =  " + usb.findAllState() + "  </h1>");
            out.println("<h1>District =  " + usb.findAllDistrict() + " </h1>");
            out.println("<h1>Taluka =  " + usb.findAllTaluka()+ " </h1>");
            out.println("<h1>Village =  " + usb.findAllVillage()+ " </h1>");
            out.println("<h1>Ward =  " + usb.findAllWard()+ " </h1>");
            out.println("<h1>Zone =  " + usb.findAllZone()+ " </h1>");
            out.println("<h1>Department =  " + usb.findAllDepartment()+ " </h1>");
            out.println("<h1>Cast =  " + usb.findAllCast()+ " </h1>");
            out.println("<h1>Occupation =  " + usb.findAllOccupation()+ " </h1>");
            out.println("<h1>Qualification =  " + usb.findAllQualificaton()+ " </h1>");
            out.println("<h1>Question =  " + usb.findAllQuestion()+ " </h1>");
            out.println("<h1>Question By ID 1 =  " + usb.findQuestionById(1)+ " </h1>");
            out.println("<h1>Feedback =  " + usb.findAllFeedback()+ " </h1>");
            
            out.println("<h1>Servlet UserTestServlet at " + request.getContextPath() + "</h1>");
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
