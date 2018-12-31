package com.example.testspringboot.repository;

import java.util.Map;

import com.example.testspringboot.model.Product;

public interface ProductRepository {
	void save(Product product);
	Product find(Integer id);
	Map<Integer, Product> findAll();
	void update(Product prodcut);
	void delete(Integer id);
}
