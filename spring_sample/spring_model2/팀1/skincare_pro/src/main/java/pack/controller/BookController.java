package pack.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pack.model.ProgRsvDto;
import pack.model.SkinDaoInter;
import pack.model.TimeDto;

@Controller
public class BookController {
	@Autowired
	private SkinDaoInter daoInter;
	
	@RequestMapping(value="dayReserve", method=RequestMethod.POST)
	public String submit(SkinBean bean, HttpSession session) {
		boolean b = daoInter.bookData(bean); 
	
		if(b) {
			ProgRsvDto proRsvDto = daoInter.getProgRsvByOrder(bean.getProg_order_no()); // 예약한 prog_order
			int curCnt = Integer.parseInt(proRsvDto.getPro_order_reserve_cnt());
			int totCnt = Integer.parseInt(proRsvDto.getPro_order_cnt());
			if(curCnt + 1 == totCnt) { // 현재예약횟수에 1을 더한 값이 총 횟수와같으면 update set state=완료, cnt=횟수 +1
				daoInter.addProgCntState(bean.getProg_order_no());
			}else {
				daoInter.addProgCnt(bean.getProg_order_no()); //예약한 prog_orde_no 횟수 업데이트 
			}
			
			
			return "redirect:/rsvlist";
		}
		else
			return "error";
	}
	
}