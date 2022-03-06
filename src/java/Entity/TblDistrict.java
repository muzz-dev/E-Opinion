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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_district")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDistrict.findAll", query = "SELECT t FROM TblDistrict t"),
    @NamedQuery(name = "TblDistrict.findByDistrictId", query = "SELECT t FROM TblDistrict t WHERE t.districtId = :districtId"),
    @NamedQuery(name = "TblDistrict.findByStateId", query = "SELECT t FROM TblDistrict t WHERE t.stateId = :stateId"),
    @NamedQuery(name = "TblDistrict.findByIsactive", query = "SELECT t FROM TblDistrict t WHERE t.isactive = :isactive")})
public class TblDistrict implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "district_id")
    private Integer districtId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "district_name")
    private String districtName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @JoinTable(name = "tbl_ques_district", joinColumns = {
        @JoinColumn(name = "district_id", referencedColumnName = "district_id")}, inverseJoinColumns = {
        @JoinColumn(name = "question_id", referencedColumnName = "question_id")})
    @ManyToMany
    private Collection<TblQuestion> tblQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "districtId")
    private Collection<TblTaluka> tblTalukaCollection;
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    @ManyToOne(optional = false)
    private TblState stateId;

    public TblDistrict() {
    }

    public TblDistrict(Integer districtId) {
        this.districtId = districtId;
    }

    public TblDistrict(Integer districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
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
    public Collection<TblTaluka> getTblTalukaCollection() {
        return tblTalukaCollection;
    }

    public void setTblTalukaCollection(Collection<TblTaluka> tblTalukaCollection) {
        this.tblTalukaCollection = tblTalukaCollection;
    }

    public TblState getStateId() {
        return stateId;
    }

    public void setStateId(TblState stateId) {
        this.stateId = stateId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (districtId != null ? districtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDistrict)) {
            return false;
        }
        TblDistrict other = (TblDistrict) object;
        if ((this.districtId == null && other.districtId != null) || (this.districtId != null && !this.districtId.equals(other.districtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblDistrict[ districtId=" + districtId + " ]";
    }

}
