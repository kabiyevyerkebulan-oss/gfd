import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class MyServer {
    public static void main(String[] args) throws IOException {
        // Создаем сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Путь /candidates будет выводить всех кандидатов из БД
        server.createContext("/candidates", new CandidatesHandler());

        server.setExecutor(null);
        System.out.println("Сервер запущен на http://localhost:8080/candidates");
        server.start();
    }

    static class CandidatesHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            CandidateDAO dao = new CandidateDAO();
            // Нам нужен метод в DAO, который вернет список всех кандидатов
            List<Candidate> candidates = dao.getAllCandidates();

            Gson gson = new Gson();
            String jsonResponse = gson.toJson(candidates);

            // Настройка заголовков (чтобы браузер понял, что это JSON)
            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(jsonResponse.getBytes());
            os.close();
        }
    }

}