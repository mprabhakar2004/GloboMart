package com.sapient.globomart.productcatalogwebclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductCatalogWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogWebClientApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
