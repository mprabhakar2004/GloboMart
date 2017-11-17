package com.sapient.globomart.ut;

import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sapient.globomart.AppConfig;
import com.sapient.globomart.dao.ProductDao;
import com.sapient.globomart.model.Product;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ProductCatalogDaoTest {
	
	@Autowired
	@Qualifier("hsqlDao")
	private ProductDao productDao;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void testSetup(){
		String str = "done with Junit setup!";
		Assert.assertEquals(str, "done with Junit setup!");
	}
	
	//@Test
	public void findProductWithInvalidId(){
		Assert.assertEquals(null, productDao.findProduct(2));
	}
	
	@Test
	public void addProduct(){
		int noOfExistingProducts = productDao.list().size();
		Product product = productDao.addProduct(new Product(1));
		List<Product> products = productDao.list();
		Assert.assertEquals(products.size(), noOfExistingProducts + 1);
	}
	
}

