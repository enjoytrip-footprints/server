package com.ssafy.trip.plan.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="여행계획 경비, 행복도 정보", description = "여행계획 경비, 행복도를 나타냅니다.")
public class PlanInfo {
	public int pid;
	public String memberId;
	public String planId;
	public String priceSum;
	public String happyAvg;
	// 게시판 작성용 생성자
	public PlanInfo(String memberId, String planId, String priceSum, String happyAvg) {
		this.memberId = memberId;
		this.planId = planId;
		this.priceSum = priceSum;
		this.happyAvg = happyAvg;
	}
}

