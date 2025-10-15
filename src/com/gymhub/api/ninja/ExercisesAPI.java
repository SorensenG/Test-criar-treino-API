package com.gymhub.api.ninja;

import com.gymhub.api.DeepLTranslator.DeepLTranslator;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExercisesAPI {
    static final String key = "b5rCo+FkZu7nL+P88O6KWg==nVqxJjMZZ0UEqdJk";

    static String getExercise(String namePt, String musclePt, String typePt, String difficultyPt) throws IOException, InterruptedException {

        try {

            DeepLTranslator translator = new DeepLTranslator();

            String name = (namePt == null || namePt.isBlank()) ? "" : namePt;
            String muscle = (musclePt == null || musclePt.isBlank()) ? "" : musclePt;
            String type = (typePt == null || typePt.isBlank()) ? "" : typePt;
            String difficulty = (difficultyPt == null || difficultyPt.isBlank()) ? "" : difficultyPt;
            // ja ta tudo em ingles

            Map<String,String> q = new LinkedHashMap<>();

            if (!name.isBlank() && name != null) q.put("name", translator.translate(name));
            if (!muscle.isBlank() && muscle != null) q.put("muscle", translator.translate(muscle));
            if (!type.isBlank() && type != null) q.put("type", translator.translate(type));
            if (!difficulty.isBlank() && difficulty != null) q.put("difficulty", translator.translate(difficulty));


            StringBuilder query = new StringBuilder();
            var first = true;
            for (var e : q.entrySet()) {
                if (!first) query.append('&'); first = false;
                query.append(URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8))
                        .append('=')
                        .append(URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8));
            }



            var uri = URI.create(
                    "https://api.api-ninjas.com/v1/exercises?name=press&muscle=chest&type=strength&difficulty=intermediate"
            );
            var req = HttpRequest.newBuilder(uri)
                    .header("X-Api-Key", key)
                    .GET()
                    .build();
            var client = HttpClient.newHttpClient();
            var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println(resp.body());




            return resp.body();

        }catch (IOException | InterruptedException e) {
            return "Erro ao buscar exercicio " + e.getMessage();

        } catch (Exception e){
            return "Erro ao buscar exercicio "+ e.getMessage();
        }

        }



}
