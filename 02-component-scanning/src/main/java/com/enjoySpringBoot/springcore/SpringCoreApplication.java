package com.enjoySpringBoot.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Explicitly listing base packages to scan

@SpringBootApplication(
		scanBasePackages = {"com.enjoySpringBoot.springcore",
							"com.enjoySpringBoot.util"
							}
)
public class SpringCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreApplication.class, args);
	}

}
