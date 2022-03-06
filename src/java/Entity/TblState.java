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
@Table(name = "tbl_state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblState.findAll", query = "SELECT t FROM TblState t"),
    @NamedQuery(name = "TblState.statecounts", query = "SELECT count(t.stateId) FROM TblState t"),
    @NamedQuery(name = "TblState.findByStateId", query = "SELECT t FROM TblState t WHERE t.stateId = :stateId"),
    @NamedQuery(name = "TblState.findByIsactive", query = "SELECT t FROM TblState t WHERE t.isactive = :isactive")})
public class TblState implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "state_name")
    private String stateName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @ManyToMany(mappedBy = "tblStateCollection")
    private Collection<TblQuestion> tblQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<TblDistrict> tblDistrictCollection;

    public TblState() {
    }

    public TblState(Integer stateId) {
        this.stateId = stateId;
    }

    public TblState(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
    public Collection<TblDistrict> getTblDistrictCollection() {
        return tblDistrictCollection;
    }

    public void setTblDistrictCollection(Collection<TblDistrict> tblDistrictCollection) {
        this.tblDistrictCollection = tblDistrictCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblState)) {
            return false;
        }
        TblState other = (TblState) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblState[ stateId=" + stateId + " ]";
    }
    
}
