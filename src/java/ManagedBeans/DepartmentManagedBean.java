/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Entity.TblDepartment;
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
@Named(value = "departmentManagedBean")
@RequestScoped
public class DepartmentManagedBean {

    @EJB
    private AdminSessionBeanLocal asb;

    AdminClient admin = new AdminClient();
    Response res;
    TblDepartment dept = new TblDepartment();
    GenericType<TblDepartment> gdept;
    Collection<TblDepartment> department;
    GenericType<Collection<TblDepartment>> gdepartment;

    Integer deptid;
    String deptName, isActive;

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    /**
     * Creates a new instance of DepartmentManagedBean
     */
    public DepartmentManagedBean() {
    }

    public Collection<TblDepartment> findalldepartment() {
        return this.asb.findalldepartment();
//        gdepartment = new GenericType<Collection<TblDepartment>>() {
//        };
//        res = admin.findalldepartment(Response.class);
//        department = res.readEntity(gdepartment);
//        return department;
    }

    public TblDepartment findDepartmentById(Integer id) {
//        return this.asb.findDepartmentById(id);
        gdept = new GenericType<TblDepartment>(){};
        res = admin.findDepartmentById(Response.class, id.toString());
        dept = res.readEntity(gdept);
        return dept;
    }

    public String InsertDepartment() {
        this.asb.InsertDepartment(deptName, isActive);
//        this.admin.InsertDepartment(this.deptName, this.isActive);
        return "/AdminSide/ViewDepartment.jsf?faces-redirect=true";
    }
    
    
     public String openAddDepartment(){
       return "/AdminSide/AddDepartment.jsf?faces-redirect=true";
    }

    public String DeleteDepartment(Integer deptId) {
        this.asb.DeleteDepartment(deptId);
//        this.admin.DeleteDepartment(deptId.toString());
        return "/AdminSide/ViewDepartment.jsf?faces-redirect=true";
    }

    public void UpdateDepartmentActive(Integer id, String isActive) {
//        this.asb.UpdateDepartmentActive(id, Active);
        this.admin.UpdateDepartmentActive(id.toString(), this.isActive);
    }

    public void updateDepartment(String deptName, Integer id) {
//        this.asb.updateDepartment(deptName, id);
        this.admin.updateDepartment(this.deptName, id.toString());
    }
}
