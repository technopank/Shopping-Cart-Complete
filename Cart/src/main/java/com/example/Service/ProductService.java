package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Product;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public Product createProduct(Product product) {
		return repo.save(product);
	}

	public void deleteProduct(long id) {
		repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("data not found"));
		repo.deleteById(id);
	}

	public List<Product> getAllProduct() {
		return repo.findAll();
	}

}
