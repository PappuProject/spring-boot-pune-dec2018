package com.demo.spring.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
@Transactional
public class HrService {

	@Autowired
	private EmpDao dao;


	public String registerEmployee(int id, String name, String city, double sal) {

		String resp = dao.saveEmp(new Emp(id, name, city, sal));
		return resp;
	}
	
	
	public String findEmp(int id) {
		Emp e=dao.findById(id);
		if(e==null) {
			return "No Emp Found";
		}else {
			return e.getEmpId()+" "+e.getName()+" "+e.getSalary();
		}
	}
	
	public void printEmpList() {
		for(Emp e:dao.getAll()) {
			System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getSalary());
		}
	}
}
