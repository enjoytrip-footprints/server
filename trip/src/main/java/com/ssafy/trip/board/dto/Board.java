package com.ssafy.trip.board.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="게시판 정보", description = "게시판의 상세 정보를 나타냅니다.")
public class Board {
	private int articleNo;
	private String author;
	private String title;
	private String article;
	private int cnt;
}

