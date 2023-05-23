package com.ssafy.trip.map.model.repo;

import java.sql.SQLException;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.map.dto.Gugun;
import com.ssafy.trip.map.dto.Sido;
import com.ssafy.trip.map.dto.TripInfo;

@Mapper
public interface MapRepo {
	List<Sido> selectSido() throws SQLException;
	List<Gugun> selectGugun(String sidoCode) throws SQLException;
	List<Gugun> selectGugun() throws SQLException;
	List<TripInfo> selectTripInfo(String sidoCode, String gugunCode, int content_type_id) throws SQLException;
	List<TripInfo> searchSpot(String keyword) throws SQLException;
	TripInfo readSpot(String planId) throws SQLException;
}
