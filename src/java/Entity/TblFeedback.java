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
@Table(name = "tbl_feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblFeedback.findAll", query = "SELECT t FROM TblFeedback t"),
    @NamedQuery(name = "TblFeedback.findByFeedbackId", query = "SELECT t FROM TblFeedback t WHERE t.feedbackId = :feedbackId"),
    @NamedQuery(name = "TblFeedback.findByIsactive", query = "SELECT t FROM TblFeedback t WHERE t.isactive = :isactive")})
public class TblFeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "feedback_id")
    private Integer feedbackId;
    @Lob
    @Size(max = 65535)
    @Column(name = "user_name")
    private String userName;
    @Lob
    @Size(max = 65535)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "date")
    private String date;
    @Size(max = 1)
    @Column(name = "isactive")
    private String isactive;

    public TblFeedback() {
    }

    public TblFeedback(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public TblFeedback(Integer feedbackId, String description) {
        this.feedbackId = feedbackId;
        this.description = description;
    }

    public Integer getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Integer feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        hash += (feedbackId != null ? feedbackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFeedback)) {
            return false;
        }
        TblFeedback other = (TblFeedback) object;
        if ((this.feedbackId == null && other.feedbackId != null) || (this.feedbackId != null && !this.feedbackId.equals(other.feedbackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TblFeedback[ feedbackId=" + feedbackId + " ]";
    }
    
}
