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
import Entity.TblVillage;
import java.io.Serializable;
import java.util.Collection;
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
@Named(value = "villageManagedBean")
@SessionScoped
public class VillageManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblVillage> vil;
    GenericType<Collection<TblVillage>> gvill;

    TblVillage currentVillage;
    Collection<TblDistrict> district;
    Collection<TblTaluka> taluka;

    Integer vid, talukaid, stateid, districtid;
    String VillageName, isActive;

    public Collection<TblDistrict> getDistrict() {
        if (currentVillage.getTalukaId() != null) {
            if (district == null) {
                district = asb.findStateByDistrictId(this.currentVillage.getTalukaId().getDistrictId().getStateId().getStateId());
            }
        }
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblTaluka> getTaluka() {

        if (currentVillage.getTalukaId() != null) {
            if (taluka == null) {
                taluka = asb.findTalukaByDistrictId(this.currentVillage.getTalukaId().getDistrictId().getDistrictId());
            }
        }
        return taluka;
    }

    public void setTaluka(Collection<TblTaluka> taluka) {
        this.taluka = taluka;
    }

    public AdminClient getAdmin() {
        return admin;
    }

    public void setAdmin(AdminClient admin) {
        this.admin = admin;
    }

    public TblVillage getCurrentVillage() {
        return currentVillage;
    }

    public void setCurrentVillage(TblVillage currentVillage) {
        this.currentVillage = currentVillage;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getTalukaid() {
        return talukaid;
    }

    public void setTalukaid(Integer talukaid) {
        this.talukaid = talukaid;
    }

    public Collection<TblVillage> getVil() {
        return vil;
    }

    public void setVil(Collection<TblVillage> vil) {
        this.vil = vil;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVillageName() {
        return VillageName;
    }

    public void setVillageName(String VillageName) {
        this.VillageName = VillageName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Collection<TblState> findAllState() {
        return asb.findAllState();
    }

    public Collection<TblDistrict> findAllDistrict() {
        return asb.findStateByDistrictId(stateid);
    }

    public Collection<TblTaluka> findAllTaluka() {
        return asb.findTalukaByDistrictId(districtid);
    }

    public void dropState(AjaxBehaviorEvent enevt) {
        district = asb.findStateByDistrictId(this.currentVillage.getTalukaId().getDistrictId().getStateId().getStateId());
    }

    public void dropdistrict(AjaxBehaviorEvent event) {
        taluka = asb.findTalukaByDistrictId(this.currentVillage.getTalukaId().getDistrictId().getDistrictId());
    }

    /**
     * Creates a new instance of VillageManagedBean
     */
    public VillageManagedBean() {
    }

    public Collection<TblVillage> findAllVillage() {
//        return this.asb.findAllVillage();
        gvill = new GenericType<Collection<TblVillage>>() {
        };
        res = admin.findAllVillage(Response.class);
        vil = res.readEntity(gvill);
        return vil;
    }

    public Collection<TblVillage> findVillageById(Integer vid) {
//        return this.asb.findVillageById(vid);
        gvill = new GenericType<Collection<TblVillage>>() {
        };
        res = admin.findVillageById(Response.class, vid.toString());
        vil = res.readEntity(gvill);
        return vil;
    }

    public String findStateByVillage(Integer vid) {
        return this.asb.findStateByVillage(vid);
    }

    public String InsertVillage() {
        this.asb.InsertVillage(talukaid, VillageName, isActive);
        VillageName = "";
//        this.admin.InsertVillage(talukaid.toString(), this.isActive, this.VillageName);
        return "/AdminSide/ViewVillage.jsf?faces-redirect=true";
    }

    public String DeleteVillage(Integer Id) {
        this.asb.DeleteVillage(Id);
//        this.admin.DeleteVillage(vid.toString());
        return "/AdminSide/ViewVillage.jsf?faces-redirect=true";
    }

    public void UpdateVillageActive(Integer id, String Active) {
//        this.asb.UpdateVillageActive(id, Active);
        this.admin.UpdateVillageActive(vid.toString(), this.isActive);
    }

    public String UpdateVillage(Integer vid) {
        System.out.println("Hello");
        VillageName = currentVillage.getVillageName();
        stateid = currentVillage.getTalukaId().getDistrictId().getStateId().getStateId();
        districtid = currentVillage.getTalukaId().getDistrictId().getDistrictId();
        talukaid = currentVillage.getTalukaId().getTalukaId();
        this.asb.UpdateVillage(vid, VillageName, talukaid);
//        this.admin.UpdateVillage(vid.toString(), this.VillageName, talukaid.toString());
        VillageName = "";
//        stateid = null;
//        districtid = null;
//        talukaid = null;
        return "/AdminSide/ViewVillage.jsf?faces-redirect=true";
    }

    public String editVillage(Integer vid) {
        return "/AdminSide/EditVillage.jsf?faces-redirect=true";
    }

    public String openAddVillage() {
        return "/AdminSide/AddVillage.jsf?faces-redirect=true";
    }

}
