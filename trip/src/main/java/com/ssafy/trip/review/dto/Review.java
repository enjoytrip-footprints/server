package com.ssafy.trip.review.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="여행후기 정보", description = "여행후기를 나타냅니다.")
public class Review {
	public int reviewId;
	public String userId;
	public String title;
	public String image;
	public String desc;
	public int hit;
	public int likes;
}

