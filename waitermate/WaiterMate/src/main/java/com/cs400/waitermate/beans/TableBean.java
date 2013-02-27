package com.cs400.waitermate.beans;

import java.util.List;
import java.util.ArrayList;

import com.cs400.waitermate.beans.CheckBean;

public class TableBean {
	private int ID;
	private Boolean occupied;
	private List<CheckBean> checkList;
	
	
	public List<CheckBean> getCheckList() {
		return checkList;
	}
	public void setCheckList(List<CheckBean> checkList) {
		this.checkList = checkList;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	
	public TableBean(){
		this.ID = 0;
		this.occupied = true;
		checkList = new ArrayList<CheckBean>();
	}
	
	public TableBean(int id){
		this.ID = id;
		this.occupied = true;
		checkList = new ArrayList<CheckBean>();
	}
	
	public void addCheckToTable(CheckBean check){
		CheckBean cb = new CheckBean(this.ID);
		this.checkList.add(cb);
	}
	
	
}
