package services;

import infra.Error;
import models.Pay;
import models.Transaction;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PaymentService {

    public Transaction pay(Pay pay) {
        validate(pay);
        Transaction response = new Transaction();
        response.setId(UUID.randomUUID());
        response.setDiscountValue(pay.getTransactionValue() - (pay.getTransactionValue() * 0.05));
        String date = YearMonth.parse(pay.getExpirationDate(), DateTimeFormatter.ofPattern("MM/yyyy")) //
                .format(DateTimeFormatter.ofPattern("MM/yyyy")).toString();
        response.setExpirationDate(date != null ? date : "");
        response.setLastCardDigits(pay.getNumber().substring(6));
        response.setName(pay.getName());
        response.setClientValue(pay.getTransactionValue());
        return response;
    }

    private void validate(Pay pay) {
        if (pay.getNumber() == null) {
            throw new Error(400, "Número do cartão é obrigatório");
        }
        String number = pay.getNumber().replace("-", "").replace(".", "");
        try {
            Long.parseLong(number);
        } catch (Exception e) {
            throw new Error(400, "Número do cartão de crédito inválido");
        }
        if (!number.startsWith("4") || number.length() != 16) {
            throw new Error(400, "Cartão de crédito não é da bandeira Visa");
        }
        if (pay.getName() == null || pay.getName().isEmpty()) {
            throw new Error(400, "Nome é obrigatório");
        }
        if (pay.getTransactionValue() == null || pay.getTransactionValue() < 0) {
            throw new Error(400, "Valor da transação inválido");
        }
        try {
            if (pay.getExpirationDate() == null) {
                throw new Error(400, "Data de expiração é obrigatório");
            }
            YearMonth.parse(pay.getExpirationDate(), DateTimeFormatter.ofPattern("MM/yyyy")) //
                    .format(DateTimeFormatter.ofPattern("MM/yyyy")).toString();
        } catch (Exception e) {
            throw new Error(400, "Data de expiração do cartão de crédito inválida");
        }
    }
}
