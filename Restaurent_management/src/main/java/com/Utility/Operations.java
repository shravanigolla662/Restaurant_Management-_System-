package com.Utility;

import java.util.Scanner;

import com.ServiceImpl.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

import com.ServiceImpl.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Operations {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("Config.xml").buildSessionFactory();

		Scanner sc = new Scanner(System.in);

		MenuImpl menu = new MenuImpl();
		//menu.addMenu(sf);
		PlaceOrderImpl order = new PlaceOrderImpl();
		BooktableImpl book = new BooktableImpl();
		PaymentImpl pay = new PaymentImpl();
		ReviewImpl review = new ReviewImpl();

		System.out.println("Restaurent Management System..");
		while (true) {
			System.out.println("1.View Menu" + "\n2.Place Order" + "\n3.Cancel Order" + "\n4.Reserve a table"
					+ "\n5.Cancel your Reservation" + "\n6.Payment" + "\n7.Review Restaurent" + "\n8.Exit");
			System.out.print("Choose an option :");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				menu.getMenu(sf);
				break;
			case 2:
				order.makeOrder(sf);
				break;
			case 3:
				order.cancelOrder(sf);
				break;
			case 4:
				book.booktable(sf);
				break;
			case 5:
				book.unbooktable(sf);
				break;
			case 6:
				pay.makepayment(sf);
				break;
			case 7:
				review.addReview(sf);
				break;
			case 8:
				System.out.print("Exiting");
				for (int i = 5; i > 0; i--) {
					System.out.print(".");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				System.exit(0);
			default:
				System.out.println("Choose the given option and try again");
				break;
			}
		}

	}

}
