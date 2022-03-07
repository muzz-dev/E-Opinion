package Entity;

import Entity.TblQuestion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-07T17:19:57")
@StaticMetamodel(TblQuestionType.class)
public class TblQuestionType_ { 

    public static volatile SingularAttribute<TblQuestionType, String> isactive;
    public static volatile SingularAttribute<TblQuestionType, String> typeName;
    public static volatile SingularAttribute<TblQuestionType, Integer> questionTypeId;
    public static volatile CollectionAttribute<TblQuestionType, TblQuestion> tblQuestionCollection;

}