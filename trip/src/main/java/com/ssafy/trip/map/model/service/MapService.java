package com.ssafy.trip.map.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.trip.map.dto.Gugun;
import com.ssafy.trip.map.dto.Sido;
import com.ssafy.trip.map.dto.TripInfo;

public interface MapService {
	List<Sido> selectSido() throws SQLException;
	List<Gugun> selectGugun(String sido_code) throws SQLException;
	List<Gugun> selectGugun() throws SQLException;
	List<TripInfo> selectTripInfo(String sido_code, String gugun_code, int content_type_id) throws SQLException;
}
