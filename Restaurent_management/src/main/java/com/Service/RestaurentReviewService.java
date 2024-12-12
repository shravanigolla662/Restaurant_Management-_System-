package com.Service;


import org.hibernate.SessionFactory;

public interface RestaurentReviewService {

	public void addReview(SessionFactory sf);

	public void getReviewById(SessionFactory sf);

	public void deleteReview(SessionFactory sf);

}
