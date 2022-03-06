/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Admin.AdminSessionBeanLocal;
import Client.AdminClient;
import Client.UserClient;
import Entity.TblFeedback;
import User.UserSessionBeanLocal;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author muzz
 */
@Named(value = "feedbackManagedBean")
@SessionScoped
public class FeedbackManagedBean implements Serializable {

    @EJB
    private AdminSessionBeanLocal asb;
    
    @EJB UserSessionBeanLocal usb;

    AdminClient admin = new AdminClient();
    Response res;
    Collection<TblFeedback> feed;
    GenericType<Collection<TblFeedback>> gfeed;

    UserClient user = new UserClient();

    String username, emailId, Description;

    public Collection<TblFeedback> getFeed() {
        return feed;
    }

    public void setFeed(Collection<TblFeedback> feed) {
        this.feed = feed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Creates a new instance of FeedbackManagedBean
     */
    public FeedbackManagedBean() {
    }

    public Collection<TblFeedback> findallFeedback() {
//        return this.asb.findallFeedback();
        gfeed = new GenericType<Collection<TblFeedback>>() {
        };
        res = admin.findallFeedback(Response.class);
        feed = res.readEntity(gfeed);
        return feed;
    }

    public String addFeedback() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        Date today = Calendar.getInstance().getTime();
        String RegiDate = df.format(today);

        TblFeedback feedback = new TblFeedback();
        feedback.setUserName(this.username);
        feedback.setEmailId(this.emailId);
        feedback.setDescription(this.Description);
        feedback.setDate(RegiDate);
        feedback.setIsactive("Y");
          System.out.println(username + emailId + Description);  
        this.usb.AddFeedback(feedback);
//        this.user.AddFeedback(feedback);
        return "/UserSide/Feed.jsf?faces-redirect=true";
    }
}
