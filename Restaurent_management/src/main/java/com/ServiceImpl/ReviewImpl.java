package com.ServiceImpl;

import com.Service.RestaurentReviewService;
import com.entity.ReviewRestaurent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

import com.Service.RestaurentReviewService;
import com.entity.ReviewRestaurent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class ReviewImpl implements RestaurentReviewService {
	Scanner sc = new Scanner(System.in);
	Session s;
	Transaction t;

	@Override
	public void addReview(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		ReviewRestaurent review = new ReviewRestaurent();
		System.out.print("Enter Customer Name :");
		review.setCustomerName(sc.next());
		System.out.print("Rate us between 1-5 :");
		review.setRating(sc.nextInt());
		System.out.println("Write a Review");
		review.setReview(sc.next());

		s.save(review);
		t.commit();
		System.out.println("Your review add to the restaurent..");
	}

	@Override
	public void getReviewById(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		System.out.print("Enter rating id to delete review :");
		int rid = sc.nextInt();

		ReviewRestaurent review = s.get(ReviewRestaurent.class, rid);
		if (review != null) {
			System.out.println("Review id :" + review.getReviewId() + "\nCustomer Name" + review.getCustomerName()
					+ "\nRating" + review.getRating() + "\nReview" + review.getReview());
		}

	}

	@Override
	public void deleteReview(SessionFactory sf) {
		s = sf.openSession();
		t = s.beginTransaction();
		System.out.print("Enter rating id to delete review :");
		int rid = sc.nextInt();

		ReviewRestaurent review = s.get(ReviewRestaurent.class, rid);
		if (review != null) {
			s.delete(review);
		}
		System.out.println("Review deleted successfully");

	}
}
