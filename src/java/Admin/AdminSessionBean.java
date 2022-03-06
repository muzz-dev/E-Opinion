/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Admin;

import Entity.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author muzz
 */
@Stateless
public class AdminSessionBean implements AdminSessionBeanLocal {

    @PersistenceContext(unitName = "EOpinionPU")
    EntityManager em;
    String gettinguserId;
    //Department
    @Override
    public Collection<TblDepartment> findalldepartment() {
        return em.createNamedQuery("TblDepartment.findAll").getResultList();
    }

    @Override
    public TblDepartment findDepartmentById(Integer id) {
        return em.find(TblDepartment.class, id);
    }

    @Override
    public void InsertDepartment(String deptName, String isActive) {
        TblDepartment dept = new TblDepartment();
        dept.setDeptName(deptName);
        dept.setIsactive("Y");
        em.persist(dept);
    }

    @Override
    public void DeleteDepartment(Integer deptId) {
        TblDepartment dept = em.find(TblDepartment.class, deptId);
        em.remove(dept);
    }

    @Override
    public void UpdateDepartmentActive(Integer id, String Active) {
        TblDepartment dept = em.find(TblDepartment.class, id);
        dept.setIsactive(Active);
        em.merge(dept);
    }

    @Override
    public void updateDepartment(String deptName, Integer id) {
        TblDepartment dept = em.find(TblDepartment.class, id);
        dept.setDeptName(deptName);
        em.merge(dept);
    }

    //State
    @Override
    public Collection<TblState> findAllState() {
        return em.createNamedQuery("TblState.findAll").getResultList();
    }

    @Override
    public Collection<TblState> findStateById(Integer id) {
        return em.createNamedQuery("TblState.findByStateId").setParameter("stateId", id).getResultList();
    }

    @Override
    public void InsertState(String Name, String isActive) {
        TblState state = new TblState();
        state.setStateName(Name);
        state.setIsactive(isActive);
        em.persist(state);
    }

    @Override
    public void DeleteState(Integer id) {
        TblState state = em.find(TblState.class, id);
        em.remove(state);
    }

    @Override
    public void UpdateStateActive(Integer id, String Active) {
        TblState state = em.find(TblState.class, id);
        state.setIsactive(Active);
        em.merge(state);
    }

    @Override
    public void updateState(String Name, Integer stateid) {
        TblState state = em.find(TblState.class, stateid);
        state.setStateName(Name);
        em.merge(state);
    }

    //District
    @Override
    public Collection<TblDistrict> findAllDistrict() {
        return em.createNamedQuery("TblDistrict.findAll").getResultList();
    }

    @Override
    public Collection<TblDistrict> findStateByDistrictId(Integer id) {
        TblState state = em.find(TblState.class, id);
        return em.createNamedQuery("TblDistrict.findByStateId").setParameter("stateId", state).getResultList();
//        TblDistrict dist = em.find(TblDistrict.class, id);
//        return dist.getStateId().getStateName();

    }

    @Override
    public void InsertDistrict(Integer Stateid, String Name, String isActive) {
        //Declare Foreign Table's Object
        TblState state = em.find(TblState.class, Stateid);
        //Create Collection of Current Table and get Collection from Foreign Table.
        Collection<TblDistrict> districts = state.getTblDistrictCollection();

        TblDistrict dist = new TblDistrict();
        dist.setDistrictName(Name);
        dist.setStateId(state);
        dist.setIsactive("Y");

        //Add Latest Record into the Collection
        districts.add(dist);
        //Set Collection to update the Value
        state.setTblDistrictCollection(districts);
        //Save values to the Database
        em.persist(dist);
        //Update value of Old Collection
        em.merge(state);
    }

    @Override
    public void DeleteDistrict(Integer Id) {
        TblDistrict dis = em.find(TblDistrict.class, Id);
        em.remove(dis);
    }

    @Override
    public void UpdateDistrictActive(Integer id, String Active) {
        TblDistrict dist = em.find(TblDistrict.class, id);
        dist.setIsactive(Active);
        em.persist(dist);
        em.merge(dist);
    }

