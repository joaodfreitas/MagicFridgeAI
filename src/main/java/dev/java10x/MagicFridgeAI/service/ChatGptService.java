package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.FoodItem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ChatGptService {

    private final WebClient webClient;
    private String apiKey = System.getenv("OPENAI_API_KEY");

    public ChatGptService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> generateRecipe(List<FoodItem> fooditems) {

        String alimentos = fooditems.stream()
                .map(item -> String.format("%s (%s) - Quantidade: %d, Validade: %s",
                        item.getNome(), item.getCategoria() ,item.getQuantidade(), item.getValidade()))
                .collect(Collectors.joining("\n"));

        String prompt = "Baseado no meu banco de dados faça uma receita com os seguintes itens: " + alimentos;

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-5.5",
                "input", List.of(
                        Map.of(
                                "role", "system",
                                "content", "Você é um assistente que cria receitas"
                        ),
                        Map.of(
                                "role", "user",
                                "content", prompt
                        )
                )
        );

        return webClient.post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response -> {

                    var output = (List<Map<String, Object>>) response.get("output");

                    if (output != null && !output.isEmpty()) {

                        var content = (List<Map<String, Object>>) output.get(0).get("content");

                        if (content != null && !content.isEmpty()) {

                            return content.get(0).get("text").toString();
                        }
                    }

                    return "Nenhuma receita foi gerada.";
                });
    }

    }

