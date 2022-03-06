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
@Table(name = "tbl_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblZone.findAll", query = "SELECT t FROM TblZone t"),
    @NamedQuery(name = "TblZone.findByVillageId", query = "SELECT t FROM TblZone t WHERE t.villageId = :villageId"),
    @NamedQuery(name = "TblZone.findByZoneId", query = "SELECT t FROM TblZone t WHERE t.zoneId = :zoneId"),
    @NamedQuery(name = "TblZone.findByIsactive", query = "SELECT t FROM TblZone t WHERE t.isactive = :isactive")})
public class TblZone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zone_id")
    private Integer zoneId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "zone_name")
    private String zoneName;
    @Size(max = 1)
    @Column(name = "Isactive")
    private String isactive;
    @ManyToMany(mappedBy = "tblZoneCollection")
    private Collection<TblQuestion> tblQuestionCollection;
    @JoinColumn(name = "village_id", referencedColumnName = "village_id")
    @ManyToOne(optional = false)
    private TblVillage villageId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneId")
    private Collection<TblWard> tblWardCollection;

    public TblZone() {
    }

    public TblZone(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public TblZone(Integer zoneId, String zoneName) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
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

    public TblVillage getVillageId() {
        return villageId;
    }

    public void setVillageId(TblVillage villageId) {
        this.villageId = villageId;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblWard> getTblWardCollection() {
        return tblWardCollection;
    }

    public void setTblWardCollection(Collection<TblWard> tblWardCollection) {
        this.tblWardCollection = tblWardCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zoneId != null ? zoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblZone)) {
            return false;
        }
        TblZone other = (TblZone) object;
        if ((this.zoneId == null && other.zoneId != null) || (this.zoneId != null && !this.zoneId.equals(other.zoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblZone[ zoneId=" + zoneId + " ]";
    }
    
}
