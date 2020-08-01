package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.aop.LogExecutionTime;
import com.spring.mvc.service.EmployeeService;

@Controller
public class AdminController {
	@Autowired
	EmployeeService employeeService;

	@LogExecutionTime
	@RequestMapping(value = "/add-employee", method = RequestMethod.GET)
	public String index() { // 26 ms
		employeeService.addEmployee(); //this took 2017ms
		return "admin";
	}
	
	@RequestMapping(value = "/add-project", method = RequestMethod.POST)
	public String addProject() {
		employeeService.addEmployee();
		return "admin";
	}
}
