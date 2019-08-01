package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SkinBean;

@Repository
public class SkinDaoImpl implements SkinDaoInter {
	@Autowired
	private SkinAnnoInter annoInter;
	
	public List<SkinDto> getDataAll() {
		// TODO Auto-generated method stub
		return annoInter.getDataAll();
	}
	
	public List<TimeDto> getDataTime(String dateVal) {
		return annoInter.getDataTime(dateVal);
	}
	
	public boolean bookData(SkinBean bean) {
		return annoInter.book(bean);
	}
	public List<ProgRsvDto> getProgRsv(String gogek_id) {
		return annoInter.getProgRsv(gogek_id);
	}
	
	public boolean addProgCnt(String prog_order_no) {
		return annoInter.addProgCnt(prog_order_no);
	}
	public boolean addProgCntState(String prog_order_no) {
		return annoInter.addProgCntState(prog_order_no);
	}
	public ProgRsvDto getProgRsvByOrder(String prog_order_no) {
		return annoInter.getProgRsvByOrder(prog_order_no);
	}
	public List<CareMgrDto> getCareMgr(String date_val, String time_no) {
		return annoInter.getCareMgr(date_val, time_no);
	}
	public List<ReserveDto> getRsvList(String gogek_id){
		return annoInter.getRsvList(gogek_id);
	};
	
	public boolean updateRsv(SkinBean bean) {
		return annoInter.updateRsv(bean);
	};
	public boolean delRsv(String time_reserve_no) {
		return annoInter.delRsv(time_reserve_no);
	};
	
	public boolean subRsv(String prog_order_no) {
		return annoInter.subRsv(prog_order_no);
	};
}