    @Override
    public void UpdateDistrict(Integer id, String dname, Integer sid) {
        TblDistrict dist = em.find(TblDistrict.class, id);
        TblState state = em.find(TblState.class, sid);
        dist.setDistrictName(dname);
        dist.setStateId(state);
        em.persist(dist);
        em.merge(dist);
    }

    //Taluka
    @Override
    public Collection<TblTaluka> findAllTaluka() {
        return em.createNamedQuery("TblTaluka.findAll").getResultList();
    }

    @Override
    public Collection<TblTaluka> findTalukaByDistrictId(Integer id) {
        TblDistrict district = em.find(TblDistrict.class, id);
        return em.createNamedQuery("TblTaluka.findByDistrictId").setParameter("districtId", district).getResultList();
    }

    @Override
    public String findDistrictByTalukaid(Integer talukaid) {
        TblTaluka tal = em.find(TblTaluka.class, talukaid);
        return tal.getDistrictId().getDistrictName();
    }

    @Override
    public String findStateByTalukaid(Integer talukaid) {
        TblTaluka tal = em.find(TblTaluka.class, talukaid);
        return tal.getDistrictId().getStateId().getStateName();
    }

    @Override
    public Collection<TblTaluka> findByTalukaid(Integer id) {
        TblTaluka taluka = em.find(TblTaluka.class, id);
        return em.createNamedQuery("TblTaluka.findByTalukaId").setParameter("talukaId", taluka).getResultList();
    }

    @Override
    public void InsertTaluka(Integer DistrictId, String Name, String isActive) {
        TblDistrict dist = em.find(TblDistrict.class, DistrictId);
        Collection<TblTaluka> talukas = dist.getTblTalukaCollection();

        TblTaluka tal = new TblTaluka();
        tal.setDistrictId(dist);
        tal.setTalukaName(Name);
        tal.setIsactive("Y");

        talukas.add(tal);
        dist.setTblTalukaCollection(talukas);

        em.persist(tal);
        em.merge(dist);
    }

    @Override
    public void DeleteTaluka(Integer Id) {
        TblTaluka tal = em.find(TblTaluka.class, Id);
        em.remove(tal);
    }

    @Override
    public void UpdateTalukaActive(Integer id, String Active) {
        TblTaluka tal = em.find(TblTaluka.class, id);
        tal.setIsactive(Active);
        em.persist(tal);
        em.merge(tal);
    }

    @Override
    public void UpdateTaluka(Integer id, String tname, Integer districtId) {
        TblTaluka tal = em.find(TblTaluka.class, id);
        TblDistrict dist = em.find(TblDistrict.class, districtId);
        tal.setTalukaName(tname);
        tal.setDistrictId(dist);
        em.persist(tal);
        em.merge(tal);
    }

    //Village
    @Override
    public Collection<TblVillage> findAllVillage() {
        return em.createNamedQuery("TblVillage.findAll").getResultList();
    }

    @Override
    public Collection<TblVillage> findVillageById(Integer vid) {
//        return em.find(TblVillage.class, vid).getVillageName();
        return em.createNamedQuery("TblVillage.findByVillageId").setParameter("villageId", vid).getResultList();
    }

    @Override
    public String findTalukabyVillageId(Integer vid) {
        return em.find(TblVillage.class, vid).getTalukaId().getTalukaName();
    }

    @Override
    public String findDistrictbyVillage(Integer vid) {
        return em.find(TblVillage.class, vid).getTalukaId().getDistrictId().getDistrictName();
    }

    @Override
    public String findStateByVillage(Integer vid) {
        return em.find(TblVillage.class, vid).getTalukaId().getDistrictId().getStateId().getStateName();
    }

