package infra;

import controllers.CardController;
import controllers.PaymentController;

import java.util.HashMap;
import java.util.Map;

public class Configurations {

    public static final int PORT = 8900;

    public static Map<String, Controller> getRoutes() {
        Map<String, Controller> routes = new HashMap<>();
        routes.put("/baseHandler", new BaseHandler());
        routes.put("/card", new CardController());
        routes.put("/payment", new PaymentController());
        return routes;
    }
}
