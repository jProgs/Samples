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
import com.cs400.waitermate.beans.DrinkBean;
import com.cs400.waitermate.beans.FoodBean;
import com.cs400.waitermate.beans.WaiterBean;

import com.cs400.waitermate.dao.table.ITableService;
import com.cs400.waitermate.dao.table.TableService;
import com.cs400.waitermate.dao.table.TableServiceMock;
import com.cs400.waitermate.beans.TableBean;

import com.cs400.waitermate.dao.check.ICheckService;
import com.cs400.waitermate.dao.check.CheckService;
import com.cs400.waitermate.dao.check.CheckServiceMock;
import com.cs400.waitermate.dao.drinkorder.DrinkOrderService;
import com.cs400.waitermate.dao.drinkorder.IDrinkOrderService;
import com.cs400.waitermate.dao.foodorder.FoodOrderService;
import com.cs400.waitermate.dao.foodorder.IFoodOrderService;
import com.cs400.waitermate.beans.CheckBean;

import com.cs400.waitermate.dao.order.IOrderService;
import com.cs400.waitermate.dao.order.OrderService;
import com.cs400.waitermate.dao.order.OrderServiceMock;
import com.cs400.waitermate.beans.OrderBean;

import com.cs400.waitermate.beans.MenuBean;
import com.cs400.waitermate.dao.menu.*;
//import com.cs400.waitermate.dao.menu.*;
//import com.cs400.waitermate.dao.menu.MenuServiceMock;
//import com.cs400.waitermate.dao.menu.MenuService;

@Controller
public class WaiterController {
	
	@Inject
	private static IWaiterService waiterService;
	{
		waiterService = new WaiterService();		
	}
	
	@Inject 
	private static ITableService tableService;
	{
		tableService = new TableService();
	}
	
	@Inject
	private static ICheckService checkService;
	{
		checkService = new CheckService();
	}
	
	@Inject
	private static IOrderService orderService;
	{
		orderService = new OrderService();
	}
	
	@Inject
	private static IDrinkOrderService drinkOrderService;
	{
		drinkOrderService = new DrinkOrderService();
	}
	
	@Inject
	private static IFoodOrderService foodOrderService;
	{
		foodOrderService = new FoodOrderService();
	}
	
	@Inject
	private static IMenuService menuService;
	{
		menuService = new MenuService();		
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
	
	@Inject private static MenuBean currentMenu;
	{
		currentMenu = new MenuBean();
		currentMenu = menuService.loadMenu();
		currentMenu.updateCategoryList();
	}
	
	private WaiterBean reloadCurrentWaiter()
	{
		WaiterBean waiter = new WaiterBean();
		waiter.setID(currentWaiter.getID());
		waiter = waiterService.findWaiterById(waiter);
		waiter.setCurrentTables(tableService.getTablesByWaiter(waiter));
		for(TableBean tb: currentWaiter.getCurrentTables()){
			tb.setCheckList(checkService.getCheckListByTable(tb));
			if(tb.getCheckList().size() > 0){
				for(CheckBean cb: tb.getCheckList()){
					cb.setOrdersList(orderService.getOrdersByCheck(cb));
					
					for(OrderBean ob: cb.getOrdersList()){
						ob.setName(menuService.lookupOrderName(ob));
						ob.setPrice(menuService.lookupOrderPrice(ob));
					}	
				}
			}				
		}		
		return waiter;
	}
	
	
	@RequestMapping("/waiterLogIn")
	public ModelAndView goToWaiterLogIn(){
		if(currentMenu.getMenu().size() == 0)
		{
			currentMenu = menuService.loadMenu();
		}			
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
			currentWaiter.setCurrentTables(tableService.getTablesByWaiter(currentWaiter));
			
			for(TableBean tb: currentWaiter.getCurrentTables()){
				tb.setCheckList(checkService.getCheckListByTable(tb));
				if(tb.getCheckList().size() > 0){
					for(CheckBean cb: tb.getCheckList()){
						cb.setOrdersList(orderService.getOrdersByCheck(cb));
						
						for(OrderBean ob: cb.getOrdersList()){
							ob.setName(menuService.lookupOrderName(ob));
							ob.setPrice(menuService.lookupOrderPrice(ob));
						}	
						cb.updateMoneyTotals();
					}
				}				
			}		
			
			
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
		TableBean tb = new TableBean();
		tb.setID(tableId);		
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
		
		CheckBean cb = new CheckBean();	
		cb.setTable(currentTable.getID());
		cb.setID(checkService.insertBlankCheckForWaiter(cb));	
		currentTable.addCheckToTable(cb);	
		
		System.out.println("printing check id's");
		for(CheckBean check: currentTable.getCheckList())
		{
			System.out.println(check.getID());
		}
		
		currentWaiter.replaceTableById(currentTable);
		
		//currentWaiter = this.reloadCurrentWaiter();
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
		return mav;
	}
	
	@RequestMapping("payCheckCompleted")
	public ModelAndView payCheckCompleted(@ModelAttribute("checkBean")CheckBean checkBean, Model model){
		currentCheck.setTip(checkBean.getTip() + currentCheck.getTip());
		currentCheck.setOpen(false);
		currentCheck.reCalculateTotal();
		// NEED TO SAVE THE CHANGES TO THE DATABASE HERE
		// FOR REAL
		//System.out.println("the tip is " + currentCheck.getTip());		
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);		
		return mav;
	}
	
