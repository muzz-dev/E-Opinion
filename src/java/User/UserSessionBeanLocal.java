/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package User;

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
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author muzz
 */
@Local
public interface UserSessionBeanLocal {
    
    Collection<TblState>findAllState();
    Collection<TblDistrict>findAllDistrict();
    Collection<TblTaluka>findAllTaluka();
    Collection<TblVillage>findAllVillage();
    Collection<TblWard>findAllWard();
    Collection<TblZone>findAllZone();
    Collection<TblDepartment>findAllDepartment();
    Collection<TblCast>findAllCast();
    Collection<TblOccupation>findAllOccupation();
    Collection<TblQualification>findAllQualificaton();
    
    public void Registration(TblUser user);
//    public void Edit(Integer user_id, String user_full_name, String aadhar_number, String mobile_number, 
//            String email_id,Integer qualification_id, Integer occupation_id, Integer state_id , 
//            Integer district_id ,Integer taluka_id ,Integer village_id,Integer zone_id , 
//            Integer ward_id ,Integer cast_id ,String religion, String address,String gender);
  
    //Question
    Collection<TblQuestion>findAllQuestion();
    Collection<TblQuestion>findQuestionById(Integer id);
    
    //Answer
    public void Answer(Integer qid, Integer uid, String option);
    
    //Feedback
    Collection<TblFeedback>findAllFeedback();
    public void AddFeedback(TblFeedback feedback);
    
}
