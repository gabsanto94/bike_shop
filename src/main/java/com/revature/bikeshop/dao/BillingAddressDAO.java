package com.revature.bikeshop.dao;

import com.revature.bikeshop.model.BillingAddress;

public interface BillingAddressDAO {
	
	public int createBillingAddress(BillingAddress address);
	
	public BillingAddress getShippingAddress(int billingAddressId);
	
	public void deleteBillingAddress(BillingAddress address);
	
	public void updateBillingAddress(BillingAddress address);
}
