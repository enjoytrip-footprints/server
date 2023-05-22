package com.ssafy.trip.review.model.service;

import com.ssafy.trip.review.dto.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {
	void writeReview(Review review) throws Exception;
	List<Review> listReview() throws Exception;
	List<Review> listMyReview(String userId) throws Exception;
	Review getReview(int reviewId) throws Exception;
	void modifyReview(Map<String, String> map) throws Exception;
	void deleteReview(int reviewId) throws Exception;
//	List<Review> searchByCondition(SearchCondition con);
}
