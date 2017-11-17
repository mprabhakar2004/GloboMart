package com.sapient.globomart.ut;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Qualifier;

import com.sapient.globomart.dao.ProductDao;
import com.sapient.globomart.model.Product;
import com.sapient.globomart.service.ProductServiceImpl;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
public class ProductCatalogServiceTest {
	
	@Mock
	@Qualifier("hsqlDao")
	private ProductDao productDao;
	
	@InjectMocks
	private ProductServiceImpl productService;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Test
	public void testSetup(){
		String str = "done with Junit setup!";
		Assert.assertEquals(str, "done with Junit setup!");
	}
	
	@Test
	public void findProductWithInvalidId(){
		Assert.assertEquals(null, productService.findProduct(2));
	}
	
	@Test
	public void findProductWithValidId() {
		when(productDao.findProduct(1)).thenReturn(mock(Product.class));
		Product product = productService.findProduct(1);
		assertNotNull(product);
	}
}

