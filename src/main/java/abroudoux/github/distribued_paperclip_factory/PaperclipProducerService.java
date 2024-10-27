package abroudoux.github.distribued_paperclip_factory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PaperclipProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private int paperclipCount = 0;

    public PaperclipProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public int getPaperclipCount() {
        return this.paperclipCount;
    }

    @Scheduled(fixedRate = 5000)
    public void createPaperclip() {
        this.paperclipCount++;
        kafkaTemplate.send("paperclip-topic", "Paperclip count: " + this.getPaperclipCount());
    }
}