package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;


public class EmpDaoJPAImpl implements EmpDao{

	@Override
	public String saveEmp(Emp e) {
		// TODO Auto-generated method stub
		return "JPA: Emp Saved..";
	}

}
