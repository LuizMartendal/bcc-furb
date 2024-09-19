package models;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private String name;
    private String lastCardDigits;
    private String expirationDate;
    private Double clientValue;
    private Double discountValue;

    public Transaction() {
    }

    public Transaction(UUID id, String name, String lastCardDigits, String expirationDate, Double clientValue, Double discountValue) {
        this.id = id;
        this.name = name;
        this.lastCardDigits = lastCardDigits;
        this.expirationDate = expirationDate;
        this.clientValue = clientValue;
        this.discountValue = discountValue;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastCardDigits() {
        return lastCardDigits;
    }

    public void setLastCardDigits(String lastCardDigits) {
        this.lastCardDigits = lastCardDigits;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getClientValue() {
        return clientValue;
    }

    public void setClientValue(Double clientValue) {
        this.clientValue = clientValue;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }
}
