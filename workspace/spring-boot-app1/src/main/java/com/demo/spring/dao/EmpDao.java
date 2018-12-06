package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {

	public String saveEmp(Emp e);
	public Emp findById(int id);
	public List<Emp> getAll();
	public String delete(int id);
}
