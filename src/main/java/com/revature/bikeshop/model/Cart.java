package com.revature.bikeshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "cart_Sequence", sequenceName = "Cart_SEQ", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "cart_Sequence")
    private int cartId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
    private List<CartItem> cartItems;

    @Column
    private double grandTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    @JsonIgnore
    private User user;

    public Cart() {
        super();
    }

    public Cart(int cartId, List<CartItem> cartItems, double grandTotal, User user) {
        super();
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.grandTotal = grandTotal;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
    public double getGrandTotal() {
        return grandTotal;
    }
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", cartItems=" + cartItems +
                ", grandTotal=" + grandTotal +
                //", user=" + user +
                '}';
    }
}
