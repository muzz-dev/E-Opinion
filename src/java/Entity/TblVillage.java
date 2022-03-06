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
@Table(name = "tbl_village")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblVillage.findAll", query = "SELECT t FROM TblVillage t"),
    @NamedQuery(name = "TblVillage.findByTalukaId", query = "SELECT t FROM TblVillage t WHERE t.talukaId = :talukaId"),
    @NamedQuery(name = "TblVillage.findByVillageId", query = "SELECT t FROM TblVillage t WHERE t.villageId = :villageId"),
    @NamedQuery(name = "TblVillage.findByIsactive", query = "SELECT t FROM TblVillage t WHERE t.isactive = :isactive")})
public class TblVillage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "village_id")
    private Integer villageId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "village_name")
    private String villageName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;
    @ManyToMany(mappedBy = "tblVillageCollection")
    private Collection<TblQuestion> tblQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "villageId")
    private Collection<TblZone> tblZoneCollection;
    @JoinColumn(name = "taluka_id", referencedColumnName = "taluka_id")
    @ManyToOne(optional = false)
    private TblTaluka talukaId;

    public TblVillage() {
    }

    public TblVillage(Integer villageId) {
        this.villageId = villageId;
    }

    public TblVillage(Integer villageId, String villageName) {
        this.villageId = villageId;
        this.villageName = villageName;
    }

    public Integer getVillageId() {
        return villageId;
    }

    public void setVillageId(Integer villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
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
    public Collection<TblZone> getTblZoneCollection() {
        return tblZoneCollection;
    }

    public void setTblZoneCollection(Collection<TblZone> tblZoneCollection) {
        this.tblZoneCollection = tblZoneCollection;
    }

    public TblTaluka getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(TblTaluka talukaId) {
        this.talukaId = talukaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villageId != null ? villageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblVillage)) {
            return false;
        }
        TblVillage other = (TblVillage) object;
        if ((this.villageId == null && other.villageId != null) || (this.villageId != null && !this.villageId.equals(other.villageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblVillage[ villageId=" + villageId + " ]";
    }
    
}
