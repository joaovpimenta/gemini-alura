package com.joaovpimenta.ai.gemini.records;

//public class GenerationConfig {
//    public static final int temperature = 1;
//    public static final int topK = 0;
//    public static final double topP = 0.95;
//    public static final int maxOutputTokens = 8192;
//
//    public static final Object[] stopSequences = {};
//
//}

public record GenerationConfig(int temperature, int topK, double topP, int maxOutputTokens, Object[] stopSequences){}