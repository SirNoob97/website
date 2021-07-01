package com.github.SirNoob97.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.SirNoob97.website")
public class WebSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSiteApplication.class, args);
	}

}
