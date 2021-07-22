package com.vidyutsathi.feedback;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.vidyutsathi")
@EnableAutoConfiguration
@EnableMongoRepositories({"com.vidyutsathi.repository"})
@EntityScan
public class FeedbackMain {


	public static void main(String[] args) {
		SpringApplication.run(FeedbackMain.class, args);
	}


}

