package com.example.testspringboot.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.testspringboot.exception.ProductNotfoundException;
import com.example.testspringboot.model.Product;

@RestController
public class ProductServiceController {
	   private static AtomicInteger counter = new AtomicInteger(0);
	   private static Map<Integer, Product> productRepo = new ConcurrentHashMap<Integer, Product>();
	   
	   static {
		      Product honey = new Product();
		      honey.setId(counter.incrementAndGet());
		      honey.setName("Honey");
		      productRepo.put(honey.getId(), honey);
		      
		      Product almond = new Product();
		      almond.setId(counter.incrementAndGet());
		      almond.setName("Almond");
		      productRepo.put(almond.getId(), almond);
		   }
	   
	   @RequestMapping("/products")
	   public ResponseEntity<Object> getProducts(){
	    	 // throw new ProductNotfoundException();

		   return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
	   @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	      productRepo.put(counter.incrementAndGet(), product);
	      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	   }
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) { 
		      if(!productRepo.containsKey(id)) {
		    	  throw new ProductNotfoundException();

		      }

	      productRepo.remove(id);
	      product.setId(id);
	      productRepo.put(id, product);
	      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	   }  
	   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> delete(@PathVariable("id") Integer id) { 
	      productRepo.remove(id);
	      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	   }
}
