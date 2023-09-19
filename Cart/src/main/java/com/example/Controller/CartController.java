package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Cart;
import com.example.Entity.Product;
import com.example.Repository.CartRepository;
import com.example.Repository.ProductRepository;
import com.example.Service.CartService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/cart")
@CrossOrigin
@RestController
@Slf4j
public class CartController {
	

	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/{id}")
	public ResponseEntity<String> getProduct(@PathVariable long id) {
		cartService.addTocart(id);
		return new ResponseEntity<String>("Product added to cart",HttpStatus.OK);
	}
	
	
	@GetMapping("/cartProducts")
	public List<Cart>getProductFromCart() {
		return cartService.getProductFromCart();
	}
		
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteFromCart(@PathVariable long id) {
		cartService.deleteFromCart(id);
		return new ResponseEntity<String>("Product has been removed from cart",HttpStatus.OK);
		
	}
	
	
	
	
	

}
