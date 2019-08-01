package controller;

import model.DataDao;

public class SelectServiceImpl implements SelectService {

	private DataDao dataDao; //다형성을 위해 부모의 이름을 사용
	
	//생성자 통해 주입 
	public SelectServiceImpl(DataDao dataDao) {
		System.out.println("SelectServiceImpl 생성자");
		this.dataDao = dataDao;
	}
	
	@Override
	public void selectProcess() {
		System.out.println("selectProcess 수행");
		dataDao.selectData();
	}
	

}
