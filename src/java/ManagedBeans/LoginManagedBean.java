/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Set;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author muzz
 */
@Named(value = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {

    @Inject
    SecurityContext ctx;

    private String username;
    private String password;
    private Set<String> roles;
    private String errorstatus;
    private AuthenticationStatus status;

    /**
     * Creates a new instance of LoginManagedBean
     */
    public LoginManagedBean() {
    }

    public SecurityContext getCtx() {
        return ctx;
    }

    public void setCtx(SecurityContext ctx) {
        this.ctx = ctx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getErrorstatus() {
        return errorstatus;
    }

    public void setErrorstatus(String errorstatus) {
        this.errorstatus = errorstatus;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String login() {
        System.out.println(username);
        System.out.println(password);
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            AuthenticationStatus mystatus = ctx.authenticate(request, response, withParams().credential(credential));
            //AuthenticationStatus     mystatus= AuthenticationStatus.SUCCESS;
            if (mystatus.equals(SEND_CONTINUE)) {
                // Authentication mechanism has send a redirect, should not
                // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
                context.responseComplete();
            }

            if (status.equals(SUCCESS)) {
                if (roles.contains("Admin")) {
                    session.setAttribute("userType", "Admin");
                    return "/AdminSide/Dashboard.jsf?faces-redirect=true";
                } else if (roles.contains("User")) {
                    session.setAttribute("userType", "User");
                    return "/UserSide/Feed.jsf?faces-redirect=true";
                }
            } else {
                return "/index.jsf";
            }

        } catch (Exception e) {
            errorstatus = "User Name or Password may be wrong";
            e.printStackTrace();
        }
        return "/index.jsf";
    }

//    public String logout() {
//        System.out.println("In Log out");
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        session.setAttribute("userId", "");
//        session.setAttribute("userId", "");
//        session.setAttribute("userId", "");
//        session.invalidate();
//        return "/../index.jsf";
//
//    }

}
