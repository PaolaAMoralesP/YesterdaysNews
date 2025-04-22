package com.yesterdaysnews.yesterdaysnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class YesterdaysnewsApplication {

	public static void main(String[] args) {
		boolean hasErrors = false;

		try {

			Dotenv dotenv = Dotenv.configure().load();

			checkEnvVariable(dotenv, "SPRING_DATASOURCE_URL");
			checkEnvVariable(dotenv, "SPRING_DATASOURCE_USERNAME");
			checkEnvVariable(dotenv, "SPRING_DATASOURCE_PASSWORD");
			checkEnvVariable(dotenv, "SPRING_DATASOURCE_DRIVER_CLASS_NAME");

			System.setProperty("SPRING_DATASOURCE_URL", dotenv.get("SPRING_DATASOURCE_URL"));
			System.setProperty("SPRING_DATASOURCE_USERNAME", dotenv.get("SPRING_DATASOURCE_USERNAME"));
			System.setProperty("SPRING_DATASOURCE_PASSWORD", dotenv.get("SPRING_DATASOURCE_PASSWORD"));
			System.setProperty("SPRING_DATASOURCE_DRIVER_CLASS_NAME",
					dotenv.get("SPRING_DATASOURCE_DRIVER_CLASS_NAME"));

			System.out.println("\u001B[34m>>>>>>>>>>Database connection properties loaded successfully.\u001B[0m");

		} catch (Exception e) {

			System.err.println("\u001B[33m>>>>>>>>>>Warning: Issue detected while starting Yesterdaysnews application: "
					+ e.getMessage() + "\u001B[0m");
			e.printStackTrace();
			hasErrors = true;
		}

		SpringApplication.run(YesterdaysnewsApplication.class, args);

		if (hasErrors) {
			System.out.println("\u001B[33m>>>>>>>>>>Yesterdaysnews application started with warnings.\u001B[0m");
		} else {
			System.out.println("\u001B[32m>>>>>>>>>>Yesterdaysnews application started successfully!\u001B[0m");
		}
	}

	private static void checkEnvVariable(Dotenv dotenv, String key) {
		if (dotenv.get(key) == null || dotenv.get(key).isEmpty()) {
			throw new IllegalArgumentException(">>>>>>>>>>Missing required environment variable: " + key);
		}
	}
}
