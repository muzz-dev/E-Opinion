/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Admin;

import Entity.*;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Local;

/**
 *
 * @author muzz
 */
@Local
public interface AdminSessionBeanLocal {

    //Department
    Collection<TblDepartment> findalldepartment();

    TblDepartment findDepartmentById(Integer id);

    public void InsertDepartment(String deptName, String isActive);

    public void DeleteDepartment(Integer deptId);

    public void UpdateDepartmentActive(Integer id, String Active);

    public void updateDepartment(String deptName, Integer id);

    //State
    Collection<TblState> findAllState();

    Collection<TblState> findStateById(Integer id);

    public void InsertState(String Name, String isActive);

    public void DeleteState(Integer id);

    public void UpdateStateActive(Integer id, String Active);

    public void updateState(String Name, Integer stateid);

    //District
    Collection<TblDistrict> findAllDistrict();

    public Collection<TblDistrict> findStateByDistrictId(Integer id);

    public void InsertDistrict(Integer Stateid, String Name, String isActive);

    public void DeleteDistrict(Integer Id);

    public void UpdateDistrictActive(Integer id, String Active);

    public void UpdateDistrict(Integer id, String dname, Integer sid);

    //Takula
    Collection<TblTaluka> findAllTaluka();

    public Collection<TblTaluka> findTalukaByDistrictId(Integer id);

    public String findDistrictByTalukaid(Integer talukaid);

    public String findStateByTalukaid(Integer talukaid);

    public Collection<TblTaluka> findByTalukaid(Integer id);

    public void InsertTaluka(Integer DistrictId, String Name, String isActive);

    public void DeleteTaluka(Integer Id);

    public void UpdateTalukaActive(Integer id, String Active);

    public void UpdateTaluka(Integer id, String tname, Integer districtId);

    //Village
    public Collection<TblVillage> findAllVillage();

    public Collection<TblVillage> findVillageById(Integer vid);

    public String findTalukabyVillageId(Integer vid);

    public String findDistrictbyVillage(Integer vid);

    public String findStateByVillage(Integer vid);

    public void InsertVillage(Integer Talukaid, String Name, String isActive);

    public void DeleteVillage(Integer Id);

    public void UpdateVillageActive(Integer id, String Active);

    public void UpdateVillage(Integer id, String name, Integer talukaId);

    //Zone
    public String findzonename(Integer zid);

    public String findVillageByZoneid(Integer zid);

    Collection<TblZone> findAllZone();

    public void InsertZone(Integer vid, String Name, String isActive);

    public void DeleteZone(Integer Id);

    public void UpdateZone(Integer zoneid, String name, Integer villageid);

    public void UpdateZoneActive(Integer id, String Active);

    //Ward
    Collection<TblWard> findAllWard();

    public void InsertWard(Integer zid, String Name, String isActive);

    public void DeleteWard(Integer Id);

    public void UpdateWard(Integer wardid, String name, Integer zoneid);

    public void UpdateWardActive(Integer id, String Active);

    //Cast
    Collection<TblCast> findAllCast();

    public void InsertCast(String Name, String isActive);

    public void DeleteCast(Integer Id);

    public void UpdateCastActive(Integer id, String Active);

    public void UpdateCast(Integer id, String name);

    //Qualification
    Collection<TblQualification> findAllQualification();

    public void InsertQualification(String Name, String isActive);

    public void DeleteQualification(Integer Id);

    public void UpdateQualificationActive(Integer id, String Active);

    public void UpdateQualification(Integer id, String name);

    //Occupation
    Collection<TblOccupation> findAllOccupation();

    public void InsertOccupation(String Name, String isActive);

    public void DeleteOccupation(Integer Id);

    public void UpdateOccupationActive(Integer id, String Active);

    public void UpdateOccupation(Integer id, String name);

    //User
    Collection<TblUser> findAllUser();

    //QuetionType
    Collection<TblQuestionType> findAllQuestionType();

    public void InsertQuestionType(String Type, String isActive);

    public void DeleteQuestionType(Integer Id);

    public void UpdateQuestionType(Integer Id, String TypeName);

    public void UpdateQuestionTypeActive(Integer Id, String Active);

    //Question
    Collection<TblQuestion> findAllQuestion();

    public void UpdateQuestionActive(Integer Id, String Active);

    public void InsertQuestion(
            TblQuestion question,
            Collection<Integer> st,
            Collection<Integer> ds,
            Collection<Integer> tt,
            Collection<Integer> vv,
            Collection<Integer> zz,
            Collection<Integer> ww,
            Collection<Integer> cast,
            Collection<Integer> occu,
            Collection<Integer> quali
    );

    public void DeleteQuestion(Integer Id);

    //Answer
    public Collection<TblQuestionAnswer> findallANSWER();

    //Feedback
    Collection<TblFeedback> findallFeedback();

    public void DeleteFeed(Integer Id, String n);

    //Add new by me
    public TblState findByDistrictIdStateName(Integer districtId);
    
    public String findByDistrictId(Integer districtid);

    public Collection<TblVillage> findVillageByTalukaId(Integer talukaid);

    public Collection<TblZone> findZoneByVillageId(Integer vid);

    public Collection<TblWard> findwardByZoneId(Integer zid);
    
    public Integer getUserCounts();
    
    public Integer getQuestionCounts();
    
    public Integer getResponseCounts();
    
    public Integer getResonseByQuestionId(Integer Id);
    
    //Added By Muzz
    public Integer getStateCounts();

    public HashMap<String, Integer> getCountsByIssue(Integer typeId);

    public HashMap<String, Integer> getCountsByIssueState(Integer typeId, Integer stateId);
    
    public HashMap<String, Integer> getCountsByIssueDistrict(Integer typeId, Integer distId);
    
    public HashMap<String, Integer> getCountsByIssueTaluka(Integer typeId, Integer talukaId);
    
    public HashMap<String, Integer> getCountsByIssueVillage(Integer typeId, Integer villageId);
    
    public HashMap<String, Integer> getCountsByIssueZone(Integer typeId, Integer zoneId);
    
    public String getUserIdfromUsername(String username);
}
