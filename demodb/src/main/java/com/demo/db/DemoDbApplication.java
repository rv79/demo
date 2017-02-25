package com.demo.db;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableNeo4jRepositories
@EnableMongoRepositories
public class DemoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDbApplication.class, args);
	}
}
