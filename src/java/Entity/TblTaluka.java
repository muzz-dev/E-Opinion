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
@Table(name = "tbl_taluka")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTaluka.findAll", query = "SELECT t FROM TblTaluka t"),
    @NamedQuery(name = "TblTaluka.findByTalukaId", query = "SELECT t FROM TblTaluka t WHERE t.talukaId = :talukaId"),
    @NamedQuery(name = "TblTaluka.findByDistrictId", query = "SELECT t FROM TblTaluka t WHERE t.districtId = :districtId"),
    @NamedQuery(name = "TblTaluka.findByIsactive", query = "SELECT t FROM TblTaluka t WHERE t.isactive = :isactive")})
public class TblTaluka implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taluka_id")
    private Integer talukaId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "taluka_name")
    private String talukaName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @ManyToMany(mappedBy = "tblTalukaCollection")
    private Collection<TblQuestion> tblQuestionCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private TblDistrict districtId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talukaId")
    private Collection<TblVillage> tblVillageCollection;

    public TblTaluka() {
    }

    public TblTaluka(Integer talukaId) {
        this.talukaId = talukaId;
    }

    public TblTaluka(Integer talukaId, String talukaName) {
        this.talukaId = talukaId;
        this.talukaName = talukaName;
    }

    public Integer getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Integer talukaId) {
        this.talukaId = talukaId;
    }

    public String getTalukaName() {
        return talukaName;
    }

    public void setTalukaName(String talukaName) {
        this.talukaName = talukaName;
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

    public TblDistrict getDistrictId() {
        return districtId;
    }

    public void setDistrictId(TblDistrict districtId) {
        this.districtId = districtId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblVillage> getTblVillageCollection() {
        return tblVillageCollection;
    }

    public void setTblVillageCollection(Collection<TblVillage> tblVillageCollection) {
        this.tblVillageCollection = tblVillageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talukaId != null ? talukaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTaluka)) {
            return false;
        }
        TblTaluka other = (TblTaluka) object;
        if ((this.talukaId == null && other.talukaId != null) || (this.talukaId != null && !this.talukaId.equals(other.talukaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblTaluka[ talukaId=" + talukaId + " ]";
    }
    
}
