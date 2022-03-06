/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package Rest;

import Admin.AdminSessionBeanLocal;
import Entity.TblCast;
import Entity.TblDepartment;
import Entity.TblDistrict;
import Entity.TblFeedback;
import Entity.TblOccupation;
import Entity.TblQualification;
import Entity.TblQuestion;
import Entity.TblQuestionAnswer;
import Entity.TblQuestionType;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblUser;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author muzz
 */
@Path("admin")
public class AdminResource {

    @EJB
    AdminSessionBeanLocal asb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AdminResource
     */
    public AdminResource() {
    }

    //Department
    @GET
    @Path("findalldepartment")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblDepartment> findalldepartment() {
        return asb.findalldepartment();
    }

    @GET
    @Path("findDepartmentById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TblDepartment findDepartmentById(@PathParam("id") Integer id) {
        return asb.findDepartmentById(id);
    }

    @POST
    @Path("InsertDepartment/{deptName}/{isActive}")
    public void InsertDepartment(@PathParam("deptName") String deptName, @PathParam("isActive") String isActive) {
        asb.InsertDepartment(deptName, isActive);
    }

    @DELETE
    @Path("DeleteDepartment/{deptId}")
    public void DeleteDepartment(@PathParam("deptId") Integer deptId) {
        asb.DeleteDepartment(deptId);
    }

