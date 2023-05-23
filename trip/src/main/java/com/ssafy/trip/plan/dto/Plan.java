package com.ssafy.trip.plan.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="여행계획 정보", description = "여행계획을 나타냅니다.")
public class Plan {
	public int id;
	public String memberId;
	public String planTitle;
	public String planDetail;
	public String registerdTime;
	
	// 게시판 작성용 생성자
	public Plan(String memberId, String planTitle, String planDetail) {
		this.memberId = memberId;
		this.planTitle = planTitle;
		this.planDetail = planDetail;
	}
}

