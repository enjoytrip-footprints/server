package com.ssafy.trip.member.model.service;

import javax.servlet.http.HttpSession;

import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.member.dto.MemberLoginDto;
import com.ssafy.trip.member.dto.MemberRegistDto;
import com.ssafy.trip.member.dto.MemberUpdateDto;

import java.sql.SQLException;
import java.util.List;

public interface MemberService { 

	Member read(String id) throws SQLException;
	List<Member> readAll() throws SQLException;
	boolean create(MemberRegistDto user) throws Exception;
	boolean update(MemberUpdateDto user) throws Exception;
	boolean delete(String id) throws Exception;
	

	 Member login(MemberLoginDto memberDto) throws Exception;
	 Member userInfo(String userid) throws Exception;
	 void saveRefreshToken(String userid, String refreshToken) throws Exception;
	 Object getRefreshToken(String userid) throws Exception;
	 void deleRefreshToken(String userid) throws Exception;
}