    @PUT
    @Path("UpdateDepartmentActive/{id}/{Active}")
    public void UpdateDepartmentActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateDepartmentActive(id, Active);
    }

    @PUT
    @Path("updateDepartment/{deptName}/{id}")
    public void updateDepartment(@PathParam("deptName") String deptName, @PathParam("id") Integer id) {
        asb.updateDepartment(deptName, id);
    }

    //State
    @GET
    @Path("findAllState")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> findAllState() {
        return asb.findAllState();
    }

    @GET
    @Path("findStateById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblState> findStateById(@PathParam("id") Integer id) {
        return asb.findStateById(id);
    }

    @POST
    @Path("InsertState/{Name}/{isActive}")
    public void InsertState(@PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertState(Name, isActive);
    }

    @DELETE
    @Path("DeleteState/{id}")
    public void DeleteState(@PathParam("id") Integer id) {
        asb.DeleteState(id);
    }

    @PUT
    @Path("UpdateStateActive/{id}/{Active}")
    public void UpdateStateActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateStateActive(id, Active);
    }

    @PUT
    @Path("updateState/{Name}/{stateid}")
    public void updateState(@PathParam("Name") String Name, @PathParam("stateid") Integer stateid) {
        asb.updateState(Name, stateid);
    }

    //District
    @GET
    @Path("findAllDistrict")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblDistrict> findAllDistrict() {
        return asb.findAllDistrict();
    }

    @GET
    @Path("findStateByDistrictId/{id}")
    public Collection<TblDistrict> findStateByDistrictId(@PathParam("id") Integer id) {
        return asb.findStateByDistrictId(id);
    }

    @POST
    @Path("InsertDistrict/{Stateid}/{Name}/{isActive}")
    public void InsertDistrict(@PathParam("Stateid") Integer Stateid, @PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertDistrict(Stateid, Name, isActive);
    }

    @DELETE
    @Path("DeleteDistrict/{Id}")
    public void DeleteDistrict(@PathParam("Id") Integer Id) {
        asb.DeleteDistrict(Id);
    }

    @PUT
    @Path("UpdateDistrictActive/{id}/{Active}")
    public void UpdateDistrictActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateDistrictActive(id, Active);
    }

    @PUT
    @Path("UpdateDistrict/{id}/{dname}/{sid}")
    public void UpdateDistrict(@PathParam("id") Integer id, @PathParam("dname") String dname, @PathParam("sid") Integer sid) {
        asb.UpdateDistrict(id, dname, sid);
    }

    //Taluka
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findAllTaluka")
    public Collection<TblTaluka> findAllTaluka() {
        return asb.findAllTaluka();
    }

    @GET
    @Path("findTalukaByDistrictId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblTaluka> findTalukaByDistrictId(@PathParam("id") Integer id) {
        return asb.findTalukaByDistrictId(id);
    }

    @GET
    @Path("findDistrictByTalukaid/{talukaid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findDistrictByTalukaid(@PathParam("talukaid") Integer talukaid) {
        return asb.findDistrictByTalukaid(talukaid);
    }

    @GET
    @Path("findStateByTalukaid/{talukaid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findStateByTalukaid(@PathParam("talukaid") Integer talukaid) {
        return asb.findStateByTalukaid(talukaid);
    }

    @GET
    @Path("findByTalukaid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblTaluka> findByTalukaid(@PathParam("id") Integer id) {
        return asb.findByTalukaid(id);
    }

    @POST
    @Path("InsertTaluka/{DistrictId}/{Name}/{isActive}")
    public void InsertTaluka(@PathParam("DistrictId") Integer DistrictId, @PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertTaluka(DistrictId, Name, isActive);
    }

    @DELETE
    @Path("DeleteTaluka/{Id}")
    public void DeleteTaluka(@PathParam("Id") Integer Id) {
        asb.DeleteTaluka(Id);
    }

    @PUT
    @Path("UpdateTalukaActive/{id}/{Active}")
    public void UpdateTalukaActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateTalukaActive(id, Active);
    }

    @PUT
    @Path("UpdateTaluka/{id}/{tname}/{districtId}")
    public void UpdateTaluka(@PathParam("id") Integer id, @PathParam("tname") String tname, @PathParam("districtId") Integer districtId) {
        asb.UpdateTaluka(id, tname, districtId);
    }

    //Village
    @GET
    @Path("findAllVillage")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblVillage> findAllVillage() {
        return asb.findAllVillage();
    }

    @GET
    @Path("findVillageById/{vid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblVillage> findVillageById(@PathParam("vid") Integer vid) {
        return asb.findVillageById(vid);
    }

    @GET
    @Path("findTalukabyVillageId/{vid}")
    public String findTalukabyVillageId(@PathParam("vid") Integer vid) {
        return asb.findTalukabyVillageId(vid);
    }

    @GET
    @Path("findDistrictbyVillage/{vid}")
    public String findDistrictbyVillage(@PathParam("vid") Integer vid) {
        return asb.findDistrictbyVillage(vid);
    }

    @GET
    @Path("findStateByVillage/{vid}")
    public String findStateByVillage(@PathParam("vid") Integer vid) {
        return asb.findStateByVillage(vid);
    }

    @POST
    @Path("InsertVillage/{Talukaid}/{Name}/{isActive}")
    public void InsertVillage(@PathParam("Talukaid") Integer Talukaid, @PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertVillage(Talukaid, Name, isActive);
    }

    @DELETE
    @Path("DeleteVillage/{Id}")
    public void DeleteVillage(@PathParam("Id") Integer Id) {
        asb.DeleteVillage(Id);
    }

    @PUT
    @Path("UpdateVillageActive/{id}/{Active}")
    public void UpdateVillageActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateVillageActive(id, Active);
    }

    @PUT
    @Path("UpdateVillage/{id}/{name}/{talukeId}")
    public void UpdateVillage(@PathParam("id") Integer id, @PathParam("name") String name, @PathParam("talukaId") Integer talukaId) {
        asb.UpdateVillage(id, name, talukaId);
    }

    @GET
    @Path("findzonename/{zid}")
    public String findzonename(@PathParam("zid") Integer zid) {
        return asb.findzonename(zid);
    }

    @GET
    @Path("findVillageByZoneid/{zid}")
    public String findVillageByZoneid(@PathParam("zid") Integer zid) {
        return asb.findVillageByZoneid(zid);
    }

    @GET
    @Path("findAllZone")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblZone> findAllZone() {
        return asb.findAllZone();
    }

    @POST
    @Path("InsertZone/{vid}/{Name}/{isActive}")
    public void InsertZone(@PathParam("vid") Integer vid, @PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertZone(vid, Name, isActive);
    }

    @DELETE
    @Path("DeleteZone/{Id}")
    public void DeleteZone(@PathParam("Id") Integer Id) {
        asb.DeleteZone(Id);
    }

    @PUT
    @Path("UpdateZone/{zoneid}/{name}/{villageid}")
    public void UpdateZone(@PathParam("zoneid") Integer zoneid, @PathParam("name") String name, @PathParam("villageid") Integer villageid) {
        asb.UpdateZone(zoneid, name, villageid);
    }

    @PUT
    @Path("UpdateZoneActive/{id}/{Active}")
    public void UpdateZoneActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateZoneActive(id, Active);
    }

    @GET
    @Path("findAllWard")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblWard> findAllWard() {
        return asb.findAllWard();
    }

    @POST
    @Path("InsertWard/{zid}/{Name}/{isActive}")
    public void InsertWard(@PathParam("zid") Integer zid, @PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertWard(zid, Name, isActive);
    }

    @DELETE
    @Path("DeleteWard/{Id}")
    public void DeleteWard(@PathParam("Id") Integer Id) {
        asb.DeleteWard(Id);
    }

    @PUT
    @Path("UpdateWard/{wardid}/{name}/{zoneid}")
    public void UpdateWard(@PathParam("wardid") Integer wardid, @PathParam("name") String name, @PathParam("zoneid") Integer zoneid) {
        asb.UpdateWard(wardid, name, zoneid);
    }

    @PUT
    @Path("UpdateWardActive/{id}/{Active}")
    public void UpdateWardActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateWardActive(id, Active);
    }

    @GET
    @Path("findAllCast")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblCast> findAllCast() {
        return asb.findAllCast();
    }

    @POST
    @Path("InsertCast/{Name}/{isActive}")
    public void InsertCast(@PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertCast(Name, isActive);
    }

    @DELETE
    @Path("DeleteCast/{Id}")
    public void DeleteCast(@PathParam("Id") Integer Id) {
        asb.DeleteCast(Id);
    }

    @PUT
    @Path("UpdateCastActive/{id}/{Active}")
    public void UpdateCastActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateCastActive(id, Active);
    }

    @PUT
    @Path("UpdateCast/{id}/{name}")
    public void UpdateCast(@PathParam("id") Integer id, @PathParam("name") String name) {
        asb.UpdateCast(id, name);
    }

    @GET
    @Path("findAllQualification")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQualification> findAllQualification() {
        return asb.findAllQualification();
    }

    @POST
    @Path("InsertQualification/{Name}/{isActive}")
    public void InsertQualification(@PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertQualification(Name, isActive);
    }

    @DELETE
    @Path("DeleteQualification/{Id}")
    public void DeleteQualification(@PathParam("Id") Integer Id) {
        asb.DeleteQualification(Id);
    }

    @PUT
    @Path("UpdateQualificationActive/{id}/{Active}")
    public void UpdateQualificationActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateQualificationActive(id, Active);
    }

    @PUT
    @Path("UpdateQualification/{id}/{name}")
    public void UpdateQualification(@PathParam("id") Integer id, @PathParam("name") String name) {
        asb.UpdateQualification(id, name);
    }

    @GET
    @Path("findAllOccupation")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblOccupation> findAllOccupation() {
        return asb.findAllOccupation();
    }

    @POST
    @Path("InsertOccupation/{Name}/{isActive}")
    public void InsertOccupation(@PathParam("Name") String Name, @PathParam("isActive") String isActive) {
        asb.InsertOccupation(Name, isActive);
    }

    @DELETE
    @Path("DeleteOccupation/{Id}")
    public void DeleteOccupation(@PathParam("Id") Integer Id) {
        asb.DeleteOccupation(Id);
    }

    @PUT
    @Path("UpdateOccupationActive/{id}/{Active}")
    public void UpdateOccupationActive(@PathParam("id") Integer id, @PathParam("Active") String Active) {
        asb.UpdateOccupationActive(id, Active);
    }

    @PUT
    @Path("UpdateOccupation/{id}/{name}")
    public void UpdateOccupation(@PathParam("id") Integer id, @PathParam("name") String name) {
        asb.UpdateOccupation(id, name);
    }

    @GET
    @Path("findAllUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblUser> findAllUser() {
        return asb.findAllUser();
    }

    @GET
    @Path("findAllQuestionType")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQuestionType> findAllQuestionType() {
        return asb.findAllQuestionType();
    }

    @POST
    @Path("InsertQuestionType/{Type}/{isActive}")
    public void InsertQuestionType(@PathParam("Type") String Type, @PathParam("isActive") String isActive) {
        asb.InsertQuestionType(Type, isActive);
    }

    @DELETE
    @Path("DeleteQuestionType/{Id}")
    public void DeleteQuestionType(@PathParam("Id") Integer Id) {
        asb.DeleteQuestionType(Id);
    }

    @PUT
    @Path("UpdateQuestionType/{Id}/{TypeName}")
    public void UpdateQuestionType(@PathParam("Id") Integer Id, @PathParam("TypeName") String TypeName) {
        asb.UpdateQuestionType(Id, TypeName);
    }

    @PUT
    @Path("UpdateQuestionTypeActive/{Id}/{Active}")
    public void UpdateQuestionTypeActive(@PathParam("Id") Integer Id, @PathParam("Active") String Active) {
        asb.UpdateQuestionTypeActive(Id, Active);
    }

    @GET
    @Path("findAllQuestion")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQuestion> findAllQuestion() {
        return asb.findAllQuestion();
    }

    @DELETE
    @Path("DeleteQuestion/{Id}")
    public void DeleteQuestion(@PathParam("Id") Integer Id) {
        asb.DeleteQuestion(Id);
    }

    @PUT
    @Path("UpdateQuestionActive/{Id}/{Active}")
    public void UpdateQuestionActive(@PathParam("Id") Integer Id, @PathParam("Active") String Active) {
        asb.UpdateQuestionActive(Id, Active);
    }

    @GET
    @Path("findallANSWER")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblQuestionAnswer> findallANSWER() {
        return asb.findallANSWER();
    }

    @DELETE
    @Path("DeleteFeed/{Id}/{n}")
    public void DeleteFeed(@PathParam("Id") Integer Id, @PathParam("n") String n) {
        asb.DeleteFeed(Id, n);
    }

