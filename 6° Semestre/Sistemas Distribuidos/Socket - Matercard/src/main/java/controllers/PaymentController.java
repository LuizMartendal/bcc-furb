package controllers;

import com.google.gson.Gson;
import infra.BaseHandler;
import infra.Controller;
import models.Pay;
import models.Transaction;
import services.PaymentService;
import utils.Mapper;

public class PaymentController extends BaseHandler implements Controller {

    private PaymentService paymentService = new PaymentService();

    public Transaction pay(String requestBody) {
        return paymentService.pay(Mapper.jsonToObject(requestBody, Pay.class));
    }
}
