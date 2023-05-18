package com.ssafy.trip.board.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.board.dto.Board;
import com.ssafy.trip.board.dto.SearchCondition;

public interface BoardService {
	boolean writeArticle(Board board) throws Exception;
	List<Board> listArticle() throws Exception;
	Board getArticle(int articleNo) throws Exception;
	boolean modifyArticle(Board board) throws Exception;
	boolean deleteArticle(int articleNo) throws Exception;
	List<Board> searchByCondition(SearchCondition con);
}
