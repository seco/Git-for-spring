package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.model.CareMgrDto;
import pack.model.SkinDaoInter;
import pack.model.SkinDto;
import pack.model.TimeDto;

@Controller
public class TimeController { // 시간 조회 json, 인력 json
	
	@Autowired
	@Qualifier("skinDaoImpl")
	private SkinDaoInter daoInter;
	
	@RequestMapping("timeList")
	@ResponseBody
	public Map timeList(@RequestParam("dateKey") String dateVal ) {
	//	System.out.println("timeList 메서드 호출 : " + dateVal);
		// SQL 예약시간 조회
		//System.out.println(dateVal);
		
		List<TimeDto> dataList = (List<TimeDto>)daoInter.getDataTime(dateVal);
		Map<String, Object>	result = new HashMap<String, Object>(); 
		result.put("datas", dataList);

		return result;
	}

	@RequestMapping("careMgrList")
	@ResponseBody
	public Map careMgrList(@RequestParam("dateKey") String date_val, @RequestParam("timeKey") String time_no) {
		System.out.println(date_val +"," + time_no);
		List<CareMgrDto> dataList = (List<CareMgrDto>)daoInter.getCareMgr(date_val, time_no);
		Map<String, Object>	result = new HashMap<String, Object>(); 
		result.put("datas", dataList);
		
		System.out.println("careMgrList 종");
		return result;
	}
	
}