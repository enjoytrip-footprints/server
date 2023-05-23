package com.ssafy.trip.map.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.board.controller.BoardController;
import com.ssafy.trip.map.dto.Gugun;
import com.ssafy.trip.map.dto.Sido;
import com.ssafy.trip.map.dto.TripInfo;
import com.ssafy.trip.map.model.service.MapService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/mapapi")
public class MapController {
	
	@Autowired
	private MapService mapService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
//	@GetMapping("/sidofm")
//	protected String sidofm(Model model) throws ServletException, IOException, SQLException {
//		List<Sido> sido = mapService.selectSido();
//		model.addAttribute("sido", sido);
//		return "map/triparea";
//	}
	
//	@GetMapping("/sido")
//	protected void sido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//	      response.setContentType("application/json; charset=UTF-8");
//	      List<Sido> sido = mapService.selectSido();
//	      StringBuilder sb = new StringBuilder();
//	      sb.append("[");
//	      for(int i = 1; i <= sido.size(); i++) {
//	         sb.append("{\"rnum\":"+i+",\"code\":\""+sido.get(i-1).getSido_code()+"\",\"name\":\""+sido.get(i-1).getSido_name()+"\"}");
//	         if(i != sido.size()) sb.append(",");
//	         else sb.append("]");
//	      }
//	      response.setContentType("text/json");
//	      PrintWriter out = response.getWriter();
//	      out.println(sb);
//	      
//	}
	
//	@GetMapping("/gugun")
//	protected void gugun(@RequestParam String sido_code, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//	      response.setContentType("application/json; charset=UTF-8");
////	      String sido_code = request.getParameter("sido_code");
//	      List<Gugun> gugun = mapService.selectGugun(sido_code);
//	      StringBuilder sb = new StringBuilder();
//	      sb.append("[");
//	      for(int i = 1; i <= gugun.size(); i++) {
//	         sb.append("{\"rnum\":"+i+",\"code\":\""+gugun.get(i-1).getGugunCode()+"\",\"name\":\""+gugun.get(i-1).getGugun_name()+"\"}");
//	         if(i != gugun.size()) sb.append(",");
//	         else sb.append("]");
//	      }
//	      response.setContentType("text/json");
//	      PrintWriter out = response.getWriter();
//	      out.println(sb);
//	}
	
	@GetMapping("/sido")
	@ApiOperation(value="시도 정보를 리턴합니다..", response=Sido.class)
	public ResponseEntity<?> sido() throws Exception{
		List<Sido> sido = mapService.selectSido();
		if(sido != null) {
			return new ResponseEntity<List<Sido>>(sido, HttpStatus.OK); // 200
			
		}
		else {
			// 204 : 성공적으로 수행했으나 데이터가 없다
			log.debug("fail");
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping("/gugun")
	@ApiOperation(value="원하는 시도의 군구 정보를 리턴합니다..", response=Gugun.class)
	public ResponseEntity<?> gugun(@RequestParam("sido") String sidoCode) throws Exception{
		logger.debug(sidoCode);
		List<Gugun> gugun = mapService.selectGugun(sidoCode);
		if(gugun != null) {
			return new ResponseEntity<List<Gugun>>(gugun, HttpStatus.OK); // 200
		}
		else {
			// 204 : 성공적으로 수행했으나 데이터가 없다
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
		}
	}
	
	@GetMapping("/search/{keyword}")
	@ApiOperation(value="키워드를 입력해 여러 장소를 리턴합니다..", response=TripInfo.class)
	public ResponseEntity<?> searchSpot(@PathVariable() String keyword) throws Exception {
		List<TripInfo> spots = mapService.searchSpot(keyword);
		if (spots != null && !spots.isEmpty()) {
			return new ResponseEntity<List<TripInfo>>(spots, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/readSpot/{planId}")
	@ApiOperation(value="content_id를 입력해 장소를 리턴합니다..", response=TripInfo.class)
	public ResponseEntity<?> readSpot(@PathVariable() String planId) throws Exception {
		TripInfo spot = mapService.readSpot(planId);
		if (spot != null) {
			return new ResponseEntity<TripInfo>(spot, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
//	
//	// trip은 현재 미구현 상태. Database에서 여행지 정보를 리턴받음.
//	@GetMapping("/trip")
//	@ApiOperation(value="여행지 정보를 리턴합니다..", response=TripInfo.class)
//	public ResponseEntity<?> trip(@RequestParam("sido_code") String sido_code, @RequestParam("gugun_code") String gugun_code, @RequestParam("content_type_id") int content_type_id) throws Exception{
//		List<TripInfo> tripInfo = mapService.selectTripInfo(sido_code, gugun_code, content_type_id);
//		if(tripInfo!= null) {
//			return new ResponseEntity<List<TripInfo>>(tripInfo, HttpStatus.OK); // 200
//		}
//		else {
//			// 204 : 성공적으로 수행했으나 데이터가 없다
//			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT); // 204
//		}
//	}
	
	
	// trip 구현시 고쳐야 할 점 
	// 1. mapMapper : 모든 정보를 다 가져오는 것이 아닌 출력해야할 정보만 가져오기
	// 2. 컨트롤러에서 json 형식에 맞게 보내줘야함 
	// ( key 는 잘 보냈는데 value가 "가 안닫혀있고 그럼 )
	
//	@GetMapping("/trip")
//	protected void gugun(@RequestParam String sido_code, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//	      response.setContentType("application/json; charset=UTF-8");
////	      String sido_code = request.getParameter("sido_code");
//	      List<Gugun> gugun = mapService.selectGugun(sido_code);
//	      StringBuilder sb = new StringBuilder();
//	      sb.append("[");
//	      for(int i = 1; i <= gugun.size(); i++) {
//	         sb.append("{\"rnum\":"+i+",\"code\":\""+gugun.get(i-1).getGugun_code()+"\",\"name\":\""+gugun.get(i-1).getGugun_name()+"\"}");
//	         if(i != gugun.size()) sb.append(",");
//	         else sb.append("]");
//	      }
//	      response.setContentType("text/json");
//	      PrintWriter out = response.getWriter();
//	      out.println(sb);
//	}
}
