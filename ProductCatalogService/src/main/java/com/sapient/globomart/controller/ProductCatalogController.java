package com.sapient.globomart.controller;

import java.net.URI;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sapient.globomart.CustomErrorType;
import com.sapient.globomart.model.Product;
import com.sapient.globomart.service.ProductService;
import com.sapient.globomart.service.ProductServiceImpl;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@RestController
@RequestMapping("/catalog")
public class ProductCatalogController {
	Logger logger = Logger.getLogger(ProductCatalogController.class);

	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		product = service.addProduct(product);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable("productId") Integer productId){
		Product product = findProductById(productId);
		if(product==null){
            logger.error("Product with id"+ productId+" not found.");
            return new ResponseEntity(new CustomErrorType("Product with id " + productId 
                    + " not found"), HttpStatus.NOT_FOUND);
		}	
		service.deleteProduct(productId);
		logger.info("Product with id :  "+ productId +"deleted successfully.");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public Page<Product> list( Pageable pageable){
		Page<Product> persons = service.listAllByPage(pageable);
		return persons;
	} 
	
	@RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId){
		Product product = findProductById(productId);
		if(product==null){
            logger.error("Product with id"+ productId+" not found.");
            return new ResponseEntity(new CustomErrorType("Product with id " + productId 
                    + " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<Product>> findByProductType(@RequestParam("productType") String productType){
		return new ResponseEntity(service.findProductsByType(productType), HttpStatus.OK);
	}

	private Product findProductById(Integer productId) {
		return service.findProduct(productId);
	}
}
