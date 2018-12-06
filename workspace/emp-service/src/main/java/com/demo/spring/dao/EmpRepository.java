package com.demo.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	@Query(name="q1",value="select e from Emp e where e.salary between ?1 and ?2")
	public List<Emp> getEmpSalBtween(double sal1, double sal2);

}
