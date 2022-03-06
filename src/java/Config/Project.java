/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author muzz
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/eopinion",
        callerQuery = "select password from tbl_user where user_name = ?",
        groupsQuery = "select g.group_name from tbl_group as g left join user_group as ug on g.group_id=ug.group_id left join tbl_user as u on u.user_id=ug.user_id where u.user_name = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)

@ApplicationScoped
public class Project {
    
}