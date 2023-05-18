package com.ssafy.trip.member.dto;

import io.swagger.annotations.ApiModel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiModel(value="회원 정보", description = "회원의 상세 정보를 나타냅니다.")
public class Member {
	
	private String id;
	private String password;
	private String email;
	private String name;
	private int age;
//	private String token;
}

