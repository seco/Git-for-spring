package pack.model;

import java.util.List;


import pack.controller.SkinSangBean;
import pack.upload.SkinSangUploadFile;

public interface SkinSangDaoInter {
	public List<SkinSangDto> getDataAll();
	public SkinSangDto selectPart(String num);
	public boolean insertData(SkinSangUploadFile uploadFile);
	public boolean updateData(SkinSangBean bean);
	public boolean deleteData(String num);
	public JikwonDto getLoginInfo(String jikwon_id);
	public List<MysangDto> mysang(String gogek_id);
	public GogekDto gogekLogin(String gogek_id);
	public boolean insertMysang(MysangDto dto);
	public int sang_order(SangOrderDto dto);
	public boolean sang_order_one(SangOrderDto dto); 
	public boolean sang_order_detail(SangOrderDto dto);
	public List<SangOrderDto> sang_order_list(String gogek_id);
}
