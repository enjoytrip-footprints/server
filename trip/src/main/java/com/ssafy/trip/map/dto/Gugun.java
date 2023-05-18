package com.ssafy.trip.map.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@ApiModel(value="구군 정보", description = "구군의 상세 정보를 나타냅니다.")
public class Gugun {
	private String gugun_code;
	private String gugun_name;
	private String sido_code;
}
