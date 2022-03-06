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
import Entity.TblWard;
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
@Named(value = "wardManagedBean")
@SessionScoped
public class WardManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblWard> ward;
    GenericType<Collection<TblWard>> gward;

    Integer wardid, zoneid, villageid, talukaid, districtid, stateid;
    String WardName, isActive;

    TblWard currentWard;
    Collection<TblDistrict> district;
    Collection<TblTaluka> taluka;
    Collection<TblVillage> village;
    Collection<TblZone> zone;

    public Integer getWardid() {
        return wardid;
    }

    public void setWardid(Integer wardid) {
        this.wardid = wardid;
    }

    public Integer getZoneid() {
        return zoneid;
    }

    public void setZoneid(Integer zoneid) {
        this.zoneid = zoneid;
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

    public TblWard getCurrentWard() {
        return currentWard;
    }

    public void setCurrentWard(TblWard currentWard) {
        this.currentWard = currentWard;
    }

    public Collection<TblDistrict> getDistrict() {
            if (district == null) {
                district = asb.findStateByDistrictId(this.currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateId());
            }
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblTaluka> getTaluka() {
        if (currentWard.getZoneId() != null) {
            if (taluka == null) {
                taluka = asb.findTalukaByDistrictId(this.currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictId());
            }
        }
        return taluka;
    }

    public void setTaluka(Collection<TblTaluka> taluka) {
        this.taluka = taluka;
    }

    public Collection<TblVillage> getVillage() {
        if (currentWard.getZoneId() != null) {
            if (village == null) {
                village = asb.findVillageByTalukaId(this.currentWard.getZoneId().getVillageId().getTalukaId().getTalukaId());
            }
        }
        return village;
    }

    public void setVillage(Collection<TblVillage> village) {
        this.village = village;
    }

    public Collection<TblZone> getZone() {
        if (currentWard.getZoneId() != null) {
            if (zone == null) {
                zone = asb.findZoneByVillageId(this.currentWard.getZoneId().getVillageId().getVillageId());
            }
        }
        return zone;
    }

    public void setZone(Collection<TblZone> zone) {
        this.zone = zone;
    }

    public Collection<TblWard> getWard() {
        return ward;
    }

    public void setWard(Collection<TblWard> ward) {
        this.ward = ward;
    }

    public String getWardName() {
        return WardName;
    }

    public void setWardName(String WardName) {
        this.WardName = WardName;
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

    public Collection<TblZone> findAllZone() {
        return asb.findZoneByVillageId(villageid);
    }

    public void dropState(AjaxBehaviorEvent enevt) {
        district = asb.findStateByDistrictId(this.currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateId());
    }

    public void dropdistrict(AjaxBehaviorEvent event) {
        taluka = asb.findTalukaByDistrictId(this.currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictId());
    }

    public void droptaluka(AjaxBehaviorEvent event) {
        village = asb.findVillageByTalukaId(this.currentWard.getZoneId().getVillageId().getTalukaId().getTalukaId());
    }

    public void dropVillage(AjaxBehaviorEvent event) {
        zone = asb.findZoneByVillageId(this.currentWard.getZoneId().getVillageId().getVillageId());
    }

    /**
     * Creates a new instance of WardManagedBean
     */
    public WardManagedBean() {
    }

    public Collection<TblWard> findAllWard() {
//        return this.asb.findAllWard();
        gward = new GenericType<Collection<TblWard>>() {
        };
        res = admin.findAllWard(Response.class);
        ward = res.readEntity(gward);
        return ward;
    }

    public String InsertWard() {
        this.asb.InsertWard(zoneid, WardName, isActive);
        WardName = "";
//        this.admin.InsertWard(zoneid.toString(), this.WardName, this.isActive);

        return "/AdminSide/ViewWard.jsf?faces-redirect=true";
//return "";
    }

    public String DeleteWard(Integer id) {
        this.asb.DeleteWard(id);
//        this.admin.DeleteWard(id.toString());
        return "/AdminSide/ViewWard.jsf?faces-redirect=true";
    }

    public String UpdateWard(Integer wardid) {
        WardName = currentWard.getWardName();
        stateid = currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getStateId().getStateId();
        districtid = currentWard.getZoneId().getVillageId().getTalukaId().getDistrictId().getDistrictId();
        talukaid = currentWard.getZoneId().getVillageId().getTalukaId().getTalukaId();
        villageid = currentWard.getZoneId().getVillageId().getVillageId();
        zoneid = currentWard.getZoneId().getZoneId();
//        this.asb.UpdateWard(wardid, name, zoneid);
        this.admin.UpdateWard(wardid.toString(), this.WardName, zoneid.toString());
        return "/AdminSide/ViewWard.jsf?faces-redirect=true";
    }

    public String editWard(Integer wardid) {
        return "/AdminSide/EditWard.jsf?faces-redirect=true";
    }

    public void UpdateWardActive(Integer id, String Active) {
//        this.asb.UpdateWardActive(id, Active);
        this.admin.updateDepartment(wardid.toString(), this.isActive);
    }

    public String openAddWard() {
        return "/AdminSide/AddWard.jsf?faces-redirect=true";
    }
}
