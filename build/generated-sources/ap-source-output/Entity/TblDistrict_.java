package Entity;

import Entity.TblQuestion;
import Entity.TblState;
import Entity.TblTaluka;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-07T17:19:57")
@StaticMetamodel(TblDistrict.class)
public class TblDistrict_ { 

    public static volatile CollectionAttribute<TblDistrict, TblTaluka> tblTalukaCollection;
    public static volatile SingularAttribute<TblDistrict, Integer> districtId;
    public static volatile SingularAttribute<TblDistrict, String> districtName;
    public static volatile SingularAttribute<TblDistrict, String> isactive;
    public static volatile SingularAttribute<TblDistrict, TblState> stateId;
    public static volatile CollectionAttribute<TblDistrict, TblQuestion> tblQuestionCollection;

}