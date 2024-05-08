package com.joaovpimenta.ai.gemini.controller;

import com.joaovpimenta.ai.gemini.clients.GeminiClient;
import com.joaovpimenta.ai.gemini.records.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/ai")
public class GeminiController {

    private static final Logger log = Logger.getLogger(GeminiController.class.getName());
    private final GeminiClient geminiClient;

    @PostMapping("/ask")
    public ResponseEntity<Object> askQuestion(@RequestBody Prompt prompt) {
        return ResponseEntity.ok().body(geminiClient.ask(prompt));
    }

//
//    Ser claro nas instruções: fornecer instruções específicas e detalhadas para orientar o modelo.
//    Dar uma persona para o modelo: atribuir uma identidade ou papel específico para o modelo, como "agente de marketing".
//    Dividir tarefas maiores em tarefas menores: quebrar tarefas complexas em etapas menores para interagir com o modelo.
//    Pedir justificativas para as respostas do modelo: solicitar explicações e razões por trás das respostas geradas.
//    Few-shot prompting: fornecer vários exemplos da tarefa a ser realizada para que o modelo compreenda o contexto e tom desejados.
//    Chain of thought prompting: pedir ao modelo para pensar passo a passo, justificando suas respostas e combinando com o few-shot para elaborar um prompt mais eficaz.
//    Least-to-most prompting e self-consistency: técnicas mais avançadas mencionadas na aula, mas não aprofundadas.
//

    public GeminiController(@Autowired GeminiClient geminiClient) {
        this.geminiClient = geminiClient;
    }
}
