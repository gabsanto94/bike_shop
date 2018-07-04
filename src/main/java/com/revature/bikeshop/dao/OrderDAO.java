package com.revature.bikeshop.dao;

import java.util.List;
import com.revature.bikeshop.model.Order;

public interface OrderDAO {

	public boolean addUserOrder(Order order);
	
	public List<Order> getAllOrders();
	
	public List<Order> getAllOrdersByUsername(String user);
	
}
