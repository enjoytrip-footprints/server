package com.ssafy.trip.board.model.repo;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.board.dto.Board;
import com.ssafy.trip.board.dto.SearchCondition;

@Mapper
public interface BoardRepo {
	int writeArticle(Board board) throws SQLException;
	List<Board> listArticle() throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	Board getArticle(int articleNo) throws SQLException;
	int updateCnt(Board board) throws SQLException;
	int modifyArticle(Board board) throws SQLException;
	int deleteArticle(int articleNO) throws SQLException;
	List<Board> searchByCondition(SearchCondition con);
}
