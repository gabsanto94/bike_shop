package com.revature.bikeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="users")
public class User {

	@Id
    @SequenceGenerator(name = "user_Sequence", sequenceName = "User_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_Sequence")
	private int userId;
	
	@Column
	private String fname;
	
	@Column
	private String lname;
	
	@Column
	private String email;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billingAddressId")
	private BillingAddress billingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shippingAddressId")
	private ShippingAddress shippingAddress;

    @Column
    private String userRole;
	
	public User() {
		super();
	}

    public User(String fname, String lname, String email, String username, String password, BillingAddress billingAddress, ShippingAddress shippingAddress, String userRole) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.userRole = userRole;
    }

    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userRole='" + userRole + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +

                '}';
    }
}
