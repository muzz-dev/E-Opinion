/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Entity.TblDistrict;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author HP
 */
@Named(value = "commonManagedBean")
@ViewScoped
public class commonManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;

    Collection<TblDistrict> district;
    Collection<TblTaluka> taluka;
    Collection<TblVillage> village;
    Collection<TblZone> zone;
    Collection<TblWard> ward;
    Integer wid, zid, did, tid, vid, sid;

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public Collection<TblWard> getWard() {
        return ward;
    }

    public void setWard(Collection<TblWard> ward) {
        this.ward = ward;
    }

    public Collection<TblDistrict> getDistrict() {
        return district;
    }

    public void setDistrict(Collection<TblDistrict> district) {
        this.district = district;
    }

    public Collection<TblTaluka> getTaluka() {
        return taluka;
    }

    public void setTaluka(Collection<TblTaluka> taluka) {
        this.taluka = taluka;
    }

    public Collection<TblVillage> getVillage() {
        return village;
    }

    public void setVillage(Collection<TblVillage> village) {
        this.village = village;
    }

    public Collection<TblZone> getZone() {
        return zone;
    }

    public void setZone(Collection<TblZone> zone) {
        this.zone = zone;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getZid() {
        return zid;
    }

    public void setZid(Integer zid) {
        this.zid = zid;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public Collection<TblState> findAllState(){
        return asb.findAllState();
    }
    
    public Collection<TblDistrict> findAllDistrict(){
        return asb.findStateByDistrictId(sid);
    }
    
    public Collection<TblTaluka> findAllTaluka(){
        return asb.findTalukaByDistrictId(did);
    }
    
    public Collection<TblVillage> findAllVillage(){
        return asb.findVillageByTalukaId(tid);
    }
    
    public Collection<TblZone> findAllZone(){
        return asb.findZoneByVillageId(vid);
    }
    
    public Collection<TblWard> findAllWard(){
        return asb.findwardByZoneId(zid);
    }
    
    public void dropState(AjaxBehaviorEvent enevt){
       district =  asb.findStateByDistrictId(sid);
    }
    
    public void dropdistrict(AjaxBehaviorEvent event){
        taluka = asb.findTalukaByDistrictId(did);
    }
    
    public void droptaluka(AjaxBehaviorEvent event){
        village = asb.findVillageByTalukaId(tid);
    }
    
    public void dropVillage(AjaxBehaviorEvent event){
        zone = asb.findZoneByVillageId(vid);
    }
    
    public void dropZone(AjaxBehaviorEvent event){
        ward = asb.findwardByZoneId(zid);
    }


    /**
     * Creates a new instance of commonManagedBean
     */
    public commonManagedBean() {
    }

}
