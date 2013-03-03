package com.cs400.waitermate.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs400.waitermate.dao.waiter.IWaiterService;
import com.cs400.waitermate.dao.waiter.WaiterService;
import com.cs400.waitermate.dao.waiter.WaiterServiceMock;
import com.cs400.waitermate.beans.WaiterBean;

import com.cs400.waitermate.dao.table.ITableService;
import com.cs400.waitermate.dao.table.TableService;
import com.cs400.waitermate.dao.table.TableServiceMock;
import com.cs400.waitermate.beans.TableBean;

import com.cs400.waitermate.dao.check.ICheckService;
import com.cs400.waitermate.dao.check.CheckService;
import com.cs400.waitermate.dao.check.CheckServiceMock;
import com.cs400.waitermate.beans.CheckBean;


@Controller
public class WaiterController {
	
	@Inject
	private static IWaiterService waiterService;
	{
		waiterService = new WaiterServiceMock();		
	}
	
	@Inject 
	private static ITableService tableService;
	{
		tableService = new TableServiceMock();
	}
	
	@Inject
	private static ICheckService checkService;
	{
		checkService = new CheckService();
	}
	
	@Inject
	private static WaiterBean currentWaiter;
	{
		currentWaiter = new WaiterBean();
	}
	
	@Inject
	private static TableBean currentTable;
	{
		currentTable = new TableBean();
	}
	
	
	@RequestMapping("/waiterLogIn")
	public ModelAndView goToWaiterLogIn(){
		return new ModelAndView("waiterViews/waiterLogIn", "command", new WaiterBean());
	}
	
	@RequestMapping(value = "/waiterHome", method = RequestMethod.POST)
	public ModelAndView goToWaiterHome(@ModelAttribute("waiterBean")WaiterBean waiterBean, Model model){
		if(waiterService.testWaiterLogIn(waiterBean))
		{
			ModelAndView mav1 = new ModelAndView("waiterViews/waiterHome", "command", new TableBean());
			WaiterBean wb = waiterService.findWaiterById(waiterBean);			
			currentWaiter = wb;
			mav1.addObject("currentWaiter", currentWaiter);
			return mav1;
		}else{
			ModelAndView mav2 = new ModelAndView("waiterViews/waiterLogIn", "command", new WaiterBean());
			return mav2;
		}
		
		
	}
	
	@RequestMapping("/waiterTablePage")
	public ModelAndView goToWaiterTablePage(HttpServletRequest request, HttpServletResponse response){
		
		int tableId = Integer.parseInt(request.getParameter("tableId"));
		System.out.println(tableId);
		currentTable = currentWaiter.getSpecificTable(tableId);
		
		//tableService.getTableCheckList(tableId);
		// for practice
		//TableBean tb = new TableBean();
		//tb.setCheckList(tableService.getTableCheckList(1));
		
		// need to find out here what the next check number will be		
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean(11));
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);
		//mav.addObject("tableCheckList", tb.getCheckList());
		return mav;
	}
	
	@RequestMapping(value = "/waiterTablePagePost", method = RequestMethod.POST)
	public ModelAndView goToWaiterHomePost(@ModelAttribute("tableBean")TableBean tableBean, Model model){
		tableService.addTable(tableBean);
		System.out.println(tableBean.getID());
		
		// need to get next check number and pass it into the constructor. May need to 
		// add into the constructor one with takes the table number also for simplicity. 
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean(12));
		return mav;
		
	}

}
