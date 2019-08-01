package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.ProgramBean;
import pack.controller.SkinSangBean;
import pack.upload.SkinSangUploadFile;

public interface SkinSangAnnoInter {
	
	@Select("select * from skinsang")
	public List<SkinSangDto> getDataAll();
	
	@Select("select * from skinsang where sang_no=#{sang_no}")
	public SkinSangDto selectPart(String num);
	
	@Insert("insert into skinsang(sang_Bname,sang_Pname,sang_price,sang_su,sang_detail,sang_image) "
			+ "value(#{sang_Bname},#{sang_Pname}, #{sang_price}, #{sang_su}, #{sang_detail}, #{sang_image})")
	public int insertData(SkinSangUploadFile uploadFile);
	
	@Update("update skinsang set sang_Bname=#{sang_Bname}, sang_Pname=#{sang_Pname}, sang_price=#{sang_price}, sang_su=#{sang_su},sang_detail=#{sang_detail} where sang_no=#{sang_no}")
	public int updateData(SkinSangBean bean);
	
	@Delete("delete from skinsang where sang_no=#{sang_no}")
	public int deleteData(String num);
	
	@Select("select * from jikwoninfo where jikwon_id=#{jikwon_id}")
	public JikwonDto logininfo(String jikwon_id);
	
	@Select("select * from mysang where gogek_id=#{gogek_id}" )
	public List<MysangDto> mysang(String gogek_id);
	
	@Select("select * from gogekinfo where gogek_id=#{gogek_id}")
	public GogekDto gogekLogin(String gogek_id);
	
	@Select("select max(sang_order_no) from sang_order")
	public int max_sang_order_no();
	
	@Select("select s.sang_order_no, gogek_id, register_date, state, ss.sang_Pname, sang_order_cnt\r\n" + 
			"from skinsang ss, sang_order s inner join sang_order_detail d on s.sang_order_no = d.sang_order_no \r\n" + 
			"where  ss.sang_no = d.sang_no and s.gogek_id=#{gogek_id} order by s.sang_order_no")
	public List<SangOrderDto> sang_order_list(String gogek_id);
	
	@Insert("insert into mysang values(#{gogek_id},#{sang_no},#{sang_Pname},#{sang_su})")
	public int insertMysang(MysangDto dto);
	
	@Insert("insert into sang_order(gogek_id, register_date, state) values(#{gogek_id},now(),'비승인')")
	public boolean sang_order(SangOrderDto dto);
	
	@Insert("insert into sang_order_detail(sang_order_no, sang_no, sang_order_cnt) values(#{sang_order_no},#{sang_no},#{sang_order_cnt})")
	public boolean sang_order_one(SangOrderDto dto);
	
	@Insert("insert into sang_order_detail values(#{sang_order_no},#{sang_no},#{sang_order_cnt})")
	public boolean sang_order_detail(SangOrderDto dto);
}
