package infra;

import java.lang.reflect.Method;
import java.util.Map;

public class Route {

    public String route(String request) {
        String[] parts = request.split(" "); // Simulação de uma requisição "path method"
        String path = parts[0];
        String method = parts.length > 1 ? parts[1] : "index";  // Se não for especificado, chama "index"

        // Extrai o caminho base (ex: /home)
        Map<String, Controller> routes = Configurations.getRoutes();
        String basePath = path.split("/")[1];
        Object controller = routes.get("/" + basePath);

        if (controller != null) {
            try {
                // Usa reflection para buscar o método dentro do controller
                Method controllerMethod = controller.getClass().getMethod(method);
                return (String) controllerMethod.invoke(controller);  // Executa o método dinamicamente
            } catch (NoSuchMethodException e) {
                return "404 Not Found: Método não encontrado";
            } catch (Exception e) {
                return "500 Internal Server Error: " + e.getMessage();
            }
        } else {
            return "404 Not Found: Controlador não encontrado";
        }
    }
}
