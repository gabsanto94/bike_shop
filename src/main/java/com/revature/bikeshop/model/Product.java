package com.revature.bikeshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

	@Id
    @SequenceGenerator(name = "product_Sequence", sequenceName = "Product_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_Sequence")
	private int productId;
	
	@Column
	private String name;
	
	@Column
	private String manufacturer;
	
	@Column
	private String category;
	
	@Column
	private String description;
	
	@Column
	private double price;
	
	@Column
	private String status;
	
	@Column
	private int inStock;
	
	
	
	public Product() {
		super();
	}
	
	public Product(int productId, String name, String manufacturer, String category, String description, double price,
			String status, int inStock) {
		super();
		this.productId = productId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
		this.inStock = inStock;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", manufacturer=" + manufacturer + ", category="
				+ category + ", description=" + description + ", price=" + price + ", status=" + status + ", inStock="
				+ inStock + "]";
	}
}




