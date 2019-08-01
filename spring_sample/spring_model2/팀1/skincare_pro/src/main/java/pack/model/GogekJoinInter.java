package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

import pack.controller.GogekBean;

//모델
public interface GogekJoinInter {
	GogekDto selectGogek(String gogek_id) throws DataAccessException;
	boolean gogekInsert(GogekBean bean) throws DataAccessException;
	boolean updateGogek(GogekBean bean) throws DataAccessException;
	boolean deleteData(String num) throws DataAccessException;
}
