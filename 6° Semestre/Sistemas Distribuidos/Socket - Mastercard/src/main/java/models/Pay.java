package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Pay implements Serializable {

    private static final long serialVersionUID = 1L;

    private String number;
    private String name;
    private String expirationDate;
    private Double transactionValue;

    public Pay() {
    }

    public Pay(String number, String name, String expirationDate, Double transactionValue) {
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.transactionValue = transactionValue;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }
}
