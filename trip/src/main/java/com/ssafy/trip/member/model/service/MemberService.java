package com.ssafy.trip.member.model.service;

import javax.servlet.http.HttpSession;

import com.ssafy.trip.member.dto.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberService { 
	String loginCheck(Member dto, HttpSession session);
	void logout(HttpSession session);
	Member read(String id) throws SQLException;
	List<Member> readAll() throws SQLException;
	boolean create(Member user) throws Exception;
	boolean update(Member user) throws Exception;
	boolean delete(String id) throws Exception;
}
