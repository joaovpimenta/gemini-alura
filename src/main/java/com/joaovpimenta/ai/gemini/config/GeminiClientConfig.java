package com.joaovpimenta.ai.gemini.config;

import com.joaovpimenta.ai.gemini.clients.GeminiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.Duration;

@Configuration
public class GeminiClientConfig {

    private final String url;
    private final String geminiKey;

    public GeminiClientConfig(@Value("${api.url}") String url, @Value("${api.key}") String geminiKey) {
        this.url = url;
        this.geminiKey = geminiKey;
    }

    @Bean
    GeminiClient geminiClient() {
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .uriBuilderFactory(new DefaultUriBuilderFactory(uriComponentsBuilder()))
                .build();

        WebClientAdapter webClientAdapter = WebClientAdapter.create(client);
        webClientAdapter.setBlockTimeout(Duration.ofSeconds(7));

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder()
                .exchangeAdapter(webClientAdapter)
                .build();
        return factory.createClient(GeminiClient.class);
    }

    private UriComponentsBuilder uriComponentsBuilder() {
        return UriComponentsBuilder.fromHttpUrl(url).queryParam("key", geminiKey);
    }


}
