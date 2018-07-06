package com.revature.bikeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Shipping_Address")
public class ShippingAddress implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "shipping_Sequence", sequenceName = "Shipping_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "shipping_Sequence")
	private int shippingAddressId;
	
	@Column
	private String streetname;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zip;
	
	@OneToOne
	@JsonIgnore
	private User user;
	
	
	public ShippingAddress() {
		super();
	}

	public ShippingAddress(int shippingAddressId, String streetname, String city, String state, String zip, User user) {
		super();
		this.shippingAddressId = shippingAddressId;
		this.streetname = streetname;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.user = user;
	}

	public int getShippingAddressId() {
		return shippingAddressId;
	}
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShippingAddress [shippingAddressId=" + shippingAddressId + ", streetname=" + streetname + ", city="
				+ city + ", state=" + state + ", zip=" + zip + "]";
	}
	
	
}
