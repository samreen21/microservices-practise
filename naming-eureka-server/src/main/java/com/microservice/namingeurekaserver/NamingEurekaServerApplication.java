package com.microservice.namingeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingEurekaServerApplication.class, args);
	}

}
