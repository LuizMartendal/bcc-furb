package controllers;

import com.google.gson.Gson;
import infra.BaseHandler;
import infra.Controller;
import models.Card;

public class CardController extends BaseHandler implements Controller {
    public Object createCard(String cardJson) {
        Card card = new Gson().fromJson(cardJson, Card.class);
        return card;
    }
}
