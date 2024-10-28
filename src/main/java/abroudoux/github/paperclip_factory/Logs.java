package abroudoux.github.paperclip_factory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Logs {
    @KafkaListener(topics = "notification-topic", groupId = "paperclip-factory-group")
    protected void logMessage(String message) {
        System.out.println("Log: " + message);
    }
 }