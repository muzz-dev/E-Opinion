/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBeans;

import Entity.TblQuestion;
import Record.KeepRecord;
import User.UserSessionBeanLocal;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@Named(value = "answerManagedBean")
@SessionScoped
public class AnswerManagedBean implements Serializable {

    Integer QuestionId, userId;
    String ans;
    @EJB
    UserSessionBeanLocal usb;
    TblQuestion currentQuestion;
    Integer id = parseInt(KeepRecord.userId);

    public TblQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(TblQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public Integer getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(Integer QuestionId) {
        this.QuestionId = QuestionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public UserSessionBeanLocal getUsb() {
        return usb;
    }

    public void setUsb(UserSessionBeanLocal usb) {
        this.usb = usb;
    }

    /**
     * Creates a new instance of AnswerManagedBean
     */
    public AnswerManagedBean() {
    }

    public String addanswer() {
//        System.out.println(ans + currentQuestion.getQuestionId() +userId );

        this.usb.Answer(currentQuestion.getQuestionId(), id, ans);
        ans = null;
        return "/UserSide/Feed.jsf?faces-redirect=true";
    }

    public Collection<TblQuestion> allQuestion() {
        return this.usb.findAllQuestion();
    }

}
