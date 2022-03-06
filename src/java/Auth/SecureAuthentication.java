/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auth;

import Admin.AdminSessionBeanLocal;
import ManagedBeans.LoginManagedBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Record.KeepRecord;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author muzz
 */
@Named
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {

    @Inject
    IdentityStoreHandler handler;
    CredentialValidationResult result;
    AuthenticationStatus status;
    @Inject
    LoginManagedBean lbean;
    @EJB
    AdminSessionBeanLocal asb;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            if (lbean.getUsername() != null) {
                String username = lbean.getUsername();
                String password = lbean.getPassword();
                Credential credential = new UsernamePasswordCredential(username, new Password(password));
                result = handler.validate(credential);

                if (result.getStatus() == CredentialValidationResult.Status.VALID) {

                    status = httpMessageContext.notifyContainerAboutLogin(result);
                    KeepRecord.setUsername(username);
                    KeepRecord.setPassword(password);
                    KeepRecord.setPrincipal(result.getCallerPrincipal());
                    KeepRecord.setRoles(result.getCallerGroups());
                    KeepRecord.setUserId(asb.getUserIdfromUsername(username));
                    System.out.println(KeepRecord.getUserId());
                    System.out.println(result.getCallerGroups());
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    session.setAttribute("username", username);
                    session.setAttribute("userId", asb.getUserIdfromUsername(username));
                    
                    
                    lbean.setUsername(username);
                    lbean.setStatus(status);
                    lbean.setRoles(result.getCallerGroups());
//                    System.out.println(result.getCallerGroups());
                    return status;

                } else {
                    lbean.setErrorstatus("User or Password is not correct !");
                    lbean.setStatus(AuthenticationStatus.SEND_FAILURE);
                    return status;
                    // request.getServletContext().getRequestDispatcher("/Login.jsf").forward(request, response);
                }
            }
        } catch (Exception e) {

        }
        return httpMessageContext.doNothing();
    }

    @Override
    public AuthenticationStatus secureResponse(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) throws AuthenticationException {
        return HttpAuthenticationMechanism.super.secureResponse(request, response, httpMessageContext); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cleanSubject(HttpServletRequest request, HttpServletResponse response, HttpMessageContext httpMessageContext) {
        HttpAuthenticationMechanism.super.cleanSubject(request, response, httpMessageContext); //To change body of generated methods, choose Tools | Templates.
    }
}
