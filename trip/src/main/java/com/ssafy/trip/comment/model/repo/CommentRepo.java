package com.ssafy.trip.comment.model.repo;

import com.ssafy.trip.comment.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepo {
	List<Comment> list(int reviewId);
	int create(Comment comment);
	int update(Comment comment);
	int delete(int commentId);
}