//    public void InsertQuestion(TblQuestion q, int id, Collection<TblState> st, Collection<TblDistrict> dd, Collection<TblTaluka> tt, Collection<TblVillage> vv, Collection<TblZone> zz, Collection<TblWard> ww, Collection<TblCast> cast, Collection<TblOccupation> oocu, Collection<TblQualification> quali) {
//    }
    @GET
    @Path("findallFeedback")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblFeedback> findallFeedback() {
        return asb.findallFeedback();
    }

    @GET
    @Path("findByDistrictIdStateName/{districtId}")
    @Produces(MediaType.APPLICATION_JSON)
    public TblState findByDistrictIdStateName(@PathParam("districtId") Integer districtId) {
        return asb.findByDistrictIdStateName(districtId);
    }

    @GET
    @Path("findByDistrictId/{districtid}")
    public String findByDistrictId(@PathParam("districtid") Integer districtid) {
        return asb.findByDistrictId(districtid);
    }

    @GET
    @Path("findVillageByTalukaId/{talukaid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<TblVillage> findVillageByTalukaId(@PathParam("talukaid") Integer talukaid) {
        return asb.findVillageByTalukaId(talukaid);
    }

    @GET
    @Path("findZoneByVillageId/{vid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<TblZone> findZoneByVillageId(@PathParam("vid") Integer vid) {
        return asb.findZoneByVillageId(vid);
    }
}
