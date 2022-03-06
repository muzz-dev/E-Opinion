/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "tbl_qualification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblQualification.findAll", query = "SELECT t FROM TblQualification t"),
    @NamedQuery(name = "TblQualification.findByQualificationId", query = "SELECT t FROM TblQualification t WHERE t.qualificationId = :qualificationId"),
    @NamedQuery(name = "TblQualification.findByIsactive", query = "SELECT t FROM TblQualification t WHERE t.isactive = :isactive")})
public class TblQualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "qualification_id")
    private Integer qualificationId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "qualification_name")
    private String qualificationName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @JoinTable(name = "tbl_ques_qualification", joinColumns = {
        @JoinColumn(name = "qualification_id", referencedColumnName = "qualification_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")})
    @ManyToMany
    private Collection<TblQuestion> tblQuestionCollection;

    public TblQualification() {
    }

    public TblQualification(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public TblQualification(Integer qualificationId, String qualificationName) {
        this.qualificationId = qualificationId;
        this.qualificationName = qualificationName;
    }

    public Integer getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Integer qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getQualificationName() {
        return qualificationName;
    }

    public void setQualificationName(String qualificationName) {
        this.qualificationName = qualificationName;
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
        hash += (qualificationId != null ? qualificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblQualification)) {
            return false;
        }
        TblQualification other = (TblQualification) object;
        if ((this.qualificationId == null && other.qualificationId != null) || (this.qualificationId != null && !this.qualificationId.equals(other.qualificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblQualification[ qualificationId=" + qualificationId + " ]";
    }
    
}
