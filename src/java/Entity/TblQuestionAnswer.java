/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_question_answer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblQuestionAnswer.findAll", query = "SELECT t FROM TblQuestionAnswer t"),
    //Mayam
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionId", query = "SELECT t FROM TblQuestionAnswer t WHERE t.queId.questionId = :queId"),
    @NamedQuery(name = "TblQuestionAnswer.findByUserAndQuestionId", query = "SELECT t FROM TblQuestionAnswer t WHERE t.userId.userId = :userId and t.queId.questionId = :questionId"),
    //Muzz
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionType", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionTypeAndState", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId AND t.userId.wardId.zoneId.villageId.talukaId.districtId.stateId.stateId = :stateId"),
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionTypeAndDist", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId AND t.userId.wardId.zoneId.villageId.talukaId.districtId.districtId = :districtId"),
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionTypeAndTal", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId AND t.userId.wardId.zoneId.villageId.talukaId.talukaId = :talukaId"),
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionTypeAndVil", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId AND t.userId.wardId.zoneId.villageId.villageId = :villageId"),
    @NamedQuery(name = "TblQuestionAnswer.findByQuestionTypeAndZone", query = "SELECT t FROM TblQuestionAnswer t where t.queId.questionTypeId.questionTypeId = :quetypeId AND t.userId.wardId.zoneId.zoneId = :zoneId"),
    @NamedQuery(name = "TblQuestionAnswer.countByStateId", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.zoneId.villageId.talukaId.districtId.stateId.stateId = :stateId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.countByDistId", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.zoneId.villageId.talukaId.districtId.districtId = :districtId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.countBytalukas", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.zoneId.villageId.talukaId.talukaId = :talukaId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.countByvillages", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.zoneId.villageId.villageId = :villageId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.countByzones", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.zoneId.zoneId = :zoneId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    @NamedQuery(name = "TblQuestionAnswer.countBywards", query = "SELECT t FROM TblQuestionAnswer t where t.userId.wardId.wardId = :wardId and t.queId.questionTypeId.questionTypeId = :quetypeId"),
    //End
    @NamedQuery(name = "TblQuestionAnswer.findByQueAnswerId", query = "SELECT t FROM TblQuestionAnswer t WHERE t.queAnswerId = :queAnswerId")})
public class TblQuestionAnswer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "que_answer_id")
    private Integer queAnswerId;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_a")
    private String optionA;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_b")
    private String optionB;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_c")
    private String optionC;
    @Lob
    @Size(max = 65535)
    @Column(name = "option_d")
    private String optionD;
    @JoinColumn(name = "que_id", referencedColumnName = "question_id")
    @ManyToOne(optional = false)
    private TblQuestion queId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TblUser userId;

    public TblQuestionAnswer() {
    }

    public TblQuestionAnswer(Integer queAnswerId) {
        this.queAnswerId = queAnswerId;
    }

    public Integer getQueAnswerId() {
        return queAnswerId;
    }

    public void setQueAnswerId(Integer queAnswerId) {
        this.queAnswerId = queAnswerId;
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

    public TblQuestion getQueId() {
        return queId;
    }

    public void setQueId(TblQuestion queId) {
        this.queId = queId;
    }

    public TblUser getUserId() {
        return userId;
    }

    public void setUserId(TblUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (queAnswerId != null ? queAnswerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQuestionAnswer)) {
            return false;
        }
        TblQuestionAnswer other = (TblQuestionAnswer) object;
        if ((this.queAnswerId == null && other.queAnswerId != null) || (this.queAnswerId != null && !this.queAnswerId.equals(other.queAnswerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblQuestionAnswer[ queAnswerId=" + queAnswerId + " ]";
    }
    
}
