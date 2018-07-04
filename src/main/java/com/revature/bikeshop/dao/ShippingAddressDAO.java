package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.ShippingAddress;

public interface ShippingAddressDAO {

	public int createShippingAddress(ShippingAddress address);
	
	public ShippingAddress getShippingAddress(int shippingAddressId);
	
	public void deleteShippingAddress(ShippingAddress address);
	
	public void updateShippingAddress(ShippingAddress address);
}

