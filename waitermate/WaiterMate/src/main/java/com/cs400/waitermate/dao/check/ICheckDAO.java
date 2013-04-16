package com.cs400.waitermate.dao.check;

import java.util.List;
import java.util.HashMap;
import javax.sql.DataSource;
import com.cs400.waitermate.beans.CheckBean;
import com.cs400.waitermate.beans.TableBean;

public interface ICheckDAO {

	public void setDataSource (DataSource dataSource);
	public HashMap<String, CheckBean> getChecks();
	public List<CheckBean> getCheckList();
	public CheckBean getCheckById(CheckBean check);
	public void deleteCheck(CheckBean check);
	public void updateCheck(CheckBean check);
	public int getCheckCount();
	public void addCheck(CheckBean check);
	public List<CheckBean> getCheckListByTable(TableBean table);
}
