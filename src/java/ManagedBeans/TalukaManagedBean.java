/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblDistrict;
import Entity.TblState;
import Entity.TblTaluka;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "talukaManagedBean")
@SessionScoped
public class TalukaManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblTaluka> tal;
    GenericType<Collection<TblTaluka>> gtal;

    Collection<TblDistrict> district;

    Integer talukaId, distId, stateId;
    String talName, isActive, distName;

    List getAllTaluka;
    TblTaluka currentTaluka;

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public List getGetAllTaluka() {
        return getAllTaluka;
    }

    public void setGetAllTaluka(List getAllTaluka) {
        this.getAllTaluka = getAllTaluka;
    }

    public TblTaluka getCurrentTaluka() {
        return currentTaluka;
    }

    public void setCurrentTaluka(TblTaluka currentTaluka) {
        this.currentTaluka = currentTaluka;
    }

    public AdminClient getAdmin() {
        return admin;
    }

    public void setAdmin(AdminClient admin) {
        this.admin = admin;
    }

    public TalukaManagedBean() {
    }

    public Collection<TblTaluka> getTal() {
        return tal;
    }

    public void setTal(Collection<TblTaluka> tal) {
        this.tal = tal;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public void setTalukaId(Integer talukaId) {
        this.talukaId = talukaId;
    }

    public Integer getDistId() {
        return distId;
    }

    public void setDistId(Integer distId) {
        this.distId = distId;
    }

    public String getTalName() {
        return talName;
    }

    public void setTalName(String talName) {
        this.talName = talName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Collection<TblDistrict> getDistrict() {
        
        if(district==null)
        {
           district =asb.findStateByDistrictId(this.currentTaluka.getDistrictId().getStateId().getStateId());
        }
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblState> findAllState() {
        return asb.findAllState();
    }

    public Collection<TblDistrict> findAllDistrict() {
        return asb.findStateByDistrictId(stateId);
    }

    public void dropState(AjaxBehaviorEvent enevt) {
        district = asb.findStateByDistrictId(this.currentTaluka.getDistrictId().getStateId().getStateId());
    }

    /**
     * Creates a new instance of TalukaManagedBean
     */
    public String InsertTaluka() {
//        this.asb.InsertTaluka(distId, talName, isActive);
        this.admin.InsertTaluka(distId.toString(), this.talName, this.isActive);
//        distId = null;
        talName = "";
        return "/AdminSide/ViewTaluka.jsf?faces-redirect=true";
    }

    public String DeleteTaluka(Integer Id) {
        this.asb.DeleteTaluka(Id);
//        this.admin.DeleteTaluka(talukaId.toString());
        return "/AdminSide/ViewTaluka.jsf?faces-redirect=true";
    }

    public void UpdateTalukaActive(Integer id, String Active) {
//        this.asb.UpdateTalukaActive(id, Active);
        this.admin.UpdateTalukaActive(talukaId.toString(), this.isActive);
    }

    public String UpdateTaluka(Integer talukaId) {
        talName = currentTaluka.getTalukaName();
        stateId = currentTaluka.getDistrictId().getStateId().getStateId();
        distId = currentTaluka.getDistrictId().getDistrictId();
//        this.asb.UpdateTaluka(id, tname, districtId);
        this.admin.UpdateTaluka(talukaId.toString(), this.talName, distId.toString());
        distId = null;
        talName = "";
        return "/AdminSide/ViewTaluka.jsf?faces-redirect=true";
    }

    public String editTaluka(Integer talukaId) {
        return "/AdminSide/EditTaluka.jsf?faces-redirect=true";
    }

    public Collection<TblTaluka> findByTalukaid(Integer id) {
//        return this.asb.findByTalukaid(id);
        gtal = new GenericType<Collection<TblTaluka>>() {
        };
        res = admin.findByTalukaid(Response.class, id.toString());
        tal = res.readEntity(gtal);
        return tal;
    }

    public Collection<TblTaluka> findAllTaluka() {
        return this.asb.findAllTaluka();
//        gtal = new GenericType<Collection<TblTaluka>>() {
//        };
//        res = admin.findAllTaluka(Response.class);
//        tal = res.readEntity(gtal);
//        return tal;
    }

    public Collection<TblTaluka> findTalukaByDistrictId(Integer id) {
//        return this.asb.findTalukaByDistrictId(id);
        gtal = new GenericType<Collection<TblTaluka>>() {
        };
        res = admin.findTalukaByDistrictId(Response.class, id.toString());
        tal = res.readEntity(gtal);
        return tal;
    }

    public String openAddTaluka() {
        return "/AdminSide/AddTaluka.jsf?faces-redirect=true";
    }

}
