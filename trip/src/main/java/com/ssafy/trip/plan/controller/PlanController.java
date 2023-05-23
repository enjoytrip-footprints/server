package com.ssafy.trip.plan.controller;

import com.ssafy.trip.member.dto.Member;
import com.ssafy.trip.plan.dto.Description;
import com.ssafy.trip.plan.dto.Plan;
import com.ssafy.trip.plan.model.service.PlanService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
@CrossOrigin("*")
@RequestMapping("/plan")
public class PlanController {
	
	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private PlanService planService;


//
//	@ApiOperation(value = "후기 리스트",  response = String.class)
//	@GetMapping("/getPlanList")
//	public ResponseEntity<?> getPlanList() {
//		try {
//			List<Plan> plans = planService.listPlan();
//			if (plans != null && !plans.isEmpty()) {
//				return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//		}
//	}
//


	@ApiOperation(value = "계획 작성",  response = String.class)
	@PostMapping("/write")
	public ResponseEntity<?> writePlan(@RequestBody Plan plan) throws Exception{
		try {
			planService.writePlan(plan);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "세부 계획 작성",  response = String.class)
	@PostMapping("/writeDes")
	public ResponseEntity<?> writeDes(@RequestBody Description description){
		try{
			planService.writeDescription(description); 
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "해당 유저 마지막 작성 계획 조회", response = String.class)
	@GetMapping("/getLast/{memberId}")
	public ResponseEntity<?> getLast(@PathVariable("memberId") String memberId) {
		try {
			Plan plan = planService.getLastPlan(memberId);
			logger.debug("플랜:"+plan);
			if (plan != null) {
				return new ResponseEntity<Plan>(plan, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "특정인 계획 리스트",  response = String.class)
	@GetMapping("/getPlanList/{memberId}")
	public ResponseEntity<?> getMyPlanList(@PathVariable("memberId") String memberId) {
		try {
			List<Plan> plans = planService.listMyPlan(memberId);
			if (plans != null && !plans.isEmpty()) {
				return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "특정인 계획 조회", response = String.class)
	@GetMapping("/{planId}")
	public ResponseEntity<?> getPlan(@PathVariable("planId") int planId) {
		try {
			Plan plan = planService.getPlan(planId);
			if (plan != null) {
				return new ResponseEntity<Plan>(plan, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "특정인 세부계획 리스트",  response = String.class)
	@GetMapping("/getDesList/{planId}")
	public ResponseEntity<?> getMyDesList(@PathVariable("planId") int planId) {
		try {
			List<Description> dess = planService.listMyDescription(planId);
			if (dess != null && !dess.isEmpty()) {
				return new ResponseEntity<List<Description>>(dess, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		}
	}
	
//	@PutMapping("/modify")
//	public ResponseEntity<?> modifyPlan(@RequestBody Map<String, String> map) {
//		try {
//			planService.modifyPlan(map);
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//		}
//	}
//
//	@DeleteMapping("/{planId}")
//	public ResponseEntity<?> deletePlan(@PathVariable("planId") int planId) {
//		try {
//			planService.deletePlan(planId);
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//		}
//	}

//	@GetMapping("/search")
//	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = Plan.class)
//	public ResponseEntity<?> search(SearchCondition con) {
//
//		List<Plan> plans = planService.searchByCondition(con);
//		if (plans != null && plans.size() > 0) {
//			return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		}
//	}

}
