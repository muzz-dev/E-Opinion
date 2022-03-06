/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "tbl_department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDepartment.findAll", query = "SELECT t FROM TblDepartment t"),
    @NamedQuery(name = "TblDepartment.findByDeptId", query = "SELECT t FROM TblDepartment t WHERE t.deptId = :deptId"),
    @NamedQuery(name = "TblDepartment.findByIsactive", query = "SELECT t FROM TblDepartment t WHERE t.isactive = :isactive")})
public class TblDepartment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dept_id")
    private Integer deptId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "dept_name")
    private String deptName;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;

    public TblDepartment() {
    }

    public TblDepartment(Integer deptId) {
        this.deptId = deptId;
    }

    public TblDepartment(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDepartment)) {
            return false;
        }
        TblDepartment other = (TblDepartment) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblDepartment[ deptId=" + deptId + " ]";
    }
    
}
