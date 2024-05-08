package com.joaovpimenta.ai.gemini.records;

import java.util.LinkedList;
import java.util.List;

public record Prompt(LinkedList<Content> contents, GenerationConfig generationConfig, List<SafetySetting> safetySettings) {
}
