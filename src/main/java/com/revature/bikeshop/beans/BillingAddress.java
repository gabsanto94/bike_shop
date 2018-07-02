package com.revature.bikeshop.beans;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class BillingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_Sequence")
	@SequenceGenerator(name = "billing_Sequence", sequenceName = "Billing_SEQ")
	private int billingAddressId;
	
	@Column(name = "streetname")
	private String streetname;
	
	@Column(name = "city")
	private String city;
	
	@Column(name= "state")
	private String state;
	
	@Column(name = "zip")
	private String zip;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + billingAddressId;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((streetname == null) ? 0 : streetname.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillingAddress other = (BillingAddress) obj;
		if (billingAddressId != other.billingAddressId)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (streetname == null) {
			if (other.streetname != null)
				return false;
		} else if (!streetname.equals(other.streetname))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BillingAddress [billingAddressId=" + billingAddressId + ", streetname=" + streetname + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", user=" + user + "]";
	}
	
	

}
