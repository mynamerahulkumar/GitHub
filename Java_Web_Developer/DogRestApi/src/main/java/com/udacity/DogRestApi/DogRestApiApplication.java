package com.udacity.DogRestApi;

import com.udacity.DogRestApi.utility.Joke;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class DogRestApiApplication {
	//private  static final Logger logger= (Logger) LoggerFactory.getLogger(DogRestApiApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DogRestApiApplication.class, args);
	}
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder){
//		return  builder.build();
//	}
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate){
//		return args -> {
//			Joke joke=restTemplate.getForObject(
//					"https://official-joke-api.appspot.com/random_joke",Joke.class);
//			logger.info(joke.toString());
//		};
//	}



}
