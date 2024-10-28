package abroudoux.github.paperclip_factory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PaperclipProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaperclipProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void createPaperclip() {
        kafkaTemplate.send("paperclip-topic", "Paperclip created");
    }
}