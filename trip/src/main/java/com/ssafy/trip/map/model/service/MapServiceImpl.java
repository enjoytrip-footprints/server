package com.ssafy.trip.map.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.trip.map.dto.Gugun;
import com.ssafy.trip.map.dto.Sido;
import com.ssafy.trip.map.dto.TripInfo;
import com.ssafy.trip.map.model.repo.MapRepo;

@Component
public class MapServiceImpl implements MapService {

	@Autowired
	private MapRepo mapRepo;

	@Override
	public List<Sido> selectSido() throws SQLException {
		return mapRepo.selectSido();
	}
	@Override
	public List<Gugun> selectGugun(String sido_code) throws SQLException {
		return mapRepo.selectGugun(sido_code);
	}
	
	@Override
	public List<Gugun> selectGugun() throws SQLException {
		return mapRepo.selectGugun();
	}
	
	@Override
	public List<TripInfo> selectTripInfo(String sido_code, String gugun_code, int content_type_id) throws SQLException {
		return mapRepo.selectTripInfo(sido_code, gugun_code, content_type_id);
	}

}
