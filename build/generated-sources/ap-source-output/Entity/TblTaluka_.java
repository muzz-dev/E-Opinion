package Entity;

import Entity.TblDistrict;
import Entity.TblQuestion;
import Entity.TblVillage;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:14")
@StaticMetamodel(TblTaluka.class)
public class TblTaluka_ { 

    public static volatile SingularAttribute<TblTaluka, TblDistrict> districtId;
    public static volatile SingularAttribute<TblTaluka, Integer> talukaId;
    public static volatile SingularAttribute<TblTaluka, String> isactive;
    public static volatile SingularAttribute<TblTaluka, String> talukaName;
    public static volatile CollectionAttribute<TblTaluka, TblVillage> tblVillageCollection;
    public static volatile CollectionAttribute<TblTaluka, TblQuestion> tblQuestionCollection;

}