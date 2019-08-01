package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository //db연결위해
public class BoardDao extends SqlSessionDaoSupport{
	@Autowired
	void setFactory(SqlSessionFactory factory){
		setSqlSessionFactory(factory);
	}
	
	public List getList(){
		return getSqlSession().selectList("selectAll");
	}
	
	public int addCount(String num){
		return getSqlSession().update("addCount", num);
	}
	
	public Board detail(String num){
		return getSqlSession().selectOne("selectDetail", num);
	}
	
	public int update(BoardBean bean){
		return getSqlSession().update("update", bean);
	}
	
	public int delete(String num){
		return getSqlSession().delete("delete", num);
	}
	
	public int insert(BoardBean bean){
		return getSqlSession().insert("insert", bean);
	}
	
	public List search(BoardBean bean){
		return getSqlSession().selectList("search", bean);
	}
}
