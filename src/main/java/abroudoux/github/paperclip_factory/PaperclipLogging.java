package abroudoux.github.paperclip_factory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaperclipLogging {
    @KafkaListener(topics = "notification-topic", groupId = "paperclip-logging-group")
    public void logPaperclipCreated(String message) {
        System.out.println("New operation: " + message);
    }
}