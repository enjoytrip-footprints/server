package com.ssafy.trip.member.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ssafy.trip.member.dto.MemberLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.member.dto.MemberRegistDto;
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
	public boolean create(MemberRegistDto member) throws Exception {
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
	public Member login(MemberLoginDto memberDto) throws Exception {
		if (memberDto.getId() == null || memberDto.getPassword() == null)
			return null;
		return memberRepo.login(memberDto);
	}

	@Override
	public Member userInfo(String userid) throws Exception {
		return memberRepo.userInfo(userid);
	}

	@Override
	public void saveRefreshToken(String userid, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", refreshToken);
		memberRepo.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userid) throws Exception {
		return memberRepo.getRefreshToken(userid);
	}

	@Override
	public void deleRefreshToken(String userid) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("token", null);
		memberRepo.deleteRefreshToken(map);
	}
}
