import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


        System.out.println("Bem vindo ao seu programa de treino!");
        System.out.println("Digite 1 para criar um treino personalizado.");
        System.out.println("Digite 2 para sair.");
        System.out.println("Digite 3 para ver os exercicios disponiveis.");


        var key = "b5rCo+FkZu7nL+P88O6KWg==nVqxJjMZZ0UEqdJk";
        var uri = URI.create(
                "https://api.api-ninjas.com/v1/exercises?name=&muscle=&type=&difficulty="
        );
        var req = HttpRequest.newBuilder(uri)
                .header("X-Api-Key", key)
                .GET()
                .build();
        var client = HttpClient.newHttpClient();
        var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println(resp.body());






    }

}
