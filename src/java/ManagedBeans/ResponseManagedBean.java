/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Entity.TblQuestion;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author HP
 */
@Named(value = "responseManagedBean")
@SessionScoped
public class ResponseManagedBean implements Serializable {
    
    @EJB AdminSessionBeanLocal asb;
    Integer Id;

    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    /**
     * Creates a new instance of ResponseManagedBean
     */
    public ResponseManagedBean() {
    }
    
    public Integer responseByQuestionId(Integer queId){
        System.out.println(queId);
        return this.asb.getResonseByQuestionId(queId);
    }
    
}
