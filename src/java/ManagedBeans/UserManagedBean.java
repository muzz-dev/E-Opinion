/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Entity.TblCast;
import Entity.TblUser;
import Entity.TblWard;
import User.UserSessionBeanLocal;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author HP
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable{

    @EJB
    UserSessionBeanLocal usb;
    
    @EJB AdminSessionBeanLocal asb;
    
    EntityManager em;

    Integer userId, wardid, castid;
    String userName, password, userfullname, aadharnumber, mobilenumber, emailid, religion, address, gender, isblock;
    
    Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();
    
    public UserSessionBeanLocal getUsb() {
        return usb;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setUsb(UserSessionBeanLocal usb) {
        this.usb = usb;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWardid() {
        return wardid;
    }

    public void setWardid(Integer wardid) {
        this.wardid = wardid;
    }

    public Integer getCastid() {
        return castid;
    }

    public void setCastid(Integer castid) {
        this.castid = castid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserfullname() {
        return userfullname;
    }

    public void setUserfullname(String userfullname) {
        this.userfullname = userfullname;
    }

    public String getAadharnumber() {
        return aadharnumber;
    }

    public void setAadharnumber(String aadharnumber) {
        this.aadharnumber = aadharnumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsblock() {
        return isblock;
    }

    public void setIsblock(String isblock) {
        this.isblock = isblock;
    }

    /**
     * Creates a new instance of UserManagedBean
     */
    public UserManagedBean() {
    }
    public void HelloWorld(){
        System.out.println("Hello");
    }
    public String Register(){
        TblCast cast = new TblCast();
        TblWard ward = new TblWard();
        ward.setWardId(wardid);
        cast.setCastId(castid);
        TblUser user = new TblUser();
        user.setUserName(userName);
        user.setUserFullName(userfullname);
        user.setPassword(pb.generate(password.toCharArray()));
        user.setAddress(address);
        user.setAadharNumber(aadharnumber);
        user.setMobileNumber(mobilenumber);
        user.setEmailId(emailid);
        user.setReligion(religion);
        user.setGender(gender);
        user.setWardId(ward);
        user.setCastId(cast);
        user.setIsblock("N");
        this.usb.Registration(user);
        return "index.jsf?faces-redirect=true";
    }
    
    public Collection<TblUser> alluser(){
      return this.asb.findAllUser();
    }

}
