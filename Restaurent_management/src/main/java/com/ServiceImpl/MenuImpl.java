package com.ServiceImpl;

import java.util.List;
import java.util.Scanner;

import com.entity.Menu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.Service.MenuService;

public class MenuImpl implements MenuService {

	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void addMenu(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();

		Menu item1 = new Menu(1, "Chilli Egg", 180);
		Menu item2 = new Menu(2, "Boiled Egg", 30);
		Menu item3 = new Menu(3, "Majestic", 265);
		Menu item4 = new Menu(4, "Drum Sticks", 275);
		Menu item5 = new Menu(5, "Chicken 65", 255);
//		item1.setItemname("Apollo Fish");
//		item1.setPrice(249);

		s.save(item1);
		s.save(item2);
		s.save(item3);
		s.save(item4);
		s.save(item5);

		t.commit();

	}

	@Override
	public void getMenu(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		Query<Menu> query = s.createQuery("FROM Menu", Menu.class);
		List<Menu> menuList = query.getResultList();

		// Check if the list is empty or not
		if (menuList.isEmpty()) {
			System.out.println("No menu items found.");
		} else {
			// Print each menu item
			System.out.println("Menu Items");
			System.out.println("ITEM_ID\t\tNAME\t\tPRICE");
			System.out.println("--------------------------------------");
			for (Menu menu : menuList) {
				System.out.println(menu.getItemId() + "\t\t" + menu.getItemName() + "\t" + menu.getPrice());
			}
		}
		s.close();

	}

}
