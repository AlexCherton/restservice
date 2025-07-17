package com.home.restservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic queue() {
        return new NewTopic("kafka_test", 1, (short) 1);
    }
}
