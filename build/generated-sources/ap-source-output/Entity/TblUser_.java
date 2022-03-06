package Entity;

import Entity.TblCast;
import Entity.TblGroup;
import Entity.TblQuestionAnswer;
import Entity.TblWard;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:15")
@StaticMetamodel(TblUser.class)
public class TblUser_ { 

    public static volatile SingularAttribute<TblUser, String> isblock;
    public static volatile CollectionAttribute<TblUser, TblGroup> tblGroupCollection;
    public static volatile SingularAttribute<TblUser, String> address;
    public static volatile SingularAttribute<TblUser, String> gender;
    public static volatile SingularAttribute<TblUser, String> mobileNumber;
    public static volatile SingularAttribute<TblUser, TblCast> castId;
    public static volatile SingularAttribute<TblUser, String> userFullName;
    public static volatile SingularAttribute<TblUser, String> emailId;
    public static volatile SingularAttribute<TblUser, TblWard> wardId;
    public static volatile SingularAttribute<TblUser, String> userName;
    public static volatile SingularAttribute<TblUser, Integer> userId;
    public static volatile SingularAttribute<TblUser, String> religion;
    public static volatile SingularAttribute<TblUser, String> password;
    public static volatile SingularAttribute<TblUser, String> aadharNumber;
    public static volatile CollectionAttribute<TblUser, TblQuestionAnswer> tblQuestionAnswerCollection;

}