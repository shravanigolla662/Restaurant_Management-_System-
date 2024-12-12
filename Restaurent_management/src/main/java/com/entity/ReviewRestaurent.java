package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class ReviewRestaurent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reviewid")
	private int reviewId;

	@Column(name = "customername", length = 50)
	private String customerName;

	@Column(name = "review", length = 100)
	private String review;
	
	@Column(name = "Rating")
	private int rating;


	// Getters and setters
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public ReviewRestaurent(int reviewId, String customerName, int rating,String review) {
		this.reviewId = reviewId;
		this.customerName = customerName;
		this.rating = rating;
		this.review = review;
	}

	public ReviewRestaurent() {
	}
}
