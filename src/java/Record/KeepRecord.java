/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Record;

import java.util.Set;
import javax.security.enterprise.CallerPrincipal;
import javax.security.enterprise.identitystore.CredentialValidationResult;

/**
 *
 * @author muzz
 */
public class KeepRecord {
    public static CredentialValidationResult result;
    public static CallerPrincipal principal;
    public static Set<String> roles;
    public static String username;
    public static String password;
    public static String userId;

    public static CredentialValidationResult getResult() {
        return result;
    }

    public static void setResult(CredentialValidationResult result) {
        KeepRecord.result = result;
    }

    public static CallerPrincipal getPrincipal() {
        return principal;
    }

    public static void setPrincipal(CallerPrincipal principal) {
        KeepRecord.principal = principal;
    }

    public static Set<String> getRoles() {
        return roles;
    }

    public static void setRoles(Set<String> roles) {
        KeepRecord.roles = roles;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        KeepRecord.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        KeepRecord.password = password;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        KeepRecord.userId = userId;
    }
    
    
}
