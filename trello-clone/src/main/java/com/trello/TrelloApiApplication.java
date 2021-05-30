package com.trello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TrelloApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TrelloApiApplication.class, args);
	}
}
