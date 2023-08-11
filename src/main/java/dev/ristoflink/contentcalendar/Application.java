package dev.ristoflink.contentcalendar;

import dev.ristoflink.contentcalendar.config.ContentCalendarProperties;
import dev.ristoflink.contentcalendar.model.Content;
import dev.ristoflink.contentcalendar.model.Status;
import dev.ristoflink.contentcalendar.model.Type;
import dev.ristoflink.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository){
		return args -> {
			//great place to do some bootstrapping so this is where we insert data to the database
			Content c = new Content( null,
					"Hello, welcome to my blog",
					"Entering the exciting world of Spring!",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					"");

			repository.save(c);
		};
	}

}
