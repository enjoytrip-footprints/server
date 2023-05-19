package com.ssafy.trip.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberLoginDto {
    private String id;
    private String password;
}
