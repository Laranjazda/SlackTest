package com.example.SlackTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SlackTestApplication {
	public static void main(String[] args) throws ClassNotFoundException {
//		SpringApplication.run(SlackTestApplication.class, args);
//		MongoConnection mongo = new MongoConnection();
//		mongo.connectionsDB();
//
//		SlackConnection slack = new SlackConnection();
//		slack.connectionsSlask();

		Scrips run = new Scrips();
		run.InsertListData();
	}
}
