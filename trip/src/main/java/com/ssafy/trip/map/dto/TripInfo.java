package com.ssafy.trip.map.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="여행지 정보", description = "여행지의 상세 정보를 나타냅니다.")
public class TripInfo {
	private String content_id;
	private String content_type_id;
	private String title;
	private String addr1;
	private String first_image;
	private String sido_code;
	private String gugun_code;
	private String latitude;
	private String longitude;
	
}
