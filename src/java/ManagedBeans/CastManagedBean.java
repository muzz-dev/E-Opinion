/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblCast;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "castManagedBean")
@RequestScoped
public class CastManagedBean {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblCast> cast;
    GenericType<Collection<TblCast>> gcast;

    Integer Id;
    String Cast;
    String isActive;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCast() {
        return Cast;
    }

    public void setCast(String Cast) {
        this.Cast = Cast;
    }

    /**
     * Creates a new instance of CastManagedBean
     */
    public CastManagedBean() {

    }

    public String InsertCast() {
        this.asb.InsertCast(Cast, isActive);
//        this.admin.InsertCast(this.Cast, isActive);
        return "/AdminSide/ViewCast.jsf?faces-redirect=true";
    }

    public String openAddCast() {
        return "/AdminSide/AddCast.jsf?faces-redirect=true";
    }

    public String DeleteCast(Integer Id) {
        this.asb.DeleteCast(Id);
//          this.admin.DeleteCast(Id.toString());
        return "/AdminSide/ViewCast.jsf?faces-redirect=true";
    }

    public void UpdateCastActive(Integer id, String Active) {
//        this.asb.UpdateCastActive(id, Active);
        this.admin.UpdateCastActive(this.Cast, this.isActive);
    }

    public String UpdateCast(Integer id, String name) {
        this.asb.UpdateCast(id, name);
//        this.admin.UpdateCast(id.toString(), this.Cast);
        return "/AdminSide/EditCast.jsf?faces-redirect=true";
    }

    public Collection<TblCast> findAllCast() {
//        return this.asb.findAllCast();
        gcast = new GenericType<Collection<TblCast>>() {
        };
        res = admin.findAllCast(Response.class);
        cast = res.readEntity(gcast);
        return cast;
    }
}
