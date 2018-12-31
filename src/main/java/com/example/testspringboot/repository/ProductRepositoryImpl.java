package com.example.testspringboot.repository;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.testspringboot.model.Product;

@Repository
public class ProductRepositoryImpl {
//	private static final String KEY = "Product";
//	private RedisTemplate<String, Object> redisTemplate;
//	private HashOperations<String, Integer, Product> hashOperations;
//
//
//	
//	@Autowired
//	public ProductRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
//	 this.redisTemplate=redisTemplate;
//	}
//
//	@PostConstruct
//	private void init() {
//		hashOperations = redisTemplate.opsForHash();
//	}
//	
//	@Override
//	public void save(Product product) {
//		hashOperations.put(KEY, product.getId(), product);
//		
//	}
//
//	@Override
//	public Product find(Integer id) {
//		return hashOperations.get(KEY, id);
//
//	}
//
//	@Override
//	public Map<Integer, Product> findAll() {
//		return hashOperations.entries(KEY);
//
//	}
//
//	@Override
//	public void update(Product prodcut) {
//		hashOperations.put(KEY, prodcut.getId(), prodcut);
//
//		
//	}
//
//	@Override
//	public void delete(Integer id) {
//		hashOperations.delete(KEY, id);
//
//		
//	}

}
