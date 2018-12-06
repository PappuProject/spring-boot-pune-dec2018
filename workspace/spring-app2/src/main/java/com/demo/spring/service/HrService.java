package com.demo.spring.service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class HrService {

	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	public String registerEmployee(int id, String name, String city, double sal) {

		String resp = dao.saveEmp(new Emp(id, name, city, sal));
		return resp;
	}
}
