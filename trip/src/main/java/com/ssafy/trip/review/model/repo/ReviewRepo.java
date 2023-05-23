package com.ssafy.trip.review.model.repo;

import com.ssafy.trip.review.dto.Review;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewRepo {
	int writeReview(Review review) throws SQLException;
	List<Review> listReview() throws SQLException;
	List<Review> listHotReview() throws SQLException;
	List<Review> listMyReview(String userId) throws SQLException;
	Review getReview(int reviewId) throws SQLException;
	int updateHit(Review reviewId) throws SQLException;
	int updateLikes(Review review) throws SQLException;
	int modifyReview(Map<String, String> map) throws SQLException;
	int deleteReview(int reviewId) throws SQLException;

}
