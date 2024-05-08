package com.joaovpimenta.ai.gemini.records;

import java.util.ArrayList;

public record Content(String role, ArrayList<Part> parts) {
}
