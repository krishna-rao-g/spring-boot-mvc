package com.spring.mvc.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.spring.mvc.aop.LogExecutionTime;

@Scope(value = "prototype")
@Service
public class EmployeeService {
	
	EmployeeService(){
		System.out.println("In employee service");
	}

	@LogExecutionTime
	// this is my jointpoint
	public void addEmployee() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Added Employee");
	}

}