	@RequestMapping("/addTip")
	public ModelAndView addTip(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("waiterViews/waiterAddTip", "command", new CheckBean());
		long checkId = Long.parseLong(request.getParameter("checkId"));
		currentCheck = currentTable.getSpecificCheck(checkId);
		mav.addObject("currentCheck", currentCheck);
		return mav;
	}
	
	@RequestMapping("/addTipCompleted")
	public ModelAndView attTipCompleted(@ModelAttribute("checkBean")CheckBean checkBean, Model model){
		currentCheck.setTip(checkBean.getTip() + currentCheck.getTip());
		currentCheck.reCalculateTotal();
		// NEED TO SAVE THE CHANGES TO THE DATABASE HERE
		// FOR REAL DUDES
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);
		return mav;
	}
	
	@RequestMapping("/addOrder")
	public ModelAndView addOrder(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("menuViews/menuHome", "command", new OrderBean());
		long checkId = Long.parseLong(request.getParameter("checkId"));
		currentCheck = currentTable.getSpecificCheck(checkId);
		mav.addObject("currentCheck", currentCheck);
		// FETCH THE MENU FROM THE DATABASE IF IT ISN'T ALREADY LOADED
		currentMenu.updateCategoryList();
		mav.addObject("menuCategoriesList", currentMenu.getMenuCategoriesList());		
		mav.addObject("menu", currentMenu);
		System.out.println(currentMenu.getMenuCategoriesList().size() + " --- size of categories list");
		return mav;
	}
	
	@RequestMapping("/menuCategoryChosen")
	public ModelAndView menuCategoryChosen(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("menuViews/menuPickItem", "command", new OrderBean());
		mav.addObject("currentCategory", request.getParameter("category"));
		mav.addObject("menuBean", currentMenu);
		return mav;
	}
	
	@RequestMapping("/orderChosen")
	public ModelAndView orderChosen(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("menuViews/menuAddComment", "command", new OrderBean());
		currentOrder = currentMenu.createOrderFromName(request.getParameter("orderName"));
		mav.addObject("currentOrder", currentOrder);		
		return mav;		
	}
	
	@RequestMapping("/readyToAddOrder")
	public ModelAndView readyToAddOrder(@ModelAttribute("orderBean")OrderBean orderBean, Model model){
		ModelAndView mav = new ModelAndView("waiterViews/waiterTablePage", "command", new CheckBean());
		OrderBean order = orderBean;
		if(order.getCategory().equalsIgnoreCase("Beers") || order.getCategory().equalsIgnoreCase("Non Alcoholic Drinks")){
			DrinkBean db = new DrinkBean();
			db.setName(order.getName());
			db.setPrice(order.getPrice());
			db.setCategory(order.getCategory());
			db.setComment(order.getComment());
			db.setAbv(0);
			db.setMenuID(currentMenu.getOrderMenuItemID(order));
			db.setCheck(currentCheck.getID());
			db.setID(drinkOrderService.addOrderGetId(db));
			System.out.println("the drink has the id of " + db.getID());
			currentCheck.addOrder(db);
			
		}else{
			FoodBean fb = new FoodBean();
			fb.setName(order.getName());
			fb.setPrice(order.getPrice());
			fb.setCategory(order.getCategory());
			fb.setComment(order.getComment());
			fb.setSideID(1);
			fb.setMenuID(currentMenu.getOrderMenuItemID(order));
			fb.setCheck(currentCheck.getID());
			fb.setID(foodOrderService.addOrderGetId(fb));
			
			currentCheck.addOrder(fb);
		}
		//currentCheck.addOrder(order);
		currentTable.replaceCheck(currentCheck);
		currentWaiter.replaceTableById(currentTable);
		currentCheck.updateMoneyTotals();
		mav.addObject("currentWaiter", currentWaiter);
		mav.addObject("currentTable", currentTable);
		return mav;
	}
	
	
	
	
	/*
	 * END THE WAITERS STUFF
	 * END THE WAITERS STUFF
	 * END THE WAITERS STUFF
	 * 
	 * BEGIN THE KITCHEN STUFF
	 * BEGIN THE KITCHEN STUFF
	 * BEGIN THE KITCHEN STUFF
	 * BEGIN THE KITCHEN STUFF
	 */
	
	@RequestMapping("/kitchenHome")
	public ModelAndView kitchenHome(){
		ModelAndView mav = new ModelAndView("kitchenViews/kitchenHome");
		List<FoodBean> allOrders = new ArrayList<FoodBean>();
		allOrders = foodOrderService.listOrders();
		for(FoodBean fb: allOrders){
			//System.out.println(menuService.lookupOrderName(fb));
			fb.setName(menuService.lookupOrderName(fb));
		}
		mav.addObject("allOrders", allOrders);
		return mav;		
	}
	

	@RequestMapping("/orderUp")
	public ModelAndView orderUp(HttpServletRequest request, HttpServletResponse response){		
		ModelAndView mav = new ModelAndView("kitchenViews/kitchenHome");
		long orderId = Long.parseLong(request.getParameter("orderId"));
		mav.addObject("allOrders", orderService.listOrders());
		return mav;
	}
	
	
	
	
	/*
	 * END THE KITCHEN STUFF
	 * END THE KITCHEN STUFF
	 * END THE KITCHEN STUFF
	 * END THE KITCHEN STUFF
	 * 
	 * BEGIN THE ADMIN STUFF
	 * BEGIN THE ADMIN STUFF
	 * BEGIN THE ADMIN STUFF
	 * BEGIN THE ADMIN STUFF
	 * 
	 */
	
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin()
	{
		return new ModelAndView("adminViews/adminLogin", "command", new WaiterBean());		
		
	}
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.POST)
	public ModelAndView adminHome(@ModelAttribute("waiterBean")WaiterBean waiterBean, Model model)
	{
		if(waiterService.testWaiterAdminLogIn(waiterBean)){
			return new ModelAndView("adminViews/adminHome");
		}else
		{
			return new ModelAndView("adminViews/adminLogin", "command", new WaiterBean());
		}		
	}
	
	@RequestMapping("/adminAddNewWaiter")
	public ModelAndView adminAddNewWaiter(){
		ModelAndView mav = new ModelAndView("adminViews/adminAddNewWaiter", "command", new WaiterBean());
		mav.addObject("waiterList", waiterService.listWaiters());
		return mav;
	}
	
	@RequestMapping(value="/adminAddThisWaiter", method = RequestMethod.POST)
	public ModelAndView adminAddThisWaiter(@ModelAttribute("waiterBean")WaiterBean waiterBean, Model model){
		waiterService.addWaiter(waiterBean);
		return new ModelAndView("adminViews/adminHome");
	}
	
	@RequestMapping("/adminAddAdminRights")
	public ModelAndView adminAddAdminRights(){
		ModelAndView mav = new ModelAndView("adminViews/adminAddAdminRights", "command", new WaiterBean());
		mav.addObject("waiterList", waiterService.listWaiters());
		return mav;
	}

}
