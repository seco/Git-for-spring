package pack.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.GogekBean;



public interface GogekJoinAnnoInter {

	@Insert("insert into gogekinfo(gogek_id, gogek_name, gogek_password, gogek_phone) values(#{gogek_id},#{gogek_name},#{gogek_password}, #{gogek_phone})")
	public boolean gogekInsert(GogekBean bean);
	
	
	@Select("select * from gogekinfo where gogek_id=#{gogek_id}")
	public GogekDto selectGogek(String gogek_id);
	
	@Update("update gogekinfo set gogek_password=#{gogek_password}, gogek_name=#{gogek_name}, gogek_phone=#{gogek_phone} where gogek_id=#{gogek_id}")
	public boolean gogekUpdate(GogekBean bean);
}
