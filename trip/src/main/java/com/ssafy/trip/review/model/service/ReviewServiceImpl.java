package com.ssafy.trip.review.model.service;

import com.ssafy.trip.review.dto.Review;
import com.ssafy.trip.review.model.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
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
		return reviewRepo.getReview(reviewId);
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
	public int updateLikes(int reviewId) throws SQLException {
		Review review = reviewRepo.getReview(reviewId);
		return reviewRepo.updateLikes(review);
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

	@Override
	public List<Review> listHotReview() throws Exception {
		return reviewRepo.listHotReview();
	}

	@Override
	@Transactional
	public List<Review> listMyReview(String userId) throws Exception {
		return reviewRepo.listMyReview(userId);
	}

}
