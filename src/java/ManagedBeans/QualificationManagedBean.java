/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblQualification;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "qualificationManagedBean")
@RequestScoped
public class QualificationManagedBean {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblQualification> quali;
    GenericType<Collection<TblQualification>> gquali;

    Integer id;
    String QualName, isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQualName() {
        return QualName;
    }

    public void setQualName(String QualName) {
        this.QualName = QualName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Creates a new instance of QualificationManagedBean
     */
    public QualificationManagedBean() {
    }

    public Collection<TblQualification> findAllQualification() {
        return this.asb.findAllQualification();
//        gquali = new GenericType<Collection<TblQualification>>(){};
//        res = admin.findAllQualification(Response.class);
//        quali = res.readEntity(gquali);
//        return quali;

    }

    public String InsertQualification() {
        this.asb.InsertQualification(QualName, isActive);
//        this.admin.InsertQualification(this.QualName, this.isActive);
        return "/AdminSide/ViewQualification.jsf?faces-redirect=true";
    }

    public String DeleteQualification(Integer Id) {
        this.asb.DeleteQualification(Id);
//        this.admin.DeleteQualification(id.toString());
        return "/AdminSide/ViewQualification.jsf?faces-redirect=true";
    }

    public void UpdateQualificationActive(Integer id, String Active) {
//        this.asb.UpdateQualificationActive(id, Active);
        this.admin.UpdateQualificationActive(id.toString(), this.isActive);
    }

    public void UpdateQualification(Integer id, String name) {
//        this.asb.UpdateQualification(id, name);
        this.admin.UpdateQualification(id.toString(), this.QualName);
    }
    
     public String openAddQualification(){
       return "/AdminSide/AddQualification.jsf?faces-redirect=true";
    }
}
