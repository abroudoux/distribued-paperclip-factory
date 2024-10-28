package abroudoux.github.paperclip_factory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Inventory {
    protected int paperclipsInventoryCount = 0;
    protected final KafkaTemplate<String, String> kafkaTemplate;

    public Inventory(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    protected int getPaperclipsInventoryCount() {
        return this.paperclipsInventoryCount;
    }

    protected void incrementPaperclipsInventoryCount() {
        this.paperclipsInventoryCount++;
    }

    @KafkaListener(topics = "production-topic", groupId = "paperclip-factory-group")
    protected void paperclipCreated(String message) {
        this.sendNotification(message);
        this.updatePaperclipsInventory();
    }

    protected void updatePaperclipsInventory() {
        this.incrementPaperclipsInventoryCount();
        this.kafkaTemplate.send("shop-topic", "Inventory updated: " + this.getPaperclipsInventoryCount());
    }

    @KafkaListener(topics = "shop-topic", groupId = "paperclip-factory-group")
    protected void sellPaperclips() {
        if (this.paperclipsInventoryCount >= 10) {
            this.sendNotification("10 Paperclips sold.");
            this.paperclipsInventoryCount -= 10;
        }
    }

    protected void sendNotification(String message) {
        this.kafkaTemplate.send("notification-topic", message);
    }
}