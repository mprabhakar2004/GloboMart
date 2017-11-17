package com.sapient.globomart.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sapient.globomart.dao.ProductDao;
import com.sapient.globomart.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	@Qualifier("hsqlDao")
	ProductDao dao;
	
	Logger logger = Logger.getLogger(ProductServiceImpl.class);

	public Product addProduct(Product product){
		logger.info("Adding a product: " + product.getName());
		return dao.addProduct(product);
	}
	
	public boolean deleteProduct(Integer productId){
		return dao.deleteProduct(productId);
	}
	
	public List<Product> list(){
		return dao.list();
	}
	
	public void deleteAll(){
		dao.deleteAll();
	}
	
	public Product findProduct(Integer productId){
		logger.info("Finding a product with Id: " + productId);
		return dao.findProduct(productId);
	}
	
	public List<Product> findProductsByType(String categoryType){
		return dao.findProductsByType(categoryType);
	}

	@Override
	public Page<Product> listAllByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.listAllByPage(pageable);
	}
}
