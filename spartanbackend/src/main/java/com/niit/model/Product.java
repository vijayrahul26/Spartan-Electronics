package com.niit.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@NotEmpty(message="ProductName cannot be empty")
	String ProductName;
	@NotEmpty(message="ProductDescription is mandatory")
	String ProductDescription;
	@Min(value=1,message="Minimum value for ProductPrice is 1")
	double ProductPrice;
	 @Min(value=0,message="ProductSize cannot be less than 0")
	int ProductSize;
	 @Min(value=0,message="ProductQuantity cannot be less than 0")
	int ProductQuantity;
	@ManyToOne
	private Category category;
	@Transient
	private MultipartFile image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductSize() {
		return ProductSize;
	}
	public void setProductSize(int productSize) {
		ProductSize = productSize;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
     
	
	}
