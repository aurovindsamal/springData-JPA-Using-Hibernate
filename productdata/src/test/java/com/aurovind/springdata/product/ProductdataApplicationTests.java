package com.aurovind.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.assertj.core.util.Arrays;
import org.h2.result.SortOrder;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.querydsl.QPageRequest;

import com.aurovind.springdata.product.entities.Product;
import com.aurovind.springdata.product.repos.ProductRepository;
import com.aurovind.springdata.product.repos.ProductRepositoryinCRUD;

@SpringBootTest
class ProductdataApplicationTests {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductRepositoryinCRUD productRepositoryinCRUD;
	
	@Autowired
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreateProduct(){
		
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);

	}
	
	@Test
	public void testRead() {
		
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);
		Product retrieveProduct = productRepository.findById(1).get();
		assertEquals("First Product", retrieveProduct.getName());
		System.out.println("PRODUCT DESCRIPTION "+product.getDesc());
	}
	
	@Test
	public void testUpdate() {
		
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);
		Product retrieveProduct = productRepository.findById(1).get();
		assertEquals("First Product", retrieveProduct.getName());
		System.out.println("PRODUCT DESCRIPTION "+product.getDesc());
		
		retrieveProduct.setName("Name Modified");
		productRepository.save(retrieveProduct);
		
		Product retrieveProductsecond = productRepository.findById(1).get();
		assertEquals("Name Modified", retrieveProductsecond.getName());
		
	}
	
	@Test
	public void testDelete() {
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);
		
		if(productRepository.existsById(1)) {
			System.out.println("deleting a product");
			productRepository.delete(product);
		}	
	}
	
	@Test
	public void testCount() {
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);
		
		System.out.println("Total records "+productRepository.count());
	}
	
	@Test
	public void findByName(String name) {
		Product product = new Product();
		product.setId(1);
		product.setName("First Product");
		product.setDesc("Checking thorough test");
		product.setPrice(200d);
		
		productRepository.save(product);
		List<Product> findByName = productRepository.findByName("First Product");
		findByName.forEach(p->System.out.println("Price of the product "+p.getPrice()));
	}
	
	@Test
	public void findByNameAndDesc(String name, String desc) {
		List<Product> findByNameAndDesc = productRepository.findByNameAndDesc("First Product", "desc");
		findByNameAndDesc.forEach(p-> System.out.println(p.getName()));
		
	}
	
	
	@Test
	public void findByPriceGreaterThan(double price) {
		List<Product> findByPriceGreaterThan = productRepository.findByPriceGreaterThan(1000d);
		findByPriceGreaterThan.forEach(p-> System.out.println(p.getName()));
		
	}
	
	@Test
	public void findByDescContains() {
		List<Product> findByDescContains = productRepository.findByDescContains("apple");
		findByDescContains.forEach(p-> System.out.println(p.getName()));
		
	}
	
	@Test
	public void findByPriceBetween() {
		List<Product> findByPriceBetween = productRepository.findByPriceBetween(100d, 200d);
		findByPriceBetween.forEach(p-> System.out.println(p.getName()));
		
	}
	
	@Test
	public void findByDescLike() {
		List<Product> findByDescLike = productRepository.findByDescLike("%auro%");
		findByDescLike.forEach(p-> System.out.println(p.getName()));
		
	}
	
	@Test
	public void testFindByIdIn() {
		List<Product> findByIdIn = productRepository.findByIdIn(Arrays.asList(1));
		findByIdIn.forEach(p-> System.out.println(p.getName()));
		
	}
	
	///////////////////PAGING AND SORTING REPOSITORY//////////////////////////////////
	@Test
	public void testfindAllpaging() {
		Pageable pageable = PageRequest.of(0, 1);//we are displaying one record per page and when we pass 0 it means it fetches the 
		//first record and displays and whjle we pass 2 it displays the third product in page 2. 
		//if we pass 0,2 then it displays 2 records on first page 
		Page<Product> results = productRepository.findAll(pageable);
		results.forEach(page->System.out.println(page.getName()));
	}
	
	
	@Test
	public void testfindAllSorting() {
		productRepository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"))).forEach(p-> System.out.println(p.getName()));
		//dryer,iphone,TV,washer

	}
	
	@Test
	public void testfindAllSortingManyProperties() {
		productRepository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"), new Sort.Order(null, "price"))).forEach(p-> System.out.println(p.getName()));
		//dryer,iphone,TV,washer
		//sorts on my name and price

	}
	
	@Test
	public void testfindAllSortingManyPropertiesandDirections() {
		productRepository.findAll(Sort.by(new Sort.Order(Direction.ASC, "name"), new Sort.Order(Direction.DESC, "price"))).forEach(p-> System.out.println(p.getName()));
		//dryer,iphone,TV,washer
		//sorts on my name and price and multi directions

	}
	
	@Test
	public void testfindAllpagingAndSorting() {
		Pageable pageable = PageRequest.of(0, 2, Direction.DESC, "name");
		productRepository.findAll(pageable).forEach(p->System.out.println(p.getName()));
		//sorts by name in desc order and gives two products per page 

	}
	
	//////////////////PAGING AND SORTING WITHOUT  PagingAndSortingRepository //////////////////////////
	@Test
	public void testFindAllWithoutSortingRepository() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by(new Sort.Order(Direction.DESC,"name")));
		productRepositoryinCRUD.findByIdIn(Arrays.asList(1),pageable);
	}
	
	
	/////////////////////CACHING/////////////////////////////
	@Test
	@Transactional
	public void testCaching() {
		productRepository.findById(1);
		productRepository.findById(1);
		//when we comment @transactional then cache is not maintained . first level cache does not work. it executes 2 sql statemnts 
		//Adding @Transactional makes it caheable and only one query is fired. Second method retrieves from cache 
		
	}
	
	
	@Test
	@Transactional
	//same function with second level cache it hits the db 1 time. After session.evict() it finds the object is not cached 
	//So it gets from 2nd level and puts in 1st level cache.
	public void testCachingWithEvict() {
		Session session = entityManager.unwrap(Session.class);
		Product product = productRepository.findById(1).get();
		
		productRepository.findById(1).get();
		
		session.evict(product);
		productRepository.findById(1);
		//session.evict() removes the object from cache. So it fires 2 sql queries one at line 245 and 249.
	}
	
	///////////////////////CALLING STORED PROCEDURES/////////////////////////
	@Test
	public void testStoredprocedure() {
		System.out.println(productRepository.findAllproducts());
	}
	
	@Test
	public void testStoredprocedureByPrice() {
		System.out.println(productRepository.findAllproductsByPrice(800));
	}
	
	@Test
	public void testStoredprocedureByPriceCount() {
		System.out.println(productRepository.findAllproductsByPriceCount(800));
	}
	
	
}
