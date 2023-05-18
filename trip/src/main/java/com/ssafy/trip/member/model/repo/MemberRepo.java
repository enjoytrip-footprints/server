package com.ssafy.trip.member.model.repo;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.member.dto.Member;

@Mapper
public interface MemberRepo {
	String loginCheck(Member dto);
	Member select(String id) throws SQLException;
	List<Member> selectAll() throws SQLException;
	int insert(Member user) throws SQLException;
	int update(Member user) throws SQLException;
	int delete(String id) throws SQLException;
}
