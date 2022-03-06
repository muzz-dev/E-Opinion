/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_question")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblQuestion.findAll", query = "SELECT t FROM TblQuestion t"),
    @NamedQuery(name = "TblQuestion.findByIdLast", query = "SELECT t FROM TblQuestion t order by t.questionId desc"),
    @NamedQuery(name = "TblQuestion.findByQuestionId", query = "SELECT t FROM TblQuestion t WHERE t.questionId = :questionId"),
    @NamedQuery(name = "TblQuestion.findByIsActive", query = "SELECT t FROM TblQuestion t WHERE t.isActive = :isActive")})
public class TblQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id")
    private Integer questionId;
    @Lob
    @Size(max = 65535)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "state")
    private String state;
    @Lob
    @Size(max = 65535)
    @Column(name = "district")
    private String district;
    @Lob
    @Size(max = 65535)
    @Column(name = "taluka")
    private String taluka;
    @Lob
    @Size(max = 65535)
    @Column(name = "village")
    private String village;
    @Lob
    @Size(max = 65535)
    @Column(name = "zone")
    private String zone;
    @Lob
    @Size(max = 65535)
    @Column(name = "ward")
    private String ward;
    @Lob
    @Size(max = 65535)
    @Column(name = "cast")
    private String cast;
    @Lob
    @Size(max = 65535)
    @Column(name = "qualification")
    private String qualification;
    @Lob
    @Size(max = 65535)
    @Column(name = "occupation")
    private String occupation;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_A")
    private String optionA;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_B")
    private String optionB;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_C")
    private String optionC;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_D")
    private String optionD;
    @Lob
    @Size(max = 65535)
    @Column(name = "date")
    private String date;
    @Size(max = 1)
    @Column(name = "isActive")
    private String isActive;
    @JoinTable(name = "tbl_ques_taluka", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")})
    @ManyToMany
    private Collection<TblTaluka> tblTalukaCollection;
    @JoinTable(name = "tbl_ques_ward", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")})
    @ManyToMany
    private Collection<TblWard> tblWardCollection;
    @ManyToMany(mappedBy = "tblQuestionCollection")
    private Collection<TblOccupation> tblOccupationCollection;
    @JoinTable(name = "tbl_ques_village", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "village_id", referencedColumnName = "village_id")})
    @ManyToMany
    private Collection<TblVillage> tblVillageCollection;
    @ManyToMany(mappedBy = "tblQuestionCollection")
    private Collection<TblDistrict> tblDistrictCollection;
    @JoinTable(name = "tbl_ques_state", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "state_id", referencedColumnName = "state_id")})
    @ManyToMany
    private Collection<TblState> tblStateCollection;
    @ManyToMany(mappedBy = "tblQuestionCollection")
    private Collection<TblQualification> tblQualificationCollection;
    @JoinTable(name = "tbl_ques_zone", joinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")}, inverseJoinColumns = {
        @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")})
    @ManyToMany
    private Collection<TblZone> tblZoneCollection;
    @ManyToMany(mappedBy = "tblQuestionCollection")
    private Collection<TblCast> tblCastCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "queId")
    private Collection<TblQuestionAnswer> tblQuestionAnswerCollection;
    @JoinColumn(name = "question_type_id", referencedColumnName = "question_type_id")
    @ManyToOne(optional = false)
    private TblQuestionType questionTypeId;

    public TblQuestion() {
    }

    public TblQuestion(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblTaluka> getTblTalukaCollection() {
        return tblTalukaCollection;
    }

    public void setTblTalukaCollection(Collection<TblTaluka> tblTalukaCollection) {
        this.tblTalukaCollection = tblTalukaCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblWard> getTblWardCollection() {
        return tblWardCollection;
    }

    public void setTblWardCollection(Collection<TblWard> tblWardCollection) {
        this.tblWardCollection = tblWardCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblOccupation> getTblOccupationCollection() {
        return tblOccupationCollection;
    }

    public void setTblOccupationCollection(Collection<TblOccupation> tblOccupationCollection) {
        this.tblOccupationCollection = tblOccupationCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblVillage> getTblVillageCollection() {
        return tblVillageCollection;
    }

    public void setTblVillageCollection(Collection<TblVillage> tblVillageCollection) {
        this.tblVillageCollection = tblVillageCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblDistrict> getTblDistrictCollection() {
        return tblDistrictCollection;
    }

    public void setTblDistrictCollection(Collection<TblDistrict> tblDistrictCollection) {
        this.tblDistrictCollection = tblDistrictCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblState> getTblStateCollection() {
        return tblStateCollection;
    }

    public void setTblStateCollection(Collection<TblState> tblStateCollection) {
        this.tblStateCollection = tblStateCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblQualification> getTblQualificationCollection() {
        return tblQualificationCollection;
    }

    public void setTblQualificationCollection(Collection<TblQualification> tblQualificationCollection) {
        this.tblQualificationCollection = tblQualificationCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblZone> getTblZoneCollection() {
        return tblZoneCollection;
    }

    public void setTblZoneCollection(Collection<TblZone> tblZoneCollection) {
        this.tblZoneCollection = tblZoneCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblCast> getTblCastCollection() {
        return tblCastCollection;
    }

    public void setTblCastCollection(Collection<TblCast> tblCastCollection) {
        this.tblCastCollection = tblCastCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblQuestionAnswer> getTblQuestionAnswerCollection() {
        return tblQuestionAnswerCollection;
    }

    public void setTblQuestionAnswerCollection(Collection<TblQuestionAnswer> tblQuestionAnswerCollection) {
        this.tblQuestionAnswerCollection = tblQuestionAnswerCollection;
    }

    public TblQuestionType getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(TblQuestionType questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQuestion)) {
            return false;
        }
        TblQuestion other = (TblQuestion) object;
        if ((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblQuestion[ questionId=" + questionId + " ]";
    }
    
}
