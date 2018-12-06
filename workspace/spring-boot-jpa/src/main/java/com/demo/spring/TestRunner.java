package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.spring.service.HrService;

@Component
public class TestRunner implements CommandLineRunner {
	@Autowired
	HrService service;

	@Override
	public void run(String... args) throws Exception {
	System.out.println(service.registerEmployee(106, "Pinku", "Bhopal", 67000));
		
		service.printEmpList();
		
		
		System.out.println(service.findEmp(106));

	}

}