    @Override
    public void InsertVillage(Integer Talukaid, String Name, String isActive) {

        TblTaluka tal = em.find(TblTaluka.class, Talukaid);
        Collection<TblVillage> villages = tal.getTblVillageCollection();

        TblVillage vil = new TblVillage();
        vil.setVillageName(Name);
        vil.setTalukaId(tal);
        vil.setIsactive("Y");

        villages.add(vil);
        tal.setTblVillageCollection(villages);

        em.persist(vil);
        em.merge(tal);
    }

    @Override
    public void DeleteVillage(Integer Id) {
        TblVillage vil = em.find(TblVillage.class, Id);
        em.remove(vil);
    }

    @Override
    public void UpdateVillageActive(Integer id, String Active) {
        TblVillage vil = em.find(TblVillage.class, id);
        vil.setIsactive(Active);
        em.persist(vil);
        em.merge(vil);
    }

    @Override
    public void UpdateVillage(Integer id, String name, Integer talukaId) {
        TblVillage vil = em.find(TblVillage.class, id);
        TblTaluka tal = em.find(TblTaluka.class, talukaId);
        vil.setVillageName(name);
        vil.setTalukaId(tal);
        em.persist(vil);
        em.merge(vil);
    }

    @Override
    public String findzonename(Integer zid) {
        TblZone zone = em.find(TblZone.class, zid);
        return zone.getZoneName();
    }

    @Override
    public String findVillageByZoneid(Integer zid) {
        return em.find(TblZone.class, zid).getVillageId().getVillageName();
    }

    @Override
    public Collection<TblZone> findAllZone() {
        return em.createNamedQuery("TblZone.findAll").getResultList();
    }

    @Override
    public void InsertZone(Integer vid, String Name, String isActive) {

        TblVillage vil = em.find(TblVillage.class, vid);
        Collection<TblZone> zones = vil.getTblZoneCollection();

        TblZone zone = new TblZone();
        zone.setZoneName(Name);
        zone.setVillageId(vil);
        zone.setIsactive("Y");

        zones.add(zone);
        vil.setTblZoneCollection(zones);

        em.persist(zone);
        em.merge(vil);
    }

    @Override
    public void DeleteZone(Integer Id) {
        TblZone zone = em.find(TblZone.class, Id);
        em.remove(zone);
    }

    @Override
    public void UpdateZone(Integer zoneid, String name, Integer villageid) {
        TblZone zone = em.find(TblZone.class, zoneid);
        TblVillage vil = em.find(TblVillage.class, villageid);
        zone.setZoneName(name);
        zone.setVillageId(vil);
        em.persist(zone);
        em.merge(zone);
    }

    @Override
    public void UpdateZoneActive(Integer id, String Active) {
        TblZone zone = em.find(TblZone.class, id);
        zone.setIsactive(Active);
        em.persist(zone);
        em.merge(zone);
    }

    @Override
    public Collection<TblWard> findAllWard() {
        return em.createNamedQuery("TblWard.findAll").getResultList();
    }

    @Override
    public void InsertWard(Integer zid, String Name, String isActive) {

        TblZone zone = em.find(TblZone.class, zid);
        Collection<TblWard> wards = zone.getTblWardCollection();

        TblWard ward = new TblWard();
        ward.setWardName(Name);
        ward.setZoneId(zone);
        ward.setIsactive("Y");

        wards.add(ward);
        zone.setTblWardCollection(wards);

        em.persist(ward);
        em.persist(zone);
    }

    @Override
    public void DeleteWard(Integer Id) {
        TblWard ward = em.find(TblWard.class, Id);
        em.remove(ward);
    }

    @Override
    public void UpdateWard(Integer wardid, String name, Integer zoneid) {
        TblWard ward = em.find(TblWard.class, wardid);
        TblZone zone = em.find(TblZone.class, zoneid);
        ward.setWardName(name);
        ward.setZoneId(zone);
        em.persist(ward);
        em.merge(ward);
    }

    @Override
    public void UpdateWardActive(Integer id, String Active) {
        TblWard ward = em.find(TblWard.class, id);
        ward.setIsactive(Active);
        em.persist(ward);
        em.merge(ward);
    }

