package Entity;

import Entity.TblCast;
import Entity.TblDistrict;
import Entity.TblOccupation;
import Entity.TblQualification;
import Entity.TblQuestionAnswer;
import Entity.TblQuestionType;
import Entity.TblState;
import Entity.TblTaluka;
import Entity.TblVillage;
import Entity.TblWard;
import Entity.TblZone;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-03-07T17:19:57")
@StaticMetamodel(TblQuestion.class)
public class TblQuestion_ { 

    public static volatile SingularAttribute<TblQuestion, String> date;
    public static volatile SingularAttribute<TblQuestion, Integer> questionId;
    public static volatile SingularAttribute<TblQuestion, String> occupation;
    public static volatile CollectionAttribute<TblQuestion, TblState> tblStateCollection;
    public static volatile CollectionAttribute<TblQuestion, TblWard> tblWardCollection;
    public static volatile CollectionAttribute<TblQuestion, TblZone> tblZoneCollection;
    public static volatile SingularAttribute<TblQuestion, String> description;
    public static volatile CollectionAttribute<TblQuestion, TblDistrict> tblDistrictCollection;
    public static volatile SingularAttribute<TblQuestion, String> ward;
    public static volatile SingularAttribute<TblQuestion, String> title;
    public static volatile SingularAttribute<TblQuestion, String> isActive;
    public static volatile SingularAttribute<TblQuestion, TblQuestionType> questionTypeId;
    public static volatile CollectionAttribute<TblQuestion, TblVillage> tblVillageCollection;
    public static volatile SingularAttribute<TblQuestion, String> cast;
    public static volatile SingularAttribute<TblQuestion, String> zone;
    public static volatile CollectionAttribute<TblQuestion, TblQuestionAnswer> tblQuestionAnswerCollection;
    public static volatile SingularAttribute<TblQuestion, String> state;
    public static volatile SingularAttribute<TblQuestion, String> village;
    public static volatile CollectionAttribute<TblQuestion, TblCast> tblCastCollection;
    public static volatile SingularAttribute<TblQuestion, String> optionC;
    public static volatile SingularAttribute<TblQuestion, String> optionD;
    public static volatile SingularAttribute<TblQuestion, String> optionA;
    public static volatile SingularAttribute<TblQuestion, String> optionB;
    public static volatile SingularAttribute<TblQuestion, String> qualification;
    public static volatile CollectionAttribute<TblQuestion, TblTaluka> tblTalukaCollection;
    public static volatile SingularAttribute<TblQuestion, String> district;
    public static volatile SingularAttribute<TblQuestion, String> taluka;
    public static volatile CollectionAttribute<TblQuestion, TblQualification> tblQualificationCollection;
    public static volatile CollectionAttribute<TblQuestion, TblOccupation> tblOccupationCollection;

}