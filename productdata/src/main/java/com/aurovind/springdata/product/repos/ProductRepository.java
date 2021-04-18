package com.aurovind.springdata.product.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aurovind.springdata.product.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
	
	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name, String desc);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByDescContains(String desc);
	
	List<Product> findByPriceBetween(double price, double price2);
	
	List<Product> findByDescLike(String desc);
	
	List<Product> findByIdIn(List<Object> list);
	
	@Query(value = "CALL GetAllProducts", nativeQuery = true)
	List<Product> findAllproducts();
	
	@Query(value = "CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
	List<Product> findAllproductsByPrice(double price_in);
	
	@Query(value = "CALL GetAllProductsByPrice (:price_in)", nativeQuery = true)
	int findAllproductsByPriceCount(double price_in);

}
