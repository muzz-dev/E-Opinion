package Entity;

import Entity.TblQuestion;
import Entity.TblTaluka;
import Entity.TblZone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:14")
@StaticMetamodel(TblVillage.class)
public class TblVillage_ { 

    public static volatile SingularAttribute<TblVillage, TblTaluka> talukaId;
    public static volatile SingularAttribute<TblVillage, String> isactive;
    public static volatile CollectionAttribute<TblVillage, TblZone> tblZoneCollection;
    public static volatile SingularAttribute<TblVillage, String> villageName;
    public static volatile SingularAttribute<TblVillage, Integer> villageId;
    public static volatile CollectionAttribute<TblVillage, TblQuestion> tblQuestionCollection;

}