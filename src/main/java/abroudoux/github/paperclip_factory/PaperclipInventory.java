package abroudoux.github.paperclip_factory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaperclipInventory {
    private int paperclipsCount = 0;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaperclipInventory(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public int getPaperclipsCount() {
        return this.paperclipsCount;
    }

    @KafkaListener(topics = "paperclip-topic", groupId = "paperclip-logging-group")
    public void getPaperClipProduction() {
        this.paperclipsCount++;
        this.sendNotification();
    }

    public void sendNotification() {
        this.kafkaTemplate.send("notification-topic", "Paperclip created, paperclips count: " + this.getPaperclipsCount());
    }
}