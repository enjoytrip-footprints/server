package com.ssafy.trip.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberRegistDto {
	private String id;
	private String password;
	private String email;
	private String name;
	private int age;
}
