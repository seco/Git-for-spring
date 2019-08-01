package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.SkinSangBean;
import pack.upload.SkinSangUploadFile;

@Repository
public class SkinSangDaoImpl implements SkinSangDaoInter{
	  
	@Autowired
	private SkinSangAnnoInter memAnnoInter;
	
	public List<SkinSangDto> getDataAll() {
		return memAnnoInter.getDataAll();
	}
	
	public SkinSangDto selectPart(String num) {
		return memAnnoInter.selectPart(num);
	}
	
	public boolean insertData(SkinSangUploadFile uploadFile) {
		try {
			memAnnoInter.insertData(uploadFile);	
			return true;
			
		} catch (Exception e) {
			System.out.println("insertdateData err : " + e);
			return false;
		}
	}
	
	public boolean updateData(SkinSangBean bean) {
		
		try {
			
			System.out.println(bean.getSang_su());
			
			memAnnoInter.updateData(bean);	
			return true;
			
		} catch (Exception e) {
			System.out.println("updateData err : " + e);
			return false;
		}
		
	}
	
	public boolean deleteData(String num) {
		
		try {
			memAnnoInter.deleteData(num);		
			return true;
			
		} catch (Exception e) {
			System.out.println("deleteData err : " + e);
			return false;
		}
		
	}
	
	public JikwonDto getLoginInfo(String jikwon_id) {
		System.out.println(jikwon_id);
		
		return memAnnoInter.logininfo(jikwon_id);
	}
	
	public List<MysangDto> mysang(String gogek_id) {
		System.out.println("impl : " + gogek_id);
		return memAnnoInter.mysang(gogek_id);
	}
	
	public GogekDto gogekLogin(String gogek_id) {
		return memAnnoInter.gogekLogin(gogek_id);
	}
	
	public boolean insertMysang(MysangDto dto) {
		
		try {
			memAnnoInter.insertMysang(dto);		
			return true;
			
		} catch (Exception e) {
			System.out.println("insertMysang err : " + e);
			return false;
		}
	}
	
	public int sang_order(SangOrderDto dto) {
		
		try {
			System.out.println(dto.getGogek_id());
			memAnnoInter.sang_order(dto);
			int max = memAnnoInter.max_sang_order_no();
			System.out.println("max : " + max);
			return max;			
		} catch (Exception e) {
			System.out.println("sang_order err : " + e);
			int max = memAnnoInter.max_sang_order_no();
			return max;
		}
	}
	
	public boolean sang_order_one(SangOrderDto dto) {
		
		try {
			System.out.println(dto.getSang_order_no());
			System.out.println(dto.getSang_no());
			System.out.println(dto.getSang_order_cnt());
			
			memAnnoInter.sang_order_one(dto);
			
			return true;			
		} catch (Exception e) {
			System.out.println("sang_order_one err : " + e);
			return false;
		}
	}
	
	public boolean sang_order_detail(SangOrderDto dto) {
		try {
			System.out.println("dd");
			
			memAnnoInter.sang_order_detail(dto);
			
			return true;			
		} catch (Exception e) {
			System.out.println("sang_order_detail err : " + e);
			return false;
		}
	}
	
	public List<SangOrderDto> sang_order_list(String gogek_id) {
		List<SangOrderDto> list = memAnnoInter.sang_order_list(gogek_id);
		return list;
	}
	
}
