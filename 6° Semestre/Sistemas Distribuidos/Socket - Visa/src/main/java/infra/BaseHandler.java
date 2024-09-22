package infra;

public class BaseHandler implements Controller {
    public String healthCheck() {
        return "200 OK";
    }
}
