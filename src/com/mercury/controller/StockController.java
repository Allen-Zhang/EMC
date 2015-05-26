package com.mercury.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mercury.bean.Stock;
import com.mercury.service.YahooFinance;

// Auto-initialization: 
// any stateless bean with @Controller, @Service, @Repository will be created automatically, 
// but for stateful bean, we need to inject its field by @Autowired/@Resource, @Qualifier, 
// or by configuring the whole bean in <bean> in the config file.

@Controller
public class StockController {
	@Resource  // initialize a Collection field automatically ~ @Autowired
	private List<Stock> stocks;
	
	@RequestMapping(value="/market", method=RequestMethod.GET)
	@ResponseBody  // the viewResolver will be bypassed
	public List<Stock> marketData() {
		System.out.println("StockController executed!!!!");
		YahooFinance.marketData(stocks);
		return stocks;  // return a POJO, it will be converted to JSON automatically 
	}
	
	@RequestMapping(value="/home")
	public String homePage() {
		return "home";
	}

}
