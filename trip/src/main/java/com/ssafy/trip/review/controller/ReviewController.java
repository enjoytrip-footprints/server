package com.ssafy.trip.review.controller;

import com.ssafy.trip.review.dto.Review;
import com.ssafy.trip.review.model.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/review")
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private ReviewService reviewService;

	@ApiOperation(value = "후기 조회", response = String.class)
	@GetMapping("/{reviewId}")
	public ResponseEntity<?> getReview(@PathVariable("reviewId") int reviewId) {
		try {
			Review review = reviewService.getReview(reviewId);
			if (review != null) {
				return new ResponseEntity<Review>(review, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "후기 리스트",  response = String.class)
	@GetMapping("/getReviewList")
	public ResponseEntity<?> getReviewList() {
		try {
			List<Review> reviews = reviewService.listReview();
			if (reviews != null && !reviews.isEmpty()) {
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "특정인 후기 리스트",  response = String.class)
	@GetMapping("/getReviewList/{userId}")
	public ResponseEntity<?> getMyReviewList(@PathVariable("userId") String userId) {
		try {
			List<Review> reviews = reviewService.listMyReview(userId);
			if (reviews != null && !reviews.isEmpty()) {
				return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/write")
	public ResponseEntity<?> writeReview(@Value("${file.path.upload-files}") String filePath, Review review,
										   @RequestParam("upfile") MultipartFile file) {
		try {

			if (!file.isEmpty()) {
				String hot = "review";
				String saveFolder = filePath + hot;
				logger.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if (!folder.exists())
					folder.mkdirs();
				String originalFileName = file.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", file.getOriginalFilename(), saveFileName);
					file.transferTo(new File(folder, saveFileName));
					review.setImage(hot + "/" + saveFileName);
				}
			}

			reviewService.writeReview(review);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/modify")
	public ResponseEntity<?> modifyReview(@RequestBody Map<String, String> map) {
		try {
			reviewService.modifyReview(map);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/{reviewId}")
	public ResponseEntity<?> deleteReview(@PathVariable("reviewId") int reviewId) {
		try {
			reviewService.deleteReview(reviewId);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

//	@GetMapping("/search")
//	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = Review.class)
//	public ResponseEntity<?> search(SearchCondition con) {
//
//		List<Review> reviews = reviewService.searchByCondition(con);
//		if (reviews != null && reviews.size() > 0) {
//			return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//	}

}
