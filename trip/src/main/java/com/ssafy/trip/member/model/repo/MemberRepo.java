package com.ssafy.trip.member.model.repo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.trip.member.dto.MemberLoginDto;
import com.ssafy.trip.member.dto.MemberUpdateDto;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.member.dto.MemberRegistDto;

@Mapper
public interface MemberRepo {
	String loginCheck(Member dto);
	Member read(String id) throws SQLException;
	List<Member> readAll() throws SQLException;
	int create(MemberRegistDto user) throws SQLException;
	int update(MemberUpdateDto user) throws SQLException;
	int delete(String id) throws SQLException;
	
	 Member login(MemberLoginDto memberDto) throws SQLException;
	 Member userInfo(String userid) throws SQLException;
	 void saveRefreshToken(Map<String, String> map) throws SQLException;
	 Object getRefreshToken(String userid) throws SQLException;
	 void deleteRefreshToken(Map<String, String> map) throws SQLException;
}
