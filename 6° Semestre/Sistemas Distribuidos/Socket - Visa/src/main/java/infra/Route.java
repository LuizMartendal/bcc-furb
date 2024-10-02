package infra;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class Route {

    public Object route(String request, String object) {
        String[] parts = request.split(" ");
        String methodRequest = parts[0];
        String path = parts.length > 1 ? parts[1] : "index";

        Map<String, Controller> routes = Configurations.getRoutes();
        String basePath = path.split("/").length > 0 ? path.split("/")[1] : "baseHandler";
        String method =  path.split("/").length > 2 //
                ? path.split("/")[2].split("\\?").length > 0 ? path.split("/")[2].split("\\?")[0] : null //
                : "healthCheck";
        String params = path.split("/").length > 2 //
                ? path.split("/")[2].split("\\?").length > 1 ? path.split("/")[2].split("\\?")[1] : null //
                : null;
        Object controller = routes.get("/" + basePath);

        if (controller != null) {
            try {
                Method controllerMethod = null;
                if (object != null && !object.isEmpty()) {
                    controllerMethod = controller.getClass().getMethod(method, String.class);
                    return controllerMethod.invoke(controller, object);
                } else {
                    controllerMethod = controller.getClass().getMethod(method == null ? "healthCheck" : method);
                    return controllerMethod.invoke(controller);
                }
            } catch (NoSuchMethodException e) {
                return new Error(405, "Método não implementado");
            } catch (Error e) {
                return e;
            } catch (InvocationTargetException ite){
                if (ite.getCause().getMessage() != null && ((Error) ite.getCause()).getStatus() != null) {
                    return new Error(((Error) ite.getCause()).getStatus(), ite.getCause().getMessage());
                }
                return new Error(500, "Internal Error");
            } catch (Exception e) {
                return new Error(500, "Internal Error");
            }
        } else {
            return "404 Not Found: Controlador não encontrado";
        }
    }
}