    @Override
    public Collection<TblCast> findAllCast() {
        return em.createNamedQuery("TblCast.findAll").getResultList();
    }

    @Override
    public void InsertCast(String Name, String isActive) {
        TblCast cast = new TblCast();
        cast.setCastName(Name);
        cast.setIsactive("Y");
        em.persist(cast);
    }

    @Override
    public void DeleteCast(Integer Id) {
        TblCast cast = em.find(TblCast.class, Id);
        em.remove(cast);
    }

    @Override
    public void UpdateCastActive(Integer id, String Active) {
        TblCast cast = em.find(TblCast.class, id);
        cast.setIsactive(Active);
        em.persist(cast);
        em.merge(cast);
    }

    @Override
    public void UpdateCast(Integer id, String name) {
        TblCast cast = em.find(TblCast.class, id);
        cast.setCastName(name);
        em.persist(cast);
        em.merge(cast);
    }

    @Override
    public Collection<TblQualification> findAllQualification() {
        return em.createNamedQuery("TblQualification.findAll").getResultList();
    }

    @Override
    public void InsertQualification(String Name, String isActive) {
        TblQualification qual = new TblQualification();
        qual.setQualificationName(Name);
        qual.setIsactive("Y");
        em.persist(qual);
    }

    @Override
    public void DeleteQualification(Integer Id) {
        TblQualification qual = em.find(TblQualification.class, Id);
        em.remove(qual);
    }

    @Override
    public void UpdateQualificationActive(Integer id, String Active) {
        TblQualification qual = em.find(TblQualification.class, id);
        qual.setIsactive(Active);
        em.persist(qual);
        em.merge(qual);
    }

    @Override
    public void UpdateQualification(Integer id, String name) {
        TblQualification qual = em.find(TblQualification.class, id);
        qual.setQualificationName(name);
        em.persist(qual);
        em.merge(qual);
    }

    @Override
    public Collection<TblOccupation> findAllOccupation() {
        return em.createNamedQuery("TblOccupation.findAll").getResultList();
    }

    @Override
    public void InsertOccupation(String Name, String isActive) {
        TblOccupation occu = new TblOccupation();
        occu.setOccupationName(Name);
        occu.setIsactive("Y");
        em.persist(occu);
    }

    @Override
    public void DeleteOccupation(Integer Id) {
        TblOccupation occu = em.find(TblOccupation.class, Id);
        em.remove(occu);
    }

    @Override
    public void UpdateOccupationActive(Integer id, String Active) {
        TblOccupation occu = em.find(TblOccupation.class, id);
        occu.setIsactive(Active);
        em.persist(occu);
        em.merge(occu);
    }

    @Override
    public void UpdateOccupation(Integer id, String name) {
        TblOccupation occu = em.find(TblOccupation.class, id);
        occu.setOccupationName(name);
        em.persist(occu);
        em.merge(occu);
    }

    @Override
    public Collection<TblUser> findAllUser() {
        return em.createNamedQuery("TblUser.findAll").getResultList();
    }

    @Override
    public Collection<TblQuestionType> findAllQuestionType() {
        return em.createNamedQuery("TblQuestionType.findAll").getResultList();
    }

    @Override
    public void InsertQuestionType(String Type, String isActive) {
        TblQuestionType type = new TblQuestionType();
        type.setTypeName(Type);
        type.setIsactive(isActive);
        em.persist(type);
    }

    @Override
    public void DeleteQuestionType(Integer Id) {
        TblQuestionType type = em.find(TblQuestionType.class, Id);
        em.remove(type);
    }

    @Override
    public void UpdateQuestionType(Integer Id, String TypeName) {
        TblQuestionType type = em.find(TblQuestionType.class, Id);
        type.setTypeName(TypeName);
        em.persist(type);
        em.merge(type);
    }

    @Override
    public void UpdateQuestionTypeActive(Integer Id, String Active) {
        TblQuestionType type = em.find(TblQuestionType.class, Id);
        type.setIsactive(Active);
        em.persist(type);
        em.merge(type);
    }

