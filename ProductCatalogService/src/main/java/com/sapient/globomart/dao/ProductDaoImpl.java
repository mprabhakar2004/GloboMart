package com.sapient.globomart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.globomart.model.Product;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
/**
 * This is sample dao class using static arraylist.
 * 
 *
 */
@Component("staticDao")
public class ProductDaoImpl implements ProductDao{
	
	private List<Product> products = new ArrayList<>(); 

	public Product addProduct(Product product){
		product.setId(new Random().nextInt());
		products.add(product);
		return product;
	}
	
	public List<Product> list(){
		return products;
	}

	public void deleteAll() {
		products.clear();
	}

	public Product findProduct(Long productId) {
		Optional<Product> product = products.stream().filter(e -> e.getId().equals(productId)).findFirst();
		return product.isPresent() ? product.get() : null;
	}
	
	public List<Product> findProductsByType(String categoryType){
		return null;
	}

	@Override
	public Page<Product> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product findProduct(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
