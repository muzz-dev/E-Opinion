/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblDistrict;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "districtManagedBean")
@SessionScoped
public class DistrictManagedBean implements Serializable  {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblDistrict> dist;
    GenericType<Collection<TblDistrict>> gdist;
  

    Integer stateId;
    Integer DistrictId;
    String DistrictName;
    String isActive;

    List allDistrictInfo;
    TblDistrict currentDistrict;

    public Collection<TblDistrict> getDist() {
        return dist;
    }

    public void setDist(Collection<TblDistrict> dist) {
        this.dist = dist;
    }

    public List getAllDistrictInfo() {
        return allDistrictInfo;
    }

    public void setAllDistrictInfo(List allDistrictInfo) {
        this.allDistrictInfo = allDistrictInfo;
    }

    public TblDistrict getCurrentDistrict() {
        return currentDistrict;
    }

    public void setCurrentDistrict(TblDistrict currentDistrict) {
        this.currentDistrict = currentDistrict;
    }
    
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getDistrictId() {
        return DistrictId;
    }

    public void setDistrictId(Integer DistrictId) {
        this.DistrictId = DistrictId;
    }

    public String getDistrictName() {
        return DistrictName;
    }

    public void setDistrictName(String DistrictName) {
        this.DistrictName = DistrictName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Creates a new instance of DistrictManagedBean
     */
    public DistrictManagedBean() {
    }

    public Collection<TblDistrict> findAllDistrict() {
        return this.asb.findAllDistrict();
//        gdist = new GenericType<Collection<TblDistrict>>() {};
//        res = admin.findAllDistrict(Response.class);
//        dist = res.readEntity(gdist);
//        return dist;
    }

    public Collection<TblDistrict> findStateByDistrictId(Integer id) {
//        return this.asb.findStateByDistrictId(id);
        gdist = new GenericType<Collection<TblDistrict>>(){};
        res = admin.findStateByDistrictId(Response.class , id.toString());
        dist = res.readEntity(gdist);
        return dist;
    }

    public String InsertDistrict() {
//        this.asb.InsertDistrict(stateId, DistrictName, isActive);
           this.admin.InsertDistrict(stateId.toString(),this.DistrictName, this.isActive);
           
           DistrictName = "";
           stateId = null;
        return "/AdminSide/ViewDistrict.jsf?faces-redirect=true";
    }

    public String DeleteDistrict(Integer Id) {
        this.asb.DeleteDistrict(Id);
//          this.admin.DeleteDistrict(Id.toString());
        return "/AdminSide/ViewDistrict.jsf?faces-redirect=true";
    }

    public void UpdateDistrictActive(Integer id, String Active) {
//        this.asb.UpdateDistrictActive(id, Active);
          this.admin.UpdateDistrictActive(id.toString(), Active);
    }

    public String UpdateDistrict(Integer distId) {
        DistrictName = currentDistrict.getDistrictName();
        stateId = currentDistrict.getStateId().getStateId();
//        this.asb.UpdateDistrict(id, dname, sid);
          this.admin.UpdateDistrict(distId.toString(), DistrictName, stateId.toString());
          DistrictName = "";
         stateId = null;
           return "/AdminSide/ViewDistrict.jsf?faces-redirect=true";
    }
    
    public String editDistrict(Integer distId){
        return "/AdminSide/EditDistrict.jsf?faces-redirect=true";
    }
     public String openAddDistrict(){
       return "/AdminSide/AddDistrict.jsf?faces-redirect=true";
    }
}
