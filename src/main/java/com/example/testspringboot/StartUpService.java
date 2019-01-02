package com.example.testspringboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.testspringboot.model.Product;
import com.example.testspringboot.repository.ProductRepository;

@Component
public class StartUpService  implements ApplicationRunner  {
	private static final Logger LGR = LogManager.getLogger(StartUpService.class);
	private ProductRepository productRepository;
	 
 
    @Autowired
    public StartUpService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
	@Override
	public void run(ApplicationArguments args) throws Exception {
		 LGR.warn("####  Starting Application ####");
		 productRepository.save(new Product(1, "Bill"));
		 productRepository.save(new Product(2, "Product"));
		 LGR.warn("#### Application Started ####");

	}

}
