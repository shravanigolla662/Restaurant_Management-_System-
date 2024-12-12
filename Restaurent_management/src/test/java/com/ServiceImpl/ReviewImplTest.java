package com.ServiceImpl;

import com.entity.ReviewRestaurent;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewImplTest {

    @Test
    void addReview() {
        ReviewRestaurent review = new ReviewRestaurent(1, "Ganesh", 5, "Good Atmosphere");
        assertEquals(1, review.getReviewId());
        assertEquals("Ganesh", review.getCustomerName());
        assertEquals(5, review.getRating());
        assertEquals("Good Atmosphere", review.getReview());
    }
}
