package com.example.testspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testspringboot.exception.ProductNotfoundException;
import com.example.testspringboot.model.Product;
import com.example.testspringboot.repository.ProductRepository;

@RestController
public class ProductServiceController {

	private ProductRepository productRepository;

	@Autowired
	public ProductServiceController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping("/products")
	public ResponseEntity<Object> getProducts() {
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
	}
	@RequestMapping("/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) {
		if (!productRepository.existsById(id)) {
			throw new ProductNotfoundException();
		}
		return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productRepository.save(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
		if (!productRepository.existsById(id)) {
			throw new ProductNotfoundException();
		}
		productRepository.save(product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}
}
