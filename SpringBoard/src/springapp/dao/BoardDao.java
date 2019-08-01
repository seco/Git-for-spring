package springapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.sun.corba.se.spi.orbutil.fsm.State;

public class BoardDao {

	private DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public int count() throws Exception {
		int result = -1;
		Connection con = null;
		Statement stmt = null;
		
		try{
			con = ds.getConnection();   //DB客 楷搬
			stmt = con.createStatement();   //按眉 积己
			String sql = "select count(*) CNT from board";
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			result = rs.getInt("CNT");
		} finally {
			close(con, stmt);
		}
		return result;
		
	}
	
	private void close(Connection con, Statement stmt) {
		try {
			if(con!=null){
				con.close();
			}
		} catch (Exception e) {}
		try {
			if(stmt!=null){
				stmt.close();
			}
		} catch (Exception e) {}
	}
}