    @Override
    public Collection<TblQuestion> findAllQuestion() {
        return em.createNamedQuery("TblQuestion.findAll").getResultList();
    }

    @Override
    public void UpdateQuestionActive(Integer Id, String Active) {
        TblQuestion ques = em.find(TblQuestion.class, Id);
        ques.setIsActive(Active);
        em.persist(ques);
        em.merge(ques);
    }

    @Override
    public Collection<TblQuestionAnswer> findallANSWER() {
        return em.createNamedQuery("TblQuestionAnswer.findAll").getResultList();
    }

    @Override
    public void DeleteFeed(Integer Id, String n) {
        TblFeedback feed = em.find(TblFeedback.class, Id);
        feed.setIsactive(n);
        em.persist(feed);
        em.merge(feed);
    }

    @Override
    public Collection<TblFeedback> findallFeedback() {
        return em.createNamedQuery("TblFeedback.findAll").getResultList();
    }

    @Override
    public void InsertQuestion(TblQuestion question, Collection<Integer> st, Collection<Integer> ds, Collection<Integer> tt, Collection<Integer> vv, Collection<Integer> zz, Collection<Integer> ww, Collection<Integer> cast, Collection<Integer> occu, Collection<Integer> quali) {
        TblQuestion ques = new TblQuestion();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String RegiDate = df.format(today);
        Collection<Integer> m = new ArrayList();
        m.add(1);
        m.add(2);
        m.add(3);

//        st = m;
//        ds = m;
//        tt = m;
//        vv = m;
//        zz = m;
//        cast = m;
        ww = m;
//        quali = m;
//        occu = m;
//        
        ques.setQuestionTypeId(question.getQuestionTypeId());
        ques.setTitle(question.getTitle());
        ques.setDescription(question.getDescription());
        ques.setDate(RegiDate);
        ques.setIsActive("Y");

        //Set Options as per Question Type
        if (question.getQuestionTypeId().getQuestionTypeId() == 1) {
            ques.setOptionA(question.getOptionA());
            ques.setOptionB(question.getOptionB());
            ques.setOptionC(question.getOptionC());
            ques.setOptionD(question.getOptionD());
        } else if (question.getQuestionTypeId().getQuestionTypeId() == 2) {
            ques.setOptionA(question.getOptionA());
            ques.setOptionB(question.getOptionB());
            ques.setOptionC(question.getOptionC());
            ques.setOptionD(" ");
        } else if (question.getQuestionTypeId().getQuestionTypeId() == 3) {
            ques.setOptionA(question.getOptionA());
            ques.setOptionB(question.getOptionB());
            ques.setOptionC(" ");
            ques.setOptionD(" ");
        }

        //Insert State, District, Taluka, Village, Zone, Ward, Cast, Qualification, Occupation
        if (question.getState().trim().contains("All")) {
            ques.setState("All");
        } else {
            ques.setState("Selected");
        }
        if (question.getDistrict().trim().contains("All")) {
            ques.setDistrict("All");
        } else {
            ques.setDistrict("Selected");
        }
        if (question.getTaluka().trim().contains("All")) {
            ques.setTaluka("All");
        } else {
            ques.setTaluka("Selected");
        }
        if (question.getVillage().trim().contains("All")) {
            ques.setVillage("All");
        } else {
            ques.setVillage("Selected");
        }
        if (question.getZone().trim().contains("All")) {
            ques.setZone("All");
        } else {
            ques.setZone("Selected");
        }
        if (question.getWard().trim().contains("All")) {
            ques.setWard("All");
        } else {
            ques.setWard("Selected");
        }
        if (question.getCast().trim().contains("All")) {
            ques.setCast("All");
        } else {
            ques.setCast("Selected");
        }
        if (question.getQualification().trim().contains("All")) {
            ques.setQualification("All");
        } else {
            ques.setQualification("Selected");
        }
        if (question.getOccupation().trim().contains("All")) {
            ques.setOccupation("All");
        } else {
            ques.setOccupation("Selected");
        }
        //Insert into Tbl Question
        em.persist(ques);

        //Get Last Added Question's ID
        Collection<TblQuestion> lastquestion = em.createNamedQuery("TblQuestion.findByIdLast").setMaxResults(1).getResultList();
        TblQuestion q = new TblQuestion();
        for (TblQuestion key : lastquestion) {
            q = em.find(TblQuestion.class, key.getQuestionId());
        }

        //Insert Data into Tbl Question State Table
        if (q.getState().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblState> states = quest.getTblStateCollection();

            for (Integer s : st) {
                TblState state = em.find(TblState.class, s);
                if (!states.contains(state)) {
                    Collection<TblQuestion> quests = state.getTblQuestionCollection();
                    quests.add(quest);
                    states.add(state);
                    em.merge(state);
                }
            }
        }

        //Insert Data into Tbl Question District Table
        if (q.getDistrict().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblDistrict> dists = quest.getTblDistrictCollection();

            for (Integer d : ds) {
                TblDistrict dist = em.find(TblDistrict.class, d);

                if (!dists.contains(dist)) {
                    Collection<TblQuestion> quests = dist.getTblQuestionCollection();
                    quests.add(quest);
                    dists.add(dist);
                    em.merge(dist);
                }
            }
        }

        //Insert Data into Tbl Question Taluka Table
        if (q.getTaluka().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblTaluka> tals = quest.getTblTalukaCollection();

            for (Integer t : tt) {
                TblTaluka tal = em.find(TblTaluka.class, t);
                if (!tals.contains(tal)) {
                    Collection<TblQuestion> quests = tal.getTblQuestionCollection();
                    quests.add(quest);
                    tals.add(tal);
                    em.merge(tal);
                }
            }

        }

        //Insert Data into Tbl Question Village Table
        if (q.getVillage().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblVillage> vlgs = quest.getTblVillageCollection();

            for (Integer v : vv) {
                TblVillage vil = em.find(TblVillage.class, v);

                if (!vlgs.contains(vil)) {
                    Collection<TblQuestion> quests = vil.getTblQuestionCollection();
                    quests.add(quest);
                    vlgs.add(vil);
                    em.merge(vil);
                }
            }
        }

        //Insert Data into Tbl Question Zone Table
        if (q.getZone().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblZone> zones = quest.getTblZoneCollection();

            for (Integer z : zz) {
                TblZone zone = em.find(TblZone.class, z);

                if (!zones.contains(zone)) {
                    Collection<TblQuestion> quests = zone.getTblQuestionCollection();
                    quests.add(quest);
                    zones.add(zone);
                    em.merge(zone);
                }
            }
        }

        //Insert Data into Tbl Question Ward Table
        if (q.getWard().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblWard> wards = quest.getTblWardCollection();

            for (Integer w : ww) {
                TblWard ward = em.find(TblWard.class, w);

                if (!wards.contains(ward)) {
                    Collection<TblQuestion> quests = ward.getTblQuestionCollection();
                    quests.add(quest);
                    wards.add(ward);
                    em.merge(ward);
                }

            }
        }

        //Insert Data into Tbl Question Cast Table
        if (q.getCast().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblCast> casts = quest.getTblCastCollection();

            for (Integer c : cast) {
                TblCast cc = em.find(TblCast.class, c);

                if (!casts.contains(cc)) {
                    Collection<TblQuestion> quests = cc.getTblQuestionCollection();
                    quests.add(quest);
                    casts.add(cc);
                    em.merge(cc);
                }
            }
        }

        //Insert Data into Tbl Question Qualification Table
        if (q.getQualification().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblQualification> quals = quest.getTblQualificationCollection();

            for (Integer qu : quali) {
                TblQualification qual = em.find(TblQualification.class, qu);

                if (!quals.contains(qual)) {
                    Collection<TblQuestion> quests = qual.getTblQuestionCollection();
                    quests.add(quest);
                    quals.add(qual);
                    em.merge(qual);
                }
            }
        }

        //Insert Data into Tbl Question Occupation Table
        if (q.getOccupation().trim().contains("Selected")) {
            TblQuestion quest = em.find(TblQuestion.class, q.getQuestionId());
            Collection<TblOccupation> occups = quest.getTblOccupationCollection();

            for (Integer o : occu) {
                TblOccupation occup = em.find(TblOccupation.class, o);

                if (!occups.contains(occup)) {
                    Collection<TblQuestion> quests = occup.getTblQuestionCollection();
                    quests.add(quest);
                    occups.add(occup);
                    em.merge(occup);
                }
            }
        }
    }

