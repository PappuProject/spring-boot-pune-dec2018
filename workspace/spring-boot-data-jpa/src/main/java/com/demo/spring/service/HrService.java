package com.demo.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpRepository;
import com.demo.spring.entity.Emp;

@Service
@Transactional
public class HrService {

	@Autowired
	private EmpRepository dao;

	public String registerEmployee(int id, String name, String city, double sal) {

		Emp e = dao.save(new Emp(id, name, city, sal));
		return "Saved successfully";
	}

	public String findEmp(int id) {
		Optional<Emp> o = dao.findById(id);
		if (o.isPresent()) {
			Emp e = o.get();
			return e.getEmpId() + " " + e.getName() + " " + e.getSalary();
		} else {
			return "Emp not Found";
		}
	}

	public void printEmpList() {
		for (Emp e : dao.findAll()) {
			System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary());
		}
	}
	
	
	public void printEmpWithSal(double sal1, double sal2) {
		for(Emp e : dao.getEmpSalBtween(sal1, sal2)) {
			System.out.println(e.getEmpId() + " " + e.getName() + " " + e.getSalary());
		}
	}
}
