package com.Service;

import org.hibernate.SessionFactory;

public interface BookTableService {

	void booktable(SessionFactory sf);
	void unbooktable(SessionFactory sf);
}
