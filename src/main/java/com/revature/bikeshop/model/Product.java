package com.revature.bikeshop.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_Sequence")
	@SequenceGenerator(name = "product_Sequence", sequenceName = "Product_SEQ")
	private int productId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "inStock")
	private int inStock;
	//private MultipartFile image;
	
	 @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "cart")
	private List <CartItem> cartItemList;
	
	
	
	public Product() {
		super();
	}
	
	public Product(int productId, String name, String manufacturer, String category, String description, double price,
			String status, int inStock, List<CartItem> cartItemList) {
		super();
		this.productId = productId;
		this.name = name;
		this.manufacturer = manufacturer;
		this.category = category;
		this.description = description;
		this.price = price;
		this.status = status;
		this.inStock = inStock;
		this.cartItemList = cartItemList;
	}
	public List<CartItem> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
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




