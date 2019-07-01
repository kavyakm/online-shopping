package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*
	 * @Test public void testCRUDProduct() {
	 * 
	 * // create operation product = new Product();
	 * 
	 * product.setName("Oppo Selfie S53"); product.setBrand("Oppo");
	 * product.setDescription("This is some description for Oppo mobile phone!");
	 * product.setUnitPrice(25000); product.setActive(true);
	 * product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * assertEquals("Something Went wrong while inserting a new product!",
	 * true,productDAO.add(product));
	 * 
	 * // reading and updating the Product product = productDAO.get(2);
	 * product.setName("Samsung Galaxy S7");
	 * assertEquals("Something Went wrong while updating the existing record!",
	 * true,productDAO.update(product));
	 * 
	 * assertEquals("Something Went wrong while deleting the existing record!",
	 * true,productDAO.delete(product));
	 * 
	 * // list
	 * assertEquals("Something Went wrong while fetching the list of products!",
	 * 6,productDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testListActiveProducts() {
		assertEquals("Something Went wrong while fetching the list of products!",
				 5,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something Went wrong while fetching the list of products!",
				 3,productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("Something Went wrong while fetching the list of products!",
				 2,productDAO.listActiveProductsByCategory(1).size());
	}
	
	@Test
	public void testLatestActiveProduct() {
		assertEquals("Something Went wrong while fetching the list of products!",
				 3,productDAO.getLatestActiveProducts(3).size());
	}
}
