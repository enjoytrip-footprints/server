package com.ssafy.trip.comment.model.service;

import com.ssafy.trip.comment.dto.Comment;
import com.ssafy.trip.comment.model.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

	@Override
	public List<Comment> list(int reviewId) throws Exception {
		return commentRepo.list(reviewId);
	}

	@Override
	@Transactional
	public boolean create(Comment comment) throws Exception {
		return commentRepo.create(comment) == 1;
	}

	@Override
	@Transactional
	public boolean update(Comment comment) throws Exception {
		return commentRepo.update(comment) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int commentId) throws Exception {
		return commentRepo.delete(commentId) == 1;
	}
}
