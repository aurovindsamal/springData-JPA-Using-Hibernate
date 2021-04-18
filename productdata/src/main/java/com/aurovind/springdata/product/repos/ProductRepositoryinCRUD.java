package com.aurovind.springdata.product.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aurovind.springdata.product.entities.Product;

public interface ProductRepositoryinCRUD extends CrudRepository<Product, Integer>{
	
	List<Product> findByIdIn(List<Object> list,Pageable pageable);

}
