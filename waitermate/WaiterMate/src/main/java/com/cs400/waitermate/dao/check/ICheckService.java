package com.cs400.waitermate.dao.check;

import java.util.List;
import com.cs400.waitermate.beans.CheckBean;

public interface ICheckService {

	public List<CheckBean> listChecks();
	public void addCheck(CheckBean check);
	public void removeCheck(CheckBean check);
	public CheckBean findCheckById(CheckBean check);
	public void editCheck(CheckBean check);
	public long getNextCheckId();
}
