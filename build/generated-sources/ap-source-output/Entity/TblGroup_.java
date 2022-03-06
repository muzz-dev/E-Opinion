package Entity;

import Entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:14")
@StaticMetamodel(TblGroup.class)
public class TblGroup_ { 

    public static volatile SingularAttribute<TblGroup, String> groupName;
    public static volatile CollectionAttribute<TblGroup, TblUser> tblUserCollection;
    public static volatile SingularAttribute<TblGroup, Integer> groupId;

}