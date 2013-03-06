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

import com.cs400.waitermate.dao.order.IOrderService;
import com.cs400.waitermate.dao.order.OrderService;
import com.cs400.waitermate.dao.order.OrderServiceMock;
import com.cs400.waitermate.beans.OrderBean;


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
		checkService = new CheckServiceMock();
	}
	
	@Inject
	private static IOrderService orderService;
	{
		orderService = new OrderServiceMock();
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
	
	@Inject
	private static CheckBean currentCheck;
	{
		currentCheck = new CheckBean();
	}
	
	@Inject private static OrderBean currentOrder;
	{
		currentOrder = new OrderBean();
	}
	
	private WaiterBean reloadCurrentWaiter()
	{
		WaiterBean waiter = waiterService.findWaiterById(currentWaiter);
		return waiter;
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
			WaiterBean wb = new WaiterBean();
			wb = waiterService.findWaiterById(waiterBean);						
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
		System.out.println(currentWaiter.getCurrentTables().get(0).getCheckList().size());
		currentTable = currentWaiter.getSpecificTable(tableId);		
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);		
		return mav;
	}
	
	@RequestMapping(value = "/waiterTablePagePost", method = RequestMethod.POST)
	public ModelAndView goToWaiterHomePost(@ModelAttribute("tableBean")TableBean tableBean, Model model){
		tableBean.setWaiterID(currentWaiter.getID());
		tableService.addTable(tableBean);		
		//currentTable = currentWaiter.getSpecificTable(tableBean.getID());		
		currentWaiter.addTableToWaiter(tableBean);
		currentTable = tableBean;		
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		return mav;
		
	}
	
	@RequestMapping("/exitTable")
	public ModelAndView exitTable(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("waiterViews/waiterHome", "command", new TableBean());	
		mav.addObject("currentWaiter", currentWaiter);
		return mav;
	}
	
	@RequestMapping("/exitWaiter")
	public ModelAndView exitWaiter(HttpServletRequest request, HttpServletResponse response){
		// STORE INFORMATION ABOUT THIS WAITER AND HIS OBJECTS IN THE DATABASE BEFORE WE LEAVE
		return new ModelAndView("waiterViews/waiterLogIn", "command", new WaiterBean());
	}
	
	@RequestMapping("/addCheck")
	public ModelAndView addCheck(HttpServletRequest request, HttpServletResponse response){
		//long checkId = checkService.getNextCheckId();
		long checkId = 10101;
		CheckBean cb = new CheckBean(currentTable.getID(), checkId);	
		checkService.addCheck(cb);
		currentWaiter = this.reloadCurrentWaiter();
		currentTable = currentWaiter.getSpecificTable(currentTable.getID());
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);
		return mav;
	}
	
	@RequestMapping("/cancelOrderOnCheck")
	public ModelAndView cancelOrderOnCheck(HttpServletRequest request, HttpServletResponse response){		
		long orderId = Integer.parseInt(request.getParameter("orderId"));
		long checkId = Long.parseLong(request.getParameter("checkId"));
		orderService.cancelOrder(orderId, checkId);
		// in orderservice, the cancel order needs to change the comment in the order to "cancelled" and nothing else 
		// so that we can make changes to the table in the kitchen, they can then be notified of the difference
		// in case they already started cooking it.	
		currentWaiter = this.reloadCurrentWaiter();
		currentTable = currentWaiter.getSpecificTable(currentTable.getID());			
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);		
		return mav;
	}
	
	@RequestMapping("/payCheck")
	public ModelAndView payCheck(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("waiterViews/waiterPayCheck", "command", new CheckBean());
		long checkId = Long.parseLong(request.getParameter("checkId"));
		System.out.println("paying check " + checkId);
		currentCheck = currentTable.getSpecificCheck(checkId);
		mav.addObject("currentCheck", currentCheck);
		mav.addObject("subtotal2", currentCheck.getSubtotal());
		return mav;
	}
	
	@RequestMapping("payCheckCompleted")
	public ModelAndView payCheckCompleted(@ModelAttribute("checkBean")CheckBean checkBean, Model model){
		currentCheck.setTip(checkBean.getTip());
		currentCheck.setOpen(false);
		// NEED TO SAVE THE CHANGES TO THE DATABASE HERE
		// FOR REAL
		System.out.println("the tip is " + currentCheck.getTip());		
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);		
		return mav;
	}

}
