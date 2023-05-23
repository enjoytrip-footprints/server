package com.ssafy.trip.plan.model.service;

import com.ssafy.trip.plan.dto.Description;
import com.ssafy.trip.plan.dto.Plan;
import com.ssafy.trip.plan.model.repo.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;

//	@Override
//	public Plan getPlan(int planId) throws Exception {
//		Plan plan = planRepo.getPlan(planId);
//		planRepo.updateHit(plan);
//		return plan;
//	}

	@Override
	public int writePlan(Plan plan) throws Exception {
		return planRepo.writePlan(plan);
	}
	
	@Override
	public void writeDescription(List<Description> description) throws SQLException {
		for(Description d : description) {
			planRepo.writeDescription(d);
		}
	}

	@Override
	public List<Plan> listMyPlan(String memberId) throws SQLException {
		return planRepo.listMyPlan(memberId);
	}

	@Override
	public Plan getPlan(int planId) throws SQLException {
		return planRepo.getPlan(planId); 
	}

	@Override
	public List<Description> listMyDescription(int planId) throws SQLException {
		return planRepo.listMyDescription(planId);
	}

//	@Override
//	@Transactional
//	public void deletePlan(int planId) throws Exception {
//		planRepo.deletePlan(planId);
//	}
//
//	@Override
//	@Transactional
//	public void modifyPlan(Map<String, String> map) throws Exception {
//		planRepo.modifyPlan(map);
//	}
//
//	@Override
//	@Transactional
//	public List<Plan> listPlan() throws Exception {
//		return planRepo.listPlan();
//	}
//
//	@Override
//	@Transactional
//	public List<Plan> listMyPlan(String userId) throws Exception {
//		return planRepo.listMyPlan(userId);
//	}
	
//	@Override
//	public List<Plan> searchByCondition(SearchCondition con) {
//		return planRepo.searchByCondition(con);
//	}
}
