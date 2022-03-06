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
@Table(name = "tbl_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUser.findAll", query = "SELECT t FROM TblUser t"),
    @NamedQuery(name = "TblUser.findByUsername", query = "SELECT t FROM TblUser t WHERE t.userName = :username"),
    @NamedQuery(name = "TblUser.findByUserId", query = "SELECT t FROM TblUser t WHERE t.userId = :userId"),
    @NamedQuery(name = "TblUser.findByIsblock", query = "SELECT t FROM TblUser t WHERE t.isblock = :isblock")})
public class TblUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_name")
    private String userName;
    @Lob
    @Size(max = 65535)
    @Column(name = "password")
    private String password;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_full_name")
    private String userFullName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "aadhar_number")
    private String aadharNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "religion")
    private String religion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "gender")
    private String gender;
    @Size(max = 1)
    @Column(name = "isblock")
    private String isblock;
    @JoinTable(name = "user_group", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id")})
    @ManyToMany
    private Collection<TblGroup> tblGroupCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<TblQuestionAnswer> tblQuestionAnswerCollection;
    @JoinColumn(name = "cast_id", referencedColumnName = "cast_id")
    @ManyToOne(optional = false)
    private TblCast castId;
    @JoinColumn(name = "ward_id", referencedColumnName = "ward_id")
    @ManyToOne(optional = false)
    private TblWard wardId;

    public TblUser() {
    }

    public TblUser(Integer userId) {
        this.userId = userId;
    }

    public TblUser(Integer userId, String aadharNumber, String mobileNumber, String emailId, String religion, String address, String gender) {
        this.userId = userId;
        this.aadharNumber = aadharNumber;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.religion = religion;
        this.address = address;
        this.gender = gender;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsblock() {
        return isblock;
    }

    public void setIsblock(String isblock) {
        this.isblock = isblock;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblGroup> getTblGroupCollection() {
        return tblGroupCollection;
    }

    public void setTblGroupCollection(Collection<TblGroup> tblGroupCollection) {
        this.tblGroupCollection = tblGroupCollection;
    }

    @XmlTransient
    @JsonbTransient
    public Collection<TblQuestionAnswer> getTblQuestionAnswerCollection() {
        return tblQuestionAnswerCollection;
    }

    public void setTblQuestionAnswerCollection(Collection<TblQuestionAnswer> tblQuestionAnswerCollection) {
        this.tblQuestionAnswerCollection = tblQuestionAnswerCollection;
    }

    public TblCast getCastId() {
        return castId;
    }

    public void setCastId(TblCast castId) {
        this.castId = castId;
    }

    public TblWard getWardId() {
        return wardId;
    }

    public void setWardId(TblWard wardId) {
        this.wardId = wardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUser)) {
            return false;
        }
        TblUser other = (TblUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblUser[ userId=" + userId + " ]";
    }
    
}