    @Override
    public void DeleteQuestion(Integer Id) {
        TblQuestion ques = em.find(TblQuestion.class, Id);
        em.remove(ques);
    }

    //new
    @Override
    public TblState findByDistrictIdStateName(Integer districtId) {
        TblDistrict dist = em.find(TblDistrict.class, districtId);
        return dist.getStateId();
    }

    @Override
    public String findByDistrictId(Integer districtid) {
        TblDistrict dist = new TblDistrict();
        dist = em.find(TblDistrict.class, districtid);
        return dist.getDistrictName();
    }

    @Override
    public Collection<TblVillage> findVillageByTalukaId(Integer talukaid) {
        TblTaluka taluka = em.find(TblTaluka.class, talukaid);
        return em.createNamedQuery("TblVillage.findByTalukaId").setParameter("talukaId", taluka).getResultList();
    }

    @Override
    public Collection<TblZone> findZoneByVillageId(Integer vid) {
        TblVillage village = em.find(TblVillage.class, vid);
        return em.createNamedQuery("TblZone.findByVillageId").setParameter("villageId", village).getResultList();
    }

    @Override
    public Collection<TblWard> findwardByZoneId(Integer zid) {
        TblZone zone = em.find(TblZone.class, zid);
        return em.createNamedQuery("TblWard.findByZoneId").setParameter("zoneId", zone).getResultList();
    }

