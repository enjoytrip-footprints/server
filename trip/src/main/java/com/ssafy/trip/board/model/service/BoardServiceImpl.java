package com.ssafy.trip.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.trip.board.dto.Board;
import com.ssafy.trip.board.dto.SearchCondition;
import com.ssafy.trip.board.model.repo.BoardRepo;

@Component
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepo boardRepo;

	@Override
	public Board getArticle(int articleNo) throws Exception {
		Board board = boardRepo.getArticle(articleNo);
		boardRepo.updateCnt(board);
		return board;
	}

	@Override
	public boolean writeArticle(Board board) throws Exception {
		if(board.getTitle() == null || board.getArticle() == null) {
			throw new Exception();
		}
		return boardRepo.writeArticle(board)==1;
	}


	@Override
	@Transactional
	public boolean deleteArticle(int articleNo) throws Exception {
		return boardRepo.deleteArticle(articleNo) == 1;
	}

	@Override
	@Transactional
	public boolean modifyArticle(Board board) throws Exception {
		return boardRepo.modifyArticle(board) == 1;
	}

	@Override
	@Transactional
	public List<Board> listArticle() throws Exception {
		return boardRepo.listArticle();
	}
	
	@Override
	public List<Board> searchByCondition(SearchCondition con) {
		return boardRepo.searchByCondition(con);
	}
}
