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
	private String name;
	private String email;
	private int age;
}

