package com.cs400.waitermate.dao.check;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import com.cs400.waitermate.beans.CheckBean;



public class CheckServiceMock implements ICheckService{

	private static List<CheckBean>checks;
	{
		checks = new ArrayList<CheckBean>();
		
		// add checks here  to be passed around.
	
	}
	
	@Override
	public List<CheckBean> listChecks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CheckBean findCheckById(CheckBean check) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editCheck(CheckBean check) {
		// TODO Auto-generated method stub
		
	}

}
