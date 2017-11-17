package com.sapient.globomart.builder;

import com.sapient.globomart.model.Product;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
public class ProductBuilder {
	Product product = new Product();
	
	public ProductBuilder id(int id){
		product.setId(id);
		return this;
	}
	
	public ProductBuilder name(String name){
		product.setName(name);
		return this;
	}
	
	public Product build(){
		return product;
	}
}
