package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	
	@Id
	private long id;
	
	private String name;
	
	private String rating;
	
	private double price;
	
	@Column(length=10000)
	private String image;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(long id, String name, String rating, double price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.price = price;
		this.image = image;
	}
	
	
}

