package com.ssafy.trip.member.model.service;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.member.dto.Member;

public interface MemberService { 
	String loginCheck(Member dto, HttpSession session);
	void logout(HttpSession session);
	Member select(String id) throws SQLException;
	List<Member> selectAll() throws SQLException;
	boolean insert(Member user) throws Exception;
	boolean update(Member user) throws Exception;
	boolean delete(String id) throws Exception;
}
