package abroudoux.github.distribued_paperclip_factory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaperclipLoggingService {
    private int paperclipCount = 0;

    public int getPaperclipCount() {
        return this.paperclipCount;
    }

    @KafkaListener(topics = "paperclip-topic", groupId = "paperclip-logging-group")
    public void logPaperclip(String message) {
        this.paperclipCount++;
        System.out.println("Received: " + message + " | Total paperclips: " + this.getPaperclipCount());
    }
}