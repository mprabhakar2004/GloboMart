package com.sapient.globomart.globomartserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@EnableEurekaServer
@SpringBootApplication
public class GlobomartServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobomartServiceRegistryApplication.class, args);
	}
}
