/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblState;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.PrimeFaces;

/**
 *
 * @author muzz
 */
@Named(value = "stateManagedBean")
@SessionScoped
public class StateManagedBean implements Serializable {

    //Using EJB
    @EJB
    AdminSessionBeanLocal asb;

    //Using REST
    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblState> state;
    GenericType<Collection<TblState>> gstate;

    String stateName, isActive;
    Integer id;
    List allStateInfo;
    TblState currentstate;


    public Collection<TblState> getState() {
        return state;
    }

    public void setState(Collection<TblState> state) {
        this.state = state;
    }

    public List getAllStateInfo() {
        return allStateInfo;
    }

    public void setAllStateInfo(List allStateInfo) {
        this.allStateInfo = allStateInfo;
    }

    public TblState getCurrentstate() {
        return currentstate;
    }

    public void setCurrentstate(TblState currentstate) {
        this.currentstate = currentstate;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Creates a new instance of StateManagedBean
     */
    public StateManagedBean() {
    }

    public Collection<TblState> findAllState() {
        return this.asb.findAllState();
//        gstate = new GenericType<Collection<TblState>>(){};
//        res = admin.findAllState(Response.class);
//        state = res.readEntity(gstate);
//        return state;
    }

    public Collection<TblState> findStateById(Integer id) {
//        return this.asb.findStateById(id);
        gstate = new GenericType<Collection<TblState>>() {
        };
        res = admin.findStateById(Response.class, id.toString());
        state = res.readEntity(gstate);
        return state;

    }

    public String openAddState() {
        return "/AdminSide/AddState.jsf?faces-redirect=true";
    }

    public String InsertState() {
//        System.out.println(this.stateName);
        this.asb.InsertState(stateName, "Y");
//        this.admin.InsertState(stateName, "Y");
        stateName = "";
        return "/AdminSide/ViewStates.jsf?faces-redirect=true";
    }

    public String DeleteState(Integer id) {
        this.admin.DeleteState(id.toString());
        System.out.println("Hello");
//        this.asb.DeleteState(id);
        this.currentstate = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
//        System.out.println("Hello");
        return "/AdminSide/ViewStates.jsf?faces-redirect=true";
    }

    public String UpdateStateActive(Integer id, String Active) {
        this.admin.UpdateStateActive(id.toString(), Active);
        return "/AdminSide/ViewStates.jsf?faces-redirect=true";
    }

    public String updateState(Integer stateid) {
        stateName = currentstate.getStateName();
        System.out.println(stateid);
        System.out.println(stateName);
        this.asb.updateState(stateName, stateid);
//        this.admin.updateState(this.stateName, stateid.toString());
        stateName = "";
        return "/AdminSide/ViewStates.jsf?faces-redirect=true";

//return "";
    }

    public String EditState(Integer stateId) {
        return "/AdminSide/EditState.jsf?faces-redirect=true";
    }

}
