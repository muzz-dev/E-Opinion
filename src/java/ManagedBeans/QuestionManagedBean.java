/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Entity.TblQuestion;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author HP
 */
@Named(value = "questionManagedBean")
@SessionScoped
public class QuestionManagedBean implements Serializable{
    
    @EJB AdminSessionBeanLocal asb;
    
    String username , email,mobilenumber, isActive,date;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
    Integer questionId;

    public AdminSessionBeanLocal getAsb() {
        return asb;
    }

    public void setAsb(AdminSessionBeanLocal asb) {
        this.asb = asb;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }


    /**
     * Creates a new instance of QuestionManagedBean
     */
    public QuestionManagedBean() {
    }
    
    public Collection<TblQuestion> allQuestion(){
        return this.asb.findAllQuestion();
    }
    
    public String openAddQuestion(){
        return "/AdminSide/AddQuestion.jsf?faces-redirect=true";
    }
    
    public String removeQuestion(Integer questionId){
        this.asb.DeleteQuestion(questionId);
        return "/AdminSide/ViewQuestion.jsf?faces-redirect=true";
    }
    
    public String insertQuestion(){
        return "";
    }
}
