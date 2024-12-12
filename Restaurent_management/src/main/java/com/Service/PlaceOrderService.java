package com.Service;

import org.hibernate.SessionFactory;

public interface PlaceOrderService {

	void makeOrder(SessionFactory sf);
	void cancelOrder(SessionFactory sf);
	void getOrderdetails(SessionFactory sf);

}
