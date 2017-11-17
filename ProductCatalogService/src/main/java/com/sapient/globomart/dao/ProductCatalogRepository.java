package com.sapient.globomart.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sapient.globomart.model.Product;

@Repository
public interface ProductCatalogRepository extends PagingAndSortingRepository<Product, Integer>{
	
	@Query("Select p from Product p where p.category.name=?1")
	public Iterable<Product> findByProductsCategory(String category);

}
 