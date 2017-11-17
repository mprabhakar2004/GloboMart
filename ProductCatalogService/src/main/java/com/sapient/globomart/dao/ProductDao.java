package com.sapient.globomart.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sapient.globomart.model.Product;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
public interface ProductDao {
	
	public Product addProduct(Product product);
	
	public boolean deleteProduct(Integer productId);
	
	public List<Product> list();

	public void deleteAll();

	public Product findProduct(Integer productId);

	public List<Product> findProductsByType(String categoryType);

	public Page<Product> listAllByPage(Pageable pageable);
}
