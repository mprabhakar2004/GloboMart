/**
 * 
 */
package com.sapient.globomart.it;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.sapient.globomart.model.Product;
import com.sapient.globomart.service.ProductService;
import com.sapient.globomart.AppConfig;
import com.sapient.globomart.builder.ProductBuilder;

/**
 * @author Manishkumar
 * @since 08/15/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {AppConfig.class})
public class ProductCatalogControllerIT {

	@Autowired
	private ProductService productService;

	@Value("${local.server.port}")
	int port;
	
	final static String firstProductName = "Nokia 1100", secondProductName = "Redmi Note4", thirdProductName = "Samsung Galaxy 6S";
	final static Product firstProduct = new ProductBuilder().id(1).name(firstProductName).build(); 
	final static Product secondProduct = new ProductBuilder().id(2).name(secondProductName).build();
	final static Product thirdProduct = new ProductBuilder().id(3).name(thirdProductName).build();

	@Before
	public void setUp() throws Exception {
		RestAssured.port = port;
		productService.deleteAll();
		productService.addProduct(firstProduct);
		productService.addProduct(secondProduct);
	}

	@Test
	public void getMessagesShouldReturnBothMessages() {
	  when()
	    .get("/catalog/products")
	  .then()
	    .statusCode(HttpStatus.OK.value())
	    .body("name", hasItems(firstProductName, secondProductName));
	}
	
	@Test
	public void postMessageShouldReturnSavedMessage() {
	  given()
	    .body(thirdProduct)
	    .contentType(ContentType.JSON)
	  .when()
	    .post("/catalog/products")
	  .then()
	    .statusCode(HttpStatus.CREATED.value())
	    .body("name", is(thirdProductName));
	}
}
