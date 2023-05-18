package com.ssafy.trip.member.model.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.member.model.repo.MemberRepo;


@Component
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public Member read(String id) throws SQLException {
		return memberRepo.read(id);
	}
	@Override
	public List<Member> readAll() throws SQLException {
		return memberRepo.readAll();
	}
	@Override
	public boolean create(Member member) throws Exception {
		if(member.getId() == null || member.getPassword() == null || member.getEmail() == null || member.getName() == null) {
			throw new Exception();
		}
		return memberRepo.create(member)==1;
	}
	@Override
	public boolean update(Member member) throws Exception {
		return memberRepo.update(member)==1;
	}
	@Override
	public boolean delete(String id) throws Exception {
		return memberRepo.delete(id)==1;
	}
	
	@Override
	public String loginCheck(Member member, HttpSession session) {
	String name = memberRepo.loginCheck(member);
	 if (name != null) { // 세션 변수 저장
	  session.setAttribute("userid", member.getId());
	  session.setAttribute("name", name);
	}
	 return name; 
	}

	@Override
	public void logout(HttpSession session) {
	 session.invalidate(); // 세션 초기화
	 }

}
