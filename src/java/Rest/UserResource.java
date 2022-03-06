/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import Entity.TblCast;
import Entity.TblDepartment;
import Entity.TblDistrict;
import Entity.TblFeedback;
import Entity.TblOccupation;
import Entity.TblQualification;
import Entity.TblQuestion;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblUser;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import User.UserSessionBeanLocal;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Shaikh Maryam
 */
@Path("User")
public class UserResource {
    
    @EJB UserSessionBeanLocal usb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    @GET
    @Path("findAllState")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> findAllState() {
       return usb.findAllState();
    }

    @GET
    @Path("findAllDistrict")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<TblDistrict> findAllDistrict() {
        return usb.findAllDistrict();
    }

    @GET
    @Path("findAllTaluka")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblTaluka> findAllTaluka() {
        return usb.findAllTaluka();
    }

    @GET
    @Path("findAllVillage")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblVillage> findAllVillage() {
        return usb.findAllVillage();
    }

    @GET
    @Path("findAllWard")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblWard> findAllWard() {
        return usb.findAllWard();
    }

    @GET
    @Path("findAllZone")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblZone> findAllZone() {
       return usb.findAllZone();
    }

    @GET
    @Path("findAllDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblDepartment> findAllDepartment() {
       return usb.findAllDepartment();
    }

    @GET
    @Path("findAllCast")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCast> findAllCast() {
       return usb.findAllCast();
    }

    @GET
    @Path("findAllOccupation")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOccupation> findAllOccupation() {
        return usb.findAllOccupation();
    }

    @GET
    @Path("findAllQualification")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQualification> findAllQualificaton() {
       return usb.findAllQualificaton();
    }

    @POST
    @Path("Registration")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void Registration(@PathParam("Registration") TblUser user) {
       usb.Registration(user);
    }

    @GET
    @Path("FindAllQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQuestion> findAllQuestion() {
       return usb.findAllQuestion();
    }

    @GET
    @Path("findQuestionbyId/{queid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQuestion> findQuestionById(@PathParam("queid") Integer id) {
        return usb.findQuestionById(id);
    }

    @POST
    @Path("Answer/{queid}/{userid}/{option}")
    public void Answer(@PathParam("queid") Integer qid, @PathParam("userid") Integer uid, @PathParam("option")String option) {
        usb.Answer(qid, uid, option);
    }

    @GET
    @Path("findAllFeedback")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> findAllFeedback() {
       return usb.findAllFeedback();
    }

    @POST
    @Path("AddFeedback/{feedback}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void AddFeedback(@PathParam("feedback") TblFeedback feedback) {
      usb.AddFeedback(feedback);
    }
}
