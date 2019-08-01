package pack.model;

import java.util.List;

import pack.controller.SkinBean;

public interface SkinDaoInter {
	List<SkinDto> getDataAll();
	boolean bookData(SkinBean bean);
	List<TimeDto> getDataTime(String dateVal);
	List<ProgRsvDto> getProgRsv(String gogek_id);
	boolean addProgCnt(String prog_order_no);
	boolean addProgCntState(String prog_order_no);
	ProgRsvDto getProgRsvByOrder(String prog_order_no);
	List<CareMgrDto> getCareMgr(String dateVal, String time_no);
	List<ReserveDto> getRsvList(String gogek_id);
	boolean updateRsv(SkinBean bean);
	boolean delRsv(String time_reserve_no);
	boolean subRsv(String prog_order_no); 
}