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
@Table(name = "tbl_ward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblWard.findAll", query = "SELECT t FROM TblWard t"),
    @NamedQuery(name = "TblWard.findByWardId", query = "SELECT t FROM TblWard t WHERE t.wardId = :wardId"),
    @NamedQuery(name = "TblWard.findByZoneId", query = "SELECT t FROM TblWard t WHERE t.zoneId = :zoneId"),
    @NamedQuery(name = "TblWard.findByIsactive", query = "SELECT t FROM TblWard t WHERE t.isactive = :isactive")})
public class TblWard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ward_id")
    private Integer wardId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ward_name")
    private String wardName;
    @Size(max = 1)
    @Column(name = "Isactive")
    private String isactive;
    @ManyToMany(mappedBy = "tblWardCollection")
    private Collection<TblQuestion> tblQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wardId")
    private Collection<TblUser> tblUserCollection;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private TblZone zoneId;

    public TblWard() {
    }

    public TblWard(Integer wardId) {
        this.wardId = wardId;
    }

    public TblWard(Integer wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
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

    public TblZone getZoneId() {
        return zoneId;
    }

    public void setZoneId(TblZone zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardId != null ? wardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblWard)) {
            return false;
        }
        TblWard other = (TblWard) object;
        if ((this.wardId == null && other.wardId != null) || (this.wardId != null && !this.wardId.equals(other.wardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblWard[ wardId=" + wardId + " ]";
    }
    
}
