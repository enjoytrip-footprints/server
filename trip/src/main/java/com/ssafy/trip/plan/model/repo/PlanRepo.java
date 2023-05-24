package com.ssafy.trip.plan.model.repo;


import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.plan.dto.Description;
import com.ssafy.trip.plan.dto.Plan;
import com.ssafy.trip.plan.dto.PlanInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface PlanRepo {
	int writePlan(Plan plan) throws SQLException;
	int writeDescription(Description description) throws SQLException;
	int writePlanInfo(PlanInfo planInfo) throws SQLException;
	Plan getLastPlan(String memberId) throws SQLException;
//	List<Plan> listPlan() throws SQLException;
	List<Plan> listMyPlan(String memberId) throws SQLException;
	Plan getPlan(int planId) throws SQLException;
	List<PlanInfo> getPlanInfo(String memberId) throws SQLException;
	List<Description> listMyDescription(int planId) throws SQLException;
//	int updateHit(Plan plan) throws SQLException;
//	int modifyPlan(Map<String, String> map) throws SQLException;
	int deletePlan(int planId) throws SQLException;
	int deleteDescription(int planId) throws SQLException;
	int deletePlanInfo(int planId) throws SQLException;
}