    @Override
    public Integer getUserCounts() {
        return em.createNamedQuery("TblUser.findAll").getResultList().size();
    }

    @Override
    public Integer getQuestionCounts() {
        return em.createNamedQuery("TblQuestion.findAll").getResultList().size();
    }

    @Override
    public Integer getResponseCounts() {
        return em.createNamedQuery("TblQuestionAnswer.findAll").getResultList().size();
    }

    @Override
    public Integer getResonseByQuestionId(Integer Id) {
        TblQuestion question = em.find(TblQuestion.class, Id);
        return em.createNamedQuery("TblQuestionAnswer.findByQuestionId").setParameter("queId", question.getQuestionId()).getResultList().size();
    }

    @Override
    public Integer getStateCounts() {
        return em.createNamedQuery("TblState.findAll").getResultList().size();
    }

    @Override
    public HashMap<String, Integer> getCountsByIssue(Integer typeId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytype = em.createNamedQuery("TblQuestionAnswer.findByQuestionType").setParameter("quetypeId", t.getQuestionTypeId()).getResultList();
        for (TblQuestionAnswer qa : answerbytype) {
//            System.out.println("State Name " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateName());
            Integer states = em.createNamedQuery("TblQuestionAnswer.countByStateId").setParameter("stateId", qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
//            System.out.println("Number of Reponse " + states);
            map.put(qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateName(), states);
        }
        //Note: Key = stateid and Value = Total number of reponses
//        for (Map.Entry m : map.entrySet()) {
//            System.out.println("State : "+m.getKey());
//            System.out.print("Reponses : "+m.getValue());
//        }
        return map;
    }

    @Override
    public HashMap<String, Integer> getCountsByIssueState(Integer typeId, Integer stateId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytypeandstate = em.createNamedQuery("TblQuestionAnswer.findByQuestionTypeAndState").setParameter("quetypeId", t.getQuestionTypeId()).setParameter("stateId", stateId).getResultList();
        for (TblQuestionAnswer qa : answerbytypeandstate) {
//            System.out.println("District Name : " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName());
            Integer districts = em.createNamedQuery("TblQuestionAnswer.countByDistId").setParameter("districtId", qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
//            System.out.println(districts);
            map.put(qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName(), districts);
        }

        return map;
    }

    @Override
    public HashMap<String, Integer> getCountsByIssueDistrict(Integer typeId, Integer distId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytypeanddist = em.createNamedQuery("TblQuestionAnswer.findByQuestionTypeAndDist").setParameter("quetypeId", t.getQuestionTypeId()).setParameter("districtId", distId).getResultList();
        for (TblQuestionAnswer qa : answerbytypeanddist) {
//            System.out.println("District Name : " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName());
            Integer talukas = em.createNamedQuery("TblQuestionAnswer.countBytalukas").setParameter("talukaId", qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getTalukaId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
            map.put(qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getTalukaName(), talukas);
        }
        return map;
    }

    @Override
    public HashMap<String, Integer> getCountsByIssueTaluka(Integer typeId, Integer talukaId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytypeandtal = em.createNamedQuery("TblQuestionAnswer.findByQuestionTypeAndTal").setParameter("quetypeId", t.getQuestionTypeId()).setParameter("talukaId", talukaId).getResultList();
        for (TblQuestionAnswer qa : answerbytypeandtal) {
//            System.out.println("District Name : " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName());
            Integer villages = em.createNamedQuery("TblQuestionAnswer.countByvillages").setParameter("villageId", qa.getUserId().getWardId().getZoneId().getVillageId().getVillageId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
            map.put(qa.getUserId().getWardId().getZoneId().getVillageId().getVillageName(), villages);
        }
        return map;
    }

    @Override
    public HashMap<String, Integer> getCountsByIssueVillage(Integer typeId, Integer villageId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytypeandvil = em.createNamedQuery("TblQuestionAnswer.findByQuestionTypeAndVil").setParameter("quetypeId", t.getQuestionTypeId()).setParameter("villageId", villageId).getResultList();
        for (TblQuestionAnswer qa : answerbytypeandvil) {
//            System.out.println("District Name : " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName());
            Integer zones = em.createNamedQuery("TblQuestionAnswer.countByzones").setParameter("zoneId", qa.getUserId().getWardId().getZoneId().getZoneId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
            map.put(qa.getUserId().getWardId().getZoneId().getZoneName(), zones);
        }
        return map;
    }

    @Override
    public HashMap<String, Integer> getCountsByIssueZone(Integer typeId, Integer zoneId) {
        TblQuestionType t = em.find(TblQuestionType.class, typeId);
        HashMap<String, Integer> map = new HashMap< String, Integer>();

        Collection<TblQuestionAnswer> answerbytypeandzone = em.createNamedQuery("TblQuestionAnswer.findByQuestionTypeAndZone").setParameter("quetypeId", t.getQuestionTypeId()).setParameter("zoneId", zoneId).getResultList();
        for (TblQuestionAnswer qa : answerbytypeandzone) {
//            System.out.println("District Name : " + qa.getUserId().getWardId().getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictName());
            Integer wards = em.createNamedQuery("TblQuestionAnswer.countBywards").setParameter("wardId", qa.getUserId().getWardId().getWardId()).setParameter("quetypeId", qa.getQueId().getQuestionTypeId().getQuestionTypeId()).getResultList().size();
            map.put(qa.getUserId().getWardId().getWardName(), wards);
        }
        return map;
    }
    
    @Override
    public String getUserIdfromUsername(String username) {
        Collection<TblUser> user = em.createNamedQuery("TblUser.findByUsername").setParameter("username", username).getResultList();
        for (TblUser users : user) {
            gettinguserId = users.getUserId().toString();
            System.out.println("User Id is " + gettinguserId);
        }
        return gettinguserId;
    }
}
