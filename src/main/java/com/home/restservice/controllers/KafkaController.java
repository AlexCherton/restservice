package com.home.restservice.controllers;

import com.home.restservice.service.KafkaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping("kafka/send")
        public String sendMessage(@RequestBody String message) {
        kafkaService.sendMessage(message);
            return "Success";
        }


}
