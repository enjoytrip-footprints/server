package com.ssafy.trip.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.trip.board.controller.BoardController;
import com.ssafy.trip.board.dto.Board;
import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.member.model.service.MemberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/member")
public class MemberController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value = "회원 등록", notes = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> doRegist(@RequestBody @ApiParam(value = "회원 정보.", required = true) Member member) throws Exception{
		if (memberService.create(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원 삭제", notes = "회원 id에 해당하는 회원 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/{memberId}")
	public ResponseEntity<String> deleteArticle(@PathVariable("memberId") @ApiParam(value = "삭제할 회원 id.", required = true) String memberId) throws Exception {
		logger.info("deleteArticle - 호출");
		if (memberService.delete(memberId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원 수정", notes = "수정할 회원 정보를 입력한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody @ApiParam(value = "수정할 회원 정보.", required = true) Member member) throws Exception {
		
		if (memberService.update(member)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "회원 정보", notes = "회원 id에 해당하는 회원의 정보를 반환한다.", response = Board.class)
	@GetMapping("/{memberId}")
	public ResponseEntity<Member> getArticle(@PathVariable("memberId") @ApiParam(value = "얻어올 회원 id.", required = true) String memberId) throws Exception {
		return new ResponseEntity<Member>(memberService.read(memberId), HttpStatus.OK);
	}
	

//	@PostMapping("/login")
//	protected String login(Member member, HttpSession session, Model model)
//			throws ServletException, IOException, SQLException {
//		String id = member.getId();
//		String password = member.getPassword();
//		Member user = ms.select(id);
//		if (user != null && user.getPassword().equals(password)) {
//			System.out.println("로그인성공");
//			session.setAttribute("userInfo", user);
//			return "redirect:/";
//
//		} else {
//			return "user/login";
//		}
//	}
//	
//	@GetMapping("/logout")
//	public String doLogout(HttpSession session) {
//		session.invalidate();
//		return "redirect:/";
//	}
//


}
