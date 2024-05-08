package com.joaovpimenta.ai.gemini.clients;

import com.joaovpimenta.ai.gemini.records.Prompt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Map;

public interface GeminiClient {

    @PostExchange("/v1beta/models/gemini-1.5-pro-latest:generateContent")
    Map<String, Object> ask(@RequestBody Prompt request);

}
