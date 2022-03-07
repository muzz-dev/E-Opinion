package Entity;

import Entity.TblQuestion;
import Entity.TblUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-07T17:19:57")
@StaticMetamodel(TblQuestionAnswer.class)
public class TblQuestionAnswer_ { 

    public static volatile SingularAttribute<TblQuestionAnswer, TblQuestion> queId;
    public static volatile SingularAttribute<TblQuestionAnswer, String> optionC;
    public static volatile SingularAttribute<TblQuestionAnswer, String> optionD;
    public static volatile SingularAttribute<TblQuestionAnswer, String> optionA;
    public static volatile SingularAttribute<TblQuestionAnswer, String> optionB;
    public static volatile SingularAttribute<TblQuestionAnswer, Integer> queAnswerId;
    public static volatile SingularAttribute<TblQuestionAnswer, TblUser> userId;

}