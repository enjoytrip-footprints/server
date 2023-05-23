package com.ssafy.trip.plan.model.service;

import com.ssafy.trip.plan.dto.Description;
import com.ssafy.trip.plan.dto.Plan;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface PlanService {
	int writePlan(Plan plan) throws Exception;
	void writeDescription(List<Description> description) throws SQLException;
	List<Plan> listMyPlan(String memberId) throws SQLException;
	Plan getPlan(int planId) throws SQLException;
	List<Description> listMyDescription(int planId) throws SQLException;
//	List<Plan> listPlan() throws Exception;
//	List<Plan> listMyPlan(String userId) throws Exception;
//	Plan getPlan(int planId) throws Exception;
//	void modifyPlan(Map<String, String> map) throws Exception;
//	void deletePlan(int planId) throws Exception;
//	List<Plan> searchByCondition(SearchCondition con);
}
