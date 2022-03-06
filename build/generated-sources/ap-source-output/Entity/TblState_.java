package Entity;

import Entity.TblDistrict;
import Entity.TblQuestion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:14")
@StaticMetamodel(TblState.class)
public class TblState_ { 

    public static volatile SingularAttribute<TblState, String> stateName;
    public static volatile SingularAttribute<TblState, Integer> stateId;
    public static volatile SingularAttribute<TblState, String> isactive;
    public static volatile CollectionAttribute<TblState, TblDistrict> tblDistrictCollection;
    public static volatile CollectionAttribute<TblState, TblQuestion> tblQuestionCollection;

}