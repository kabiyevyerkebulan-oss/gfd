package com.exam;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.io.InputStream;

public class MyServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/candidates", new CandidatesHandler());

        server.setExecutor(null);
        System.out.println("Сервер запущен на http://localhost:8080/candidates");
        server.start();
    }

    static class CandidatesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            CandidateDAO dao = new CandidateDAO();
            Gson gson = new Gson();
            String response = "";

            // Если пришел POST запрос
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                // Читаем то, что ты написал в Postman (Body)
                InputStream is = exchange.getRequestBody();
                String body = new String(is.readAllBytes());

                // Превращаем текст в объект и сохраняем
                Candidate newCandidate = gson.fromJson(body, Candidate.class);
                dao.createCandidate(newCandidate);

                response = "{\"message\": \"com.exam.Candidate added successfully\"}";
                exchange.sendResponseHeaders(201, response.getBytes().length);
            }
            // Если пришел GET запрос (просто просмотр)
            else {
                List<Candidate> candidates = dao.getAllCandidates();
                response = gson.toJson(candidates);
                exchange.sendResponseHeaders(200, response.getBytes().length);
            }

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

