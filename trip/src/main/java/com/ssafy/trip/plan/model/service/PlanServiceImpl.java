package com.ssafy.trip.plan.model.service;


import com.ssafy.trip.plan.dto.Description;
import com.ssafy.trip.plan.dto.Plan;
import com.ssafy.trip.plan.dto.PlanInfo;
import com.ssafy.trip.plan.model.repo.PlanRepo;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class PlanServiceImpl implements PlanService {

	
	private static final Logger log = LoggerFactory.getLogger(PlanServiceImpl.class);

	
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
	public int writeDescription(Description description) throws SQLException {
		return planRepo.writeDescription(description);
	}
	
	@Override
	public Plan getLastPlan(String memberId) throws SQLException {
//		log.debug("아이디 : "+memberId);
//		String temp = planRepo.getLastPlan(memberId);
//		log.debug("리턴값 : "+ temp);
//		return temp;
		return planRepo.getLastPlan(memberId);
		
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

	@Override
	public int writePlanInfo(PlanInfo planInfo) throws SQLException {
		return planRepo.writePlanInfo(planInfo);
	}

	@Override
	public List<PlanInfo> getPlanInfo(String memberId) throws SQLException {
		return planRepo.getPlanInfo(memberId);
	}

	@Override
	public int deleteAll(int planId) throws SQLException {
		planRepo.deleteDescription(planId);
		planRepo.deletePlanInfo(planId);
		return planRepo.deletePlan(planId);
	}
}
