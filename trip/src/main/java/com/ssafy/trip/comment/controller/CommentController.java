package com.ssafy.trip.comment.controller;

import com.ssafy.trip.comment.dto.Comment;
import com.ssafy.trip.comment.model.service.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private CommentService commentService;

	@ApiOperation(value = "리뷰에 해당하는 댓글 목록을 반환한다.", response = List.class)
	@GetMapping("{reviewId}")
	public ResponseEntity<List<Comment>> listComment(@PathVariable("reviewId") int reviewId) throws Exception {
		logger.debug("listComment - 호출");
		return new ResponseEntity<>(commentService.list(reviewId), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 댓글 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createComment(@RequestBody Comment comment) throws Exception {
		logger.debug("createComment - 호출");
		if(commentService.create(comment)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "댓글을 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyComment(@RequestBody Comment comment) throws Exception {
		logger.debug("modifyComment - 호출");
		logger.debug("" + comment);
		System.out.println("댓글 수정하자!!!"  + comment);
		if(commentService.update(comment)) {
			System.out.println("댓글 수정 성공!!!");
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "commentId 해당하는 댓글 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{commentId}")
	public ResponseEntity<String> deleteBook(@PathVariable("commentId") int commentId) throws Exception {
		logger.debug("deleteBook - 호출");
		if(commentService.delete(commentId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
