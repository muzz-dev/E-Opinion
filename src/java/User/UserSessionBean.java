/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package User;

import Entity.TblCast;
import Entity.TblDepartment;
import Entity.TblDistrict;
import Entity.TblFeedback;
import Entity.TblOccupation;
import Entity.TblQualification;
import Entity.TblQuestion;
import Entity.TblQuestionAnswer;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblUser;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import Record.KeepRecord;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author muzz
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "EOpinionPU")
    EntityManager em;

    @Override
    public Collection<TblState> findAllState() {
        return em.createNamedQuery("TblState.findAll").getResultList();
    }

    @Override
    public Collection<TblDistrict> findAllDistrict() {
        return em.createNamedQuery("TblDistrict.findAll").getResultList();
    }

    @Override
    public Collection<TblTaluka> findAllTaluka() {
        return em.createNamedQuery("TblTaluka.findAll").getResultList();
    }

    @Override
    public Collection<TblVillage> findAllVillage() {
        return em.createNamedQuery("TblVillage.findAll").getResultList();
    }

    @Override
    public Collection<TblWard> findAllWard() {
        return em.createNamedQuery("TblWard.findAll").getResultList();
    }

    @Override
    public Collection<TblZone> findAllZone() {
        return em.createNamedQuery("TblZone.findAll").getResultList();
    }

    @Override
    public Collection<TblDepartment> findAllDepartment() {
        return em.createNamedQuery("TblDepartment.findAll").getResultList();
    }

    @Override
    public Collection<TblCast> findAllCast() {
        return em.createNamedQuery("TblCast.findAll").getResultList();
    }

    @Override
    public Collection<TblOccupation> findAllOccupation() {
        return em.createNamedQuery("TblOccupation.findAll").getResultList();
    }

    @Override
    public Collection<TblQualification> findAllQualificaton() {
        return em.createNamedQuery("TblQualification.findAll").getResultList();
    }

    @Override
    public void Registration(TblUser user) {

        TblUser u = new TblUser();
        u.setUserFullName(user.getUserFullName());
        u.setUserName(user.getUserName());
        u.setMobileNumber(user.getMobileNumber());
        u.setAadharNumber(user.getAadharNumber());
        u.setAddress(user.getAddress());
        u.setCastId(user.getCastId());
        u.setEmailId(user.getEmailId());
        u.setGender(user.getGender());
        u.setPassword(user.getPassword());
        u.setReligion(user.getReligion());
        u.setWardId(user.getWardId());
        u.setIsblock("N");
        em.persist(u);
    }

//    @Override
//    public void Edit(Integer user_id, String user_full_name, String aadhar_number, String mobile_number, String email_id, Integer qualification_id, Integer occupation_id, Integer state_id, Integer district_id, Integer taluka_id, Integer village_id, Integer zone_id, Integer ward_id, Integer cast_id, String religion, String address, String gender) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public Collection<TblQuestion> findAllQuestion() {
        Collection<TblQuestion> que = em.createNamedQuery("TblQuestion.findAll").getResultList();
        Integer id = parseInt(KeepRecord.userId);
        Collection<TblQuestion> result = new ArrayList();
        for (TblQuestion ques : que) {
//            System.out.println(ques.getQuestionId());
            Integer count = em.createNamedQuery("TblQuestionAnswer.findByUserAndQuestionId").setParameter("userId",id).setParameter("questionId", ques.getQuestionId()).getResultList().size();
            if (count == 0) {
                result.add(ques);
            }
//            System.out.println(count);
        }
        return result;
    }

    @Override
    public Collection<TblQuestion> findQuestionById(Integer id) {
        return em.createNamedQuery("TblQuestion.findByQuestionId").setParameter("questionId", id).getResultList();
    }

    @Override
    public void Answer(Integer qid, Integer uid, String option) {
        TblQuestionAnswer answer = new TblQuestionAnswer();
        TblQuestion queid = em.find(TblQuestion.class, qid);
        TblUser user = em.find(TblUser.class, uid);
        answer.setQueId(queid);
        answer.setUserId(user);
        if (option.contains("A")) {
            answer.setOptionA("1");
        } else {
            answer.setOptionA("0");
        }

        if (option.contains("B")) {
            answer.setOptionB("1");
        } else {
            answer.setOptionB("0");
        }

        if (option.contains("C")) {
            answer.setOptionC("1");
        } else {
            answer.setOptionC("0");
        }

        if (option.contains("D")) {
            answer.setOptionD("1");
        } else {
            answer.setOptionD("0");
        }
        em.persist(answer);
    }

    @Override
    public Collection<TblFeedback> findAllFeedback() {
        return em.createNamedQuery("TblFeedback.findAll").getResultList();
    }

    @Override
    public void AddFeedback(TblFeedback feedback) {
        TblFeedback feed = new TblFeedback();
        feed.setDescription(feedback.getDescription());
        feed.setEmailId(feedback.getEmailId());
        feed.setIsactive(feedback.getIsactive());
        feed.setUserName(feedback.getUserName());
        feed.setDate(feedback.getDate());
        em.persist(feed);
    }

}
