/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PRREDETOR
 */
public class UserError {
    private String userIDERROR;
    private String fullnamERROR;
    private String addressERROR;
    private String phoneERROR;
    private String emailERROR;
    private String passwordERROR;
    private String confirmERROR;

    public UserError() {
    }

    public UserError(String userIDERROR, String fullnamERROR, String addressERROR, String phoneERROR, String emailERROR, String passwordERROR, String confirmERROR) {
        this.userIDERROR = userIDERROR;
        this.fullnamERROR = fullnamERROR;
        this.addressERROR = addressERROR;
        this.phoneERROR = phoneERROR;
        this.emailERROR = emailERROR;
        this.passwordERROR = passwordERROR;
        this.confirmERROR = confirmERROR;
    }

    public String getUserIDERROR() {
        return userIDERROR;
    }

    public void setUserIDERROR(String userIDERROR) {
        this.userIDERROR = userIDERROR;
    }

    public String getFullnamERROR() {
        return fullnamERROR;
    }

    public void setFullnamERROR(String fullnamERROR) {
        this.fullnamERROR = fullnamERROR;
    }

    public String getAddressERROR() {
        return addressERROR;
    }

    public void setAddressERROR(String addressERROR) {
        this.addressERROR = addressERROR;
    }

    public String getPhoneERROR() {
        return phoneERROR;
    }

    public void setPhoneERROR(String phoneERROR) {
        this.phoneERROR = phoneERROR;
    }

    public String getEmailERROR() {
        return emailERROR;
    }

    public void setEmailERROR(String emailERROR) {
        this.emailERROR = emailERROR;
    }

    public String getPasswordERROR() {
        return passwordERROR;
    }

    public void setPasswordERROR(String passwordERROR) {
        this.passwordERROR = passwordERROR;
    }

    public String getConfirmERROR() {
        return confirmERROR;
    }

    public void setConfirmERROR(String confirmERROR) {
        this.confirmERROR = confirmERROR;
    }

    
}
