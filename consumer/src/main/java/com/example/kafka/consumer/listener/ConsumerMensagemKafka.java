package com.example.kafka.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Service
public class ConsumerMensagemKafka {

    private final Logger logger = LoggerFactory.getLogger(ConsumerMensagemKafka.class);

    @KafkaListener(topics = "${topic.spring-kafka}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Consumindo mensagem {}", message));
    }
}
