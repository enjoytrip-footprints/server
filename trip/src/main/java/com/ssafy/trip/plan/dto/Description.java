package com.ssafy.trip.plan.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="여행계획 세부정보", description = "여행계획 세부내용을 나타냅니다.")
public class Description {
	public int id;
	public String planId;
	public String placeId;
	public String content;
	public String price;
	public String happy;
	public String departTime;
	public String arriveTime;
	// 게시판 작성용 생성자
	public Description(String planId, String placeId, String content, String price, String happy, String departTime, String arriveTime) {
		this.planId = planId;
		this.placeId = placeId;
		this.content = content;
		this.price = price;
		this.happy = happy;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
	}
}

