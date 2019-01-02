package com.example.testspringboot.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.testspringboot.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
