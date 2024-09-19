package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    public Card() {
    }

    public Card(String code, LocalDate validDate, String username, String cvv) {
        this.code = code;
        this.validDate = validDate;
        this.username = username;
        this.cvv = cvv;
    }

    private String code;

    private LocalDate validDate;

    private String username;

    private String cvv;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
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
