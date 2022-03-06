/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblOccupation;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "occupationManagedBean")
@RequestScoped
public class OccupationManagedBean {
    
    @EJB 
    private AdminSessionBeanLocal asb;
    
    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblOccupation> occu;
    GenericType <Collection<TblOccupation>> goccu;
    Integer id;
    String OccuName, isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccuName() {
        return OccuName;
    }

    public void setOccuName(String OccuName) {
        this.OccuName = OccuName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Creates a new instance of OccupationManagedBean
     */
    public OccupationManagedBean() {
    }
    
    public Collection<TblOccupation> findAllOccupation(){
        return this.asb.findAllOccupation();
//        goccu = new GenericType<Collection<TblOccupation>>(){};
//        res= admin.findAllOccupation(Response.class);
//        occu = res.readEntity(goccu);
//        return occu;
    }
    
    public String InsertOccupation(){
        this.asb.InsertOccupation(OccuName, isActive);
//          this.admin.InsertOccupation(this.OccuName,this.isActive);
        return "/AdminSide/ViewOccupation.jsf?faces-redirect=true";
    }
    
    public String DeleteOccupation(Integer Id){
        this.asb.DeleteOccupation(Id);
//        this.admin.DeleteOccupation(id.toString());
         return "/AdminSide/ViewOccupation.jsf?faces-redirect=true";
    }
    
    public void UpdateOccupationActive(Integer id, String Active){
//        this.asb.UpdateOccupationActive(id, Active);
           this.admin.UpdateOccupationActive(id.toString(), this.isActive);
    }
    
    public void UpdateOccupation(Integer id, String name){
        this.asb.UpdateOccupation(id, name);
        this.admin.UpdateOccupation(id.toString(), this.OccuName);
    }
    
     public String openAddOccupation(){
       return "/AdminSide/AddOccupation.jsf?faces-redirect=true";
    }
}
