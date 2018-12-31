package com.example.testspringboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class Application implements CommandLineRunner{
	private static final Logger LGR = LogManager.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
	        LGR.debug("Debugging log");
	        LGR.info("Info log");
	        LGR.warn("Hey, This is a warning!");
	        LGR.error("Oops! We have an Error. OK");
	        LGR.fatal("Damn! Fatal error. Please fix me.");
	}

}
