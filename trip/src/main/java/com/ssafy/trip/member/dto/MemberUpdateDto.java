package com.ssafy.trip.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberUpdateDto {
    private String id;
    private String password;
    private String email;
    private String name;
    private int age;
}
