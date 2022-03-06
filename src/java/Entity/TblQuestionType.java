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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_question_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblQuestionType.findAll", query = "SELECT t FROM TblQuestionType t"),
    @NamedQuery(name = "TblQuestionType.findByQuestionTypeId", query = "SELECT t FROM TblQuestionType t WHERE t.questionTypeId = :questionTypeId"),
    @NamedQuery(name = "TblQuestionType.findByIsactive", query = "SELECT t FROM TblQuestionType t WHERE t.isactive = :isactive")})
public class TblQuestionType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_type_id")
    private Integer questionTypeId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "type_name")
    private String typeName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "isactive")
    private String isactive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionTypeId")
    private Collection<TblQuestion> tblQuestionCollection;

    public TblQuestionType() {
    }

    public TblQuestionType(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public TblQuestionType(Integer questionTypeId, String typeName, String isactive) {
        this.questionTypeId = questionTypeId;
        this.typeName = typeName;
        this.isactive = isactive;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblQuestion> getTblQuestionCollection() {
        return tblQuestionCollection;
    }

    public void setTblQuestionCollection(Collection<TblQuestion> tblQuestionCollection) {
        this.tblQuestionCollection = tblQuestionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionTypeId != null ? questionTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQuestionType)) {
            return false;
        }
        TblQuestionType other = (TblQuestionType) object;
        if ((this.questionTypeId == null && other.questionTypeId != null) || (this.questionTypeId != null && !this.questionTypeId.equals(other.questionTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblQuestionType[ questionTypeId=" + questionTypeId + " ]";
    }
    
}
