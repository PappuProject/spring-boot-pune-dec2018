package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class EmpDaoJdbcImpl implements EmpDao{

	@Override
	public String saveEmp(Emp e) {
		// TODO Auto-generated method stub
		return "JDBC: Emp Saved..";
	}

}
