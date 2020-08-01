package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.service.EmployeeService;

@Controller
public class EmployeeControler {
	
	@Autowired
	EmployeeService employeeService;

	@Value("${message}")
	private String valueFromFile;
	
	@Value("${port}")
	private int port;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "login";
	}

	@RequestMapping(value = "/timesheet", method = RequestMethod.GET)
	public String sayHello(@RequestParam String username, @RequestParam String password, ModelMap model) {
		// is username pwd is admin/admin
		if (username.equals("admin") && password.equals("admin")) {
			// we pass data from java controller to jsp
			model.addAttribute("message", valueFromFile);
			model.addAttribute("port", port);
			// then return admin page
			return "admin";
			// if user is user/user
		} else if (username.equals("user") && password.equals("password")) {
			// timesheet page
			return "timesheet";
		}
		// if no match for user/admin return login page
		return "login";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminView(ModelMap model) {
		model.addAttribute("message", valueFromFile);
		return "admin";
	}
	
	@RequestMapping(value = "/employee-info", method = RequestMethod.GET)
	public String employeInfo(ModelMap model) {
		model.addAttribute("message", valueFromFile);
		return "admin";
	}

}