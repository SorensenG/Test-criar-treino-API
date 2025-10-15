package com.gymhub.api.ninja;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.gymhub.api.DeepLTranslator.DeepLTranslatorToEnglish;
import com.gymhub.Dtos.ExerciseDto;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ExercisesAPI {
    static final String key = "b5rCo+FkZu7nL+P88O6KWg==nVqxJjMZZ0UEqdJk";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Type LIST_TYPE = new TypeToken<List<ExerciseDto>>(){}.getType();

    public static List<ExerciseDto> getExercise(String namePt, String musclePt, String typePt, String difficultyPt) throws Exception {



            DeepLTranslatorToEnglish translator = new DeepLTranslatorToEnglish();

            String name = (namePt == null || namePt.isBlank()) ? "" : namePt;
            String muscle = (musclePt == null || musclePt.isBlank()) ? "" : musclePt;
            String type = (typePt == null || typePt.isBlank()) ? "" : typePt;
            String difficulty = (difficultyPt == null || difficultyPt.isBlank()) ? "" : difficultyPt;
            // ja ta tudo em ingles

            Map<String, String> q = new LinkedHashMap<>();

            if (!name.isBlank() && name != null) q.put("name", translator.translate(name));
            if (!muscle.isBlank() && muscle != null) q.put("muscle", translator.translate(muscle));
            if (!type.isBlank() && type != null) q.put("type", translator.translate(type));
            if (!difficulty.isBlank() && difficulty != null) q.put("difficulty", translator.translate(difficulty));


            StringBuilder query = new StringBuilder();
            var first = true;
            for (var e : q.entrySet()) {
                if (!first) query.append('&');
                first = false;
                query.append(URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8)).append('=').append(URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8));
            }

            URI uri = query.isEmpty() ? URI.create("https://api.api-ninjas.com/v1/exercises") : URI.create("https://api.api-ninjas.com/v1/exercises?" + query);


            var req = HttpRequest.newBuilder(uri).header("X-Api-Key", key).GET().build();
            var client = HttpClient.newHttpClient();
            var resp = client.send(req, HttpResponse.BodyHandlers.ofString());
            if (resp.statusCode() != 200) {
                throw new RuntimeException("API Ninjas HTTP " + resp.statusCode() + " - " + resp.body());
            }
            return GSON.fromJson(resp.body(), LIST_TYPE);

    }


}
