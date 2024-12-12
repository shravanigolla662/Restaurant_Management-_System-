package com.Service;

import org.hibernate.SessionFactory;

public interface PaymentService {

	void makepayment(SessionFactory sf);
}
