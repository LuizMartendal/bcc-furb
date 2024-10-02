package models;

import java.io.Serializable;

public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String validDate;

    private String username;

    private String cvv;

    public Card() {
    }

    public Card(String code, String validDate, String username, String cvv) {
        this.code = code;
        this.validDate = validDate;
        this.username = username;
        this.cvv = cvv;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
