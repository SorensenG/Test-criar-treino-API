package com.gymhub.api.DeepLTranslator;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class DeepLTranslator implements Translator {
    private final String apiKey = "1b848aff-f6b1-4144-8da8-c4656fff0eec:fx";



    @Override
    public String translate(String textPt) throws Exception {
        if (textPt == null || textPt.isBlank()) return textPt;
        String form = "text=" + URLEncoder.encode(textPt, StandardCharsets.UTF_8)
                + "&source_lang=PT&target_lang=EN";

        HttpRequest req = HttpRequest.newBuilder(URI.create("https://api-free.deepl.com/v2/translate"))
                .header("Authorization", "DeepL-Auth-Key " + apiKey)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(form))
                .build();

        HttpResponse<String> res = HttpClient.newHttpClient()
                .send(req, HttpResponse.BodyHandlers.ofString());

        String body = res.body();
        int i = body.indexOf("\"text\":\"");
        if (i < 0) throw new RuntimeException("Resposta inesperada: " + body);
        int j = body.indexOf('"', i + 8);
        return (j > i) ? body.substring(i + 8, j) : textPt;
    }
    }

