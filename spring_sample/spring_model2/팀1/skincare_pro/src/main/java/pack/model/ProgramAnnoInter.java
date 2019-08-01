package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.ProgramBean;

public interface ProgramAnnoInter {
	
	@Select("select * from program")
	public List<ProgramDto> getDataAll();
	
	@Select("select * from program where pro_no=#{pro_no}")
	public ProgramDto selectPart(String pro_no);
	
	@Select("select * from program where pro_cate=#{pro_cate}")
	public List<ProgramDto> getProgramByCate(String pro_cate);
	
	@Select("select * from program_cate")
	public List<CateDto> getAllCate();
	
	@Select("select * from program where pro_no=#{pro_no}")
	public ProgramDto getProgramDetail(String pro_no);
	
	@Select("select distinct(cate_name) from program inner join program_cate on pro_cate = cate_no")
	public List<String> selectcate();

	@Insert("insert into program(pro_name,pro_price,pro_detail,pro_cate) "
			+ "value(#{pro_name},#{pro_price}, #{pro_detail}, #{pro_cate})")
	public int insertData(ProgramBean bean);
	
	@Update("update program set pro_name=#{pro_name}, pro_price=#{pro_price}, pro_detail=#{pro_detail}, pro_image=#{pro_image},pro_cate=#{pro_cate} where pro_no=#{pro_no}")
	public int updateData(ProgramBean bean);
	
	@Delete("delete from program where pro_no=#{pro_no}")
	public int deleteData(String no);
	
	//---------------------
	
	// 카테고리 추가/삭제도 만들어야 됨..
	/*@Insert("insert into program_cate(cate_no, cate_name) value(#{cate_no},#{cate_name})");*/
	
}
