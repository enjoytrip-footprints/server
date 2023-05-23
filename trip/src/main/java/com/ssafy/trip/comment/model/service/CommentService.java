package com.ssafy.trip.comment.model.service;

import com.ssafy.trip.comment.dto.Comment;

import java.util.List;

public interface CommentService {
	List<Comment> list(int reviewId) throws Exception;
	boolean create(Comment comment) throws Exception;
	boolean update(Comment comment) throws Exception;
	boolean delete(int commentId) throws Exception;
}
