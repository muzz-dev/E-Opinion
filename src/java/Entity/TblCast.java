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
@Table(name = "tbl_cast")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCast.findAll", query = "SELECT t FROM TblCast t"),
    @NamedQuery(name = "TblCast.findByCastId", query = "SELECT t FROM TblCast t WHERE t.castId = :castId"),
    @NamedQuery(name = "TblCast.findByIsactive", query = "SELECT t FROM TblCast t WHERE t.isactive = :isactive")})
public class TblCast implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cast_id")
    private Integer castId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "cast_name")
    private String castName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @JoinTable(name = "tbl_ques_cast", joinColumns = {
        @JoinColumn(name = "cast_id", referencedColumnName = "cast_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")})
    @ManyToMany
    private Collection<TblQuestion> tblQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "castId")
    private Collection<TblUser> tblUserCollection;

    public TblCast() {
    }

    public TblCast(Integer castId) {
        this.castId = castId;
    }

    public TblCast(Integer castId, String castName) {
        this.castId = castId;
        this.castName = castName;
    }

    public Integer getCastId() {
        return castId;
    }

    public void setCastId(Integer castId) {
        this.castId = castId;
    }

    public String getCastName() {
        return castName;
    }

    public void setCastName(String castName) {
        this.castName = castName;
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

    @XmlTransient
    @JsonbTransient
    public Collection<TblUser> getTblUserCollection() {
        return tblUserCollection;
    }

    public void setTblUserCollection(Collection<TblUser> tblUserCollection) {
        this.tblUserCollection = tblUserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (castId != null ? castId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCast)) {
            return false;
        }
        TblCast other = (TblCast) object;
        if ((this.castId == null && other.castId != null) || (this.castId != null && !this.castId.equals(other.castId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblCast[ castId=" + castId + " ]";
    }

}
