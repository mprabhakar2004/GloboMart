package com.sapient.globomart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.sapient.globomart.model.Product;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@Component("hsqlDao")
public class ProductDaoHsqlImpl implements ProductDao{
	
	@Autowired
	ProductCatalogRepository repository;
	
	public Product addProduct(Product product){
		return repository.save(product);
	}
	
	public boolean deleteProduct(Integer productId){
		repository.delete(productId);
		return true;
	}
	
	public List<Product> list(){
		return (List<Product>)repository.findAll();
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public Product findProduct(Integer productId) {
		return repository.findOne(productId);
	}

	@Override
	public List<Product> findProductsByType(String categoryType) {
		return (List<Product>)repository.findByProductsCategory(categoryType);
	}

	@Override
	public Page<Product> listAllByPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
