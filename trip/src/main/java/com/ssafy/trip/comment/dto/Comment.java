package com.ssafy.trip.comment.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="댓글")
public class Comment {
	private int id;
	private int reviewId;
	private String userId;
	private String content;
}

