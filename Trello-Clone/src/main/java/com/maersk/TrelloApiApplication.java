package com.maersk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class TrelloApiApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TrelloApiApplication.class, args);
	}
}
