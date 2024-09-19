package controllers;

import com.google.gson.Gson;
import infra.BaseHandler;
import infra.Controller;
import models.Pay;
import models.Transaction;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.regex.Pattern;

public class CardController extends BaseHandler implements Controller {

    public Object pay(String entity) {
        Pay pay = new Gson().fromJson(entity, Pay.class);
        Transaction response = new Transaction();
        response.setId(UUID.randomUUID());
        response.setDiscountValue(pay.getTransactionValue() - (pay.getTransactionValue() * 0.05));
        String date = pay.getExpirationDate() != null ? YearMonth.parse(pay.getExpirationDate(), DateTimeFormatter.ofPattern("MM/yyyy")) //
                .format(DateTimeFormatter.ofPattern("MM/yyyy")).toString() : null;
        response.setExpirationDate(date != null ? date : "");
        response.setLastCardDigits(pay.getNumber().substring(6));
        response.setName(pay.getName());
        response.setClientValue(pay.getTransactionValue());
        return response;
    }
}
