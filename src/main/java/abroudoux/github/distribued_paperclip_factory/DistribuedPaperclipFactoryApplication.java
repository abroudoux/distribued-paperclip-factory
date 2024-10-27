package abroudoux.github.distribued_paperclip_factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DistribuedPaperclipFactoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DistribuedPaperclipFactoryApplication.class, args);
	}
}
