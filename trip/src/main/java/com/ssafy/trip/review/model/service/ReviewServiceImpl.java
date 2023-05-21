package com.ssafy.trip.review.model.service;

import com.ssafy.trip.review.dto.Review;
import com.ssafy.trip.review.model.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewRepo;

	@Override
	public Review getReview(int reviewId) throws Exception {
		Review review = reviewRepo.getReview(reviewId);
		reviewRepo.updateHit(review);
		return review;
	}

	@Override
	public void writeReview(Review review) throws Exception {
		if(review.getTitle() == null || review.getDesc() == null || review.getImage() == null) {
			throw new Exception();
		}
		reviewRepo.writeReview(review);
	}


	@Override
	@Transactional
	public void deleteReview(int reviewId) throws Exception {
		reviewRepo.deleteReview(reviewId);
	}

	@Override
	@Transactional
	public void modifyReview(Map<String, String> map) throws Exception {
		reviewRepo.modifyReview(map);
	}

	@Override
	@Transactional
	public List<Review> listReview() throws Exception {
		return reviewRepo.listReview();
	}
	
//	@Override
//	public List<Review> searchByCondition(SearchCondition con) {
//		return reviewRepo.searchByCondition(con);
//	}
}
