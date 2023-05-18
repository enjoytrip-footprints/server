package com.ssafy.trip.map.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="시도 정보", description = "시도의 상세 정보를 나타냅니다.")
public class Sido {
	private String sido_code;
	private String sido_name;
}
