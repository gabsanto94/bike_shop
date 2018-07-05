package com.revature.bikeshop.model;

import javax.persistence.*;

@Entity
@Table(name="Billing_Address")
public class BillingAddress {
	
	@Id
    @SequenceGenerator(name = "billing_Sequence", sequenceName = "Billing_SEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "billing_Sequence")
	private int billingAddressId;
	
	@Column
	private String streetname;
	
	@Column
	private String city;
	
	@Column
	private String state;
	
	@Column
	private String zip;
	
	@OneToOne
	private User user;
	
	
	public BillingAddress() {
		super();
	}
	
	public BillingAddress(int billingAddressId, String streetname, String city, String state, String zip, User user) {
		super();
		this.billingAddressId = billingAddressId;
		this.streetname = streetname;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.user = user;
	}

	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
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
		return "BillingAddress [billingAddressId=" + billingAddressId + ", streetname=" + streetname + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", user=" + user + "]";
	}

}
