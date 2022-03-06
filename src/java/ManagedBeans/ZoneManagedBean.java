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
import Entity.TblZone;
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
@Named(value = "zoneManagedBean")
@SessionScoped
public class ZoneManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblZone> zone;
    GenericType<Collection<TblZone>> gzone;

    Integer zoneid, villageid, districtid, stateid, talukaid;
    String ZoneName, isActive;

    TblZone currentZone;
    Collection<TblDistrict> district;
    Collection<TblTaluka> taluka;
    Collection<TblVillage> village;

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getVillageid() {
        return villageid;
    }

    public void setVillageid(Integer villageid) {
        this.villageid = villageid;
    }

    public Integer getTalukaid() {
        return talukaid;
    }

    public void setTalukaid(Integer talukaid) {
        this.talukaid = talukaid;
    }

    public Collection<TblDistrict> getDistrict() {
        if (currentZone.getVillageId() != null) {
            if (district == null) {
                district = asb.findStateByDistrictId(this.currentZone.getVillageId().getTalukaId().getDistrictId().getStateId().getStateId());
            }
        }
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblTaluka> getTaluka() {
        if (taluka == null) {
            taluka = asb.findTalukaByDistrictId(this.currentZone.getVillageId().getTalukaId().getDistrictId().getDistrictId());
        }

        return taluka;
    }

    public void setTaluka(Collection<TblTaluka> taluka) {
        this.taluka = taluka;
    }

    public Collection<TblVillage> getVillage() {
        if (village == null) {
            village = asb.findVillageByTalukaId(this.currentZone.getVillageId().getTalukaId().getTalukaId());
        }

        return village;
    }

    public void setVillage(Collection<TblVillage> village) {
        this.village = village;
    }

    public TblZone getCurrentZone() {
        return currentZone;
    }

    public void setCurrentZone(TblZone currentZone) {
        this.currentZone = currentZone;
    }

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
    }

    public Collection<TblZone> getZone() {
        return zone;
    }

    public void setZone(Collection<TblZone> zone) {
        this.zone = zone;
    }

    public String getZoneName() {
        return ZoneName;
    }

    public void setZoneName(String ZoneName) {
        this.ZoneName = ZoneName;
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

    public Collection<TblVillage> findAllVillage() {
        return asb.findVillageByTalukaId(talukaid);
    }

    public void dropState(AjaxBehaviorEvent enevt) {
        district = asb.findStateByDistrictId(this.currentZone.getVillageId().getTalukaId().getDistrictId().getStateId().getStateId());
    }

    public void dropdistrict(AjaxBehaviorEvent event) {
        taluka = asb.findTalukaByDistrictId(this.currentZone.getVillageId().getTalukaId().getDistrictId().getDistrictId());
    }

    public void droptaluka(AjaxBehaviorEvent event) {
        village = asb.findVillageByTalukaId(this.currentZone.getVillageId().getTalukaId().getTalukaId());
    }

    /**
     * Creates a new instance of ZoneManagedBean
     */
    public ZoneManagedBean() {
    }

    public Collection<TblZone> allZone() {
//        return this.asb.findAllZone();
        gzone = new GenericType<Collection<TblZone>>() {
        };
        res = admin.findAllZone(Response.class);
        zone = res.readEntity(gzone);
        return zone;
    }

    public String InsertZone() {

        this.asb.InsertZone(villageid, ZoneName, isActive);
//        this.admin.InsertZone(villageid.toString(), this.ZoneName, this.isActive);
        ZoneName = "";
        return "/AdminSide/ViewZone.jsf?faces-redirect=true";
//return "";
    }

    public String DeleteZone(Integer Id) {
        this.asb.DeleteZone(Id);
//        this.admin.DeleteZone(vid.toString());
        return "/AdminSide/ViewZone.jsf?faces-redirect=true";
    }

    public String UpdateZone(Integer zoneid) {
        ZoneName = currentZone.getZoneName();
        stateid = currentZone.getVillageId().getTalukaId().getDistrictId().getStateId().getStateId();
        districtid = currentZone.getVillageId().getTalukaId().getDistrictId().getDistrictId();
        talukaid = currentZone.getVillageId().getTalukaId().getTalukaId();
        villageid = currentZone.getVillageId().getVillageId();
        this.asb.UpdateZone(zoneid, ZoneName, villageid);
        ZoneName = "";
//        this.admin.UpdateZone(zid.toString(), this.ZoneName, vid.toString());
        return "/AdminSide/ViewZone.jsf?faces-redirect=true";
    }

    public String editZone(Integer zoneid) {
        return "/AdminSide/EditZone.jsf?faces-redirect=true";
    }

    public void UpdateZoneActive(Integer id, String Active) {
        this.asb.UpdateZoneActive(id, Active);
//        this.admin.UpdateZoneActive(zid.toString(), this.isActive);
    }

    public String openAddZone() {
        return "/AdminSide/AddZone.jsf?faces-redirect=true";
    }

}
