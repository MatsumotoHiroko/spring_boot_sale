package com.example.salesapp;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.*;

public class Sale {
	@Id private String id;
	@NotBlank
	@Size(min=1, max=30)
	private String title;
	@Size(min=1, max=100)
	private String description;
	@NotNull
	private int price;
	@NotNull
	private int stock;
	@Size(min=0, max=20)
	private String country;
	@Size(min=0, max=100)
	private String state;
	@Size(min=0, max=100)
	private String city;
	@Size(min=0, max=100)
	private String street;
	@NotNull
	private Double latitude;
	@NotNull
	private Double longitude;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


}