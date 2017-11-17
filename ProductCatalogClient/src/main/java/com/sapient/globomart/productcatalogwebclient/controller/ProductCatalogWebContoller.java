package com.sapient.globomart.productcatalogwebclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

	
/**
 * @author Manishkumar
 * @since 08/15/2017.
 */

@RestController
public class ProductCatalogWebContoller {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	public static String PRODUCT_CATALOG_SERVICE = "http://PRODUCTCATALOGSERVICE";
	
	@GetMapping("/productCatalog")
	public String getProductsFromCatalog(){
		return restTemplate.getForObject(PRODUCT_CATALOG_SERVICE+"/catalog/products",String.class);
		//return Arrays.asList(productArray);
	}
}
