package com.Service;

import org.hibernate.SessionFactory;

public interface MenuService {

	void addMenu(SessionFactory sf);
	void getMenu(SessionFactory sf);
}
