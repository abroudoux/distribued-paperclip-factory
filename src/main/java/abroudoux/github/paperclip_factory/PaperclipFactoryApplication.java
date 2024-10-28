package abroudoux.github.paperclip_factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PaperclipFactoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(PaperclipFactoryApplication.class, args);
	}
}
