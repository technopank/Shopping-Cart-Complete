package com.example.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Product;
import com.example.Service.ProductService;

import ch.qos.logback.classic.Logger;
import lombok.extern.java.Log;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
	private
	static
	final
	org.slf4j.Logger
	logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product product){
		service.createProduct(product);
		return new ResponseEntity<String>("Product added successfully", HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		service.deleteProduct(id);
		return new ResponseEntity<String>("Product has been deleted successfully", HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product>productList = service.getAllProduct();
		logger.info("FETCHING PRODUCT{}", productList);
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
}
