/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author HP
 */
@Named(value = "dashboardManagedBean")
@SessionScoped
public class DashboardManagedBean implements Serializable {
    
    @EJB AdminSessionBeanLocal asb;

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }
    
    /**
     * Creates a new instance of DashboardManagedBean
     */
    public DashboardManagedBean() {
    }
    
     public Integer userCounts(){
         return this.asb.getUserCounts();
     }
    
     public Integer questionCounts(){
         return this.asb.getQuestionCounts();
     }
     
     public Integer responseCounts(){
         return this.asb.getResponseCounts();
     }
}
