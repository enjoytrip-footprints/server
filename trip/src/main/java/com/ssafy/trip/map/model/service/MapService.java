package com.ssafy.trip.map.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.map.dto.Gugun;
import com.ssafy.trip.map.dto.Sido;
import com.ssafy.trip.map.dto.TripInfo;

public interface MapService {
	List<Sido> selectSido() throws SQLException;
	List<Gugun> selectGugun(String sidoCode) throws SQLException;
	List<Gugun> selectGugun() throws SQLException;
	List<TripInfo> selectTripInfo(String sidoCode, String gugunCode, int content_type_id) throws SQLException;
	List<TripInfo> searchSpot(String keyword) throws SQLException;
	TripInfo readSpot(String planId) throws SQLException;
}
