package com.example.kafka.producer.service;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class MensagemService {

    private static final Logger logger = LoggerFactory.getLogger(MensagemService.class);

    @Value("${topic.spring-kafka}")
    private String topicSpringKafka;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MensagemService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(String message) {
        logger.info("Mensagem -> {}", message);
        this.kafkaTemplate.send(topicSpringKafka, message);
    }
}
