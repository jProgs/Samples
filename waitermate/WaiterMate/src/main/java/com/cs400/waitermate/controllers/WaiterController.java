package com.cs400.waitermate.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cs400.waitermate.dao.*;
import com.cs400.waitermate.dao.waiter.IWaiterService;
import com.cs400.waitermate.dao.waiter.WaiterService;


@Controller
public class WaiterController {
	
	@Inject
	private static IWaiterService waiterService;
	{
		waiterService = new WaiterService();
	}

}
