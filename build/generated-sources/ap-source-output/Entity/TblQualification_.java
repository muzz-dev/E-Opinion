package Entity;

import Entity.TblQuestion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-06T20:48:14")
@StaticMetamodel(TblQualification.class)
public class TblQualification_ { 

    public static volatile SingularAttribute<TblQualification, Integer> qualificationId;
    public static volatile SingularAttribute<TblQualification, String> isactive;
    public static volatile SingularAttribute<TblQualification, String> qualificationName;
    public static volatile CollectionAttribute<TblQualification, TblQuestion> tblQuestionCollection;

}