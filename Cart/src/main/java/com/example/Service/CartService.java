package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Entity.Cart;
import com.example.Entity.Product;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repository.CartRepository;
import com.example.Repository.ProductRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository prodRepo;
	
	public Cart addTocart(long id) {
	Product p = prodRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found"));	
	Cart c = new Cart(); 
	
	c.setId(p.getId());
	c.setImage(p.getImage());
	c.setPrice(p.getPrice());
	c.setName(p.getName());
	c.setRating(p.getRating());
	
	
	return cartRepo.save(c);
	}
	
	public List<Cart>getProductFromCart() {
		return cartRepo.findAll();
	}
	
		
	public void deleteFromCart(long id) {
		 cartRepo.deleteById(id);
		
		
	}
	
	
}
