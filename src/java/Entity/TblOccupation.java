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
@Table(name = "tbl_occupation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblOccupation.findAll", query = "SELECT t FROM TblOccupation t"),
    @NamedQuery(name = "TblOccupation.findByOccupationId", query = "SELECT t FROM TblOccupation t WHERE t.occupationId = :occupationId"),
    @NamedQuery(name = "TblOccupation.findByIsactive", query = "SELECT t FROM TblOccupation t WHERE t.isactive = :isactive")})
public class TblOccupation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "occupation_id")
    private Integer occupationId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "occupation_name")
    private String occupationName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @JoinTable(name = "tbl_ques_occup", joinColumns = {
        @JoinColumn(name = "occpation_id", referencedColumnName = "occupation_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")})
    @ManyToMany
    private Collection<TblQuestion> tblQuestionCollection;

    public TblOccupation() {
    }

    public TblOccupation(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public TblOccupation(Integer occupationId, String occupationName) {
        this.occupationId = occupationId;
        this.occupationName = occupationName;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public String getOccupationName() {
        return occupationName;
    }

    public void setOccupationName(String occupationName) {
        this.occupationName = occupationName;
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
        hash += (occupationId != null ? occupationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOccupation)) {
            return false;
        }
        TblOccupation other = (TblOccupation) object;
        if ((this.occupationId == null && other.occupationId != null) || (this.occupationId != null && !this.occupationId.equals(other.occupationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblOccupation[ occupationId=" + occupationId + " ]";
    }
    
}
