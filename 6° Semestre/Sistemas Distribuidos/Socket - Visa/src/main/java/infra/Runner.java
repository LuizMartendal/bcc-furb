package infra;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;

public class Runner {

    public static void run(Route route) {
        try (ServerSocket serverSocket = new ServerSocket(Configurations.PORT)) {
            System.out.println("Servidor iniciado na porta " + Configurations.PORT);
            Gson gson = new Gson();

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    HashMap<String, String> headersMap = new HashMap<>();
                    HashMap<String, String> bodyParamsMap = new HashMap<>();

                    String requestLine = in.readLine();
                    if (requestLine != null && !requestLine.isEmpty()) {
                        System.out.println("Requisição recebida: " + requestLine);

                        String line;
                        while (!(line = in.readLine()).isEmpty()) {
                            String[] headerParts = line.split(": ", 2);
                            if (headerParts.length == 2) {
                                headersMap.put(headerParts[0], headerParts[1]);
                            }
                        }

                        System.out.println("Cabeçalhos HTTP: " + headersMap);

                        if (headersMap.containsKey("Content-Length")) {
                            int contentLength = Integer.parseInt(headersMap.get("Content-Length"));
                            char[] bodyChars = new char[contentLength];
                            int readLength = in.read(bodyChars, 0, contentLength);

                            if (readLength != contentLength) {
                                System.err.println("Erro ao ler o corpo da requisição: tamanho incorreto.");
                                continue;
                            }

                            String requestBody = new String(bodyChars);
                            System.out.println("Corpo da requisição: " + requestBody);

                            String[] params = requestBody.split("&");
                            for (String param : params) {
                                String[] paramParts = param.split("=", 2);
                                if (paramParts.length == 2) {
                                    bodyParamsMap.put(paramParts[0], paramParts[1]);
                                }
                            }
                            System.out.println("Parâmetros do corpo: " + bodyParamsMap);

                            Object responseObject = route.route(requestLine, requestBody);

                            String jsonResponse = gson.toJson(responseObject);
                            if (responseObject instanceof Error) {
                                out.println("HTTP/1.1 " + ((Error) responseObject).getStatus());
                                out.println("Content-Type: application/json");
                                out.println("Content-Length: " + jsonResponse.length());
                                out.println();
                                out.println(((Error) responseObject).getMessage());
                            } else {
                                out.println("HTTP/1.1 200 OK");
                                out.println("Content-Type: application/json");
                                out.println("Content-Length: " + jsonResponse.length());
                                out.println();
                                out.println(jsonResponse);
                            }
                        } else {
                            String jsonResponse = gson.toJson("Tudo funcionando!");
                            out.println("HTTP/1.1 200 OK");
                            out.println("Content-Type: application/json");
                            out.println("Content-Length: " + jsonResponse.length());
                            out.println();
                            out.println(jsonResponse);
                        }
                    }
                } catch (SocketException e) {
                    System.err.println("Erro de I/O na comunicação com o cliente: " + e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    System.err.println("Erro na leitura/escrita: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
