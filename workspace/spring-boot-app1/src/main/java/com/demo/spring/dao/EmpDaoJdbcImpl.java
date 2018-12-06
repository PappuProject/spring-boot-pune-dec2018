package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	@Autowired
	private JdbcTemplate jt;

	@Override
	public String saveEmp(Emp e) {
		String insert_query = "insert into EMP(empno,name,address,salary) values(?,?,?,?)";
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insert_query);
				pst.setInt(1, e.getEmpId());
				pst.setString(2, e.getName());
				pst.setString(3, e.getCity());
				pst.setDouble(4, e.getSalary());
				return pst;
			}
		});
		if (count == 1)
			return "Emp Saved..";
		else
			return "Emp Not Saved";
	}

	@Override
	public Emp findById(int id) {
		Emp e = null;
		try

		{
			e = jt.queryForObject("select * from emp where empno=" + id, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

					return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
							rs.getDouble("SALARY"));
				}

			});
		} catch (Exception ex) {
			ex.printStackTrace();
			e = null;
		}
		return e;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList = jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {

				return new Emp(rs.getInt("EMPNO"), rs.getString("NAME"), rs.getString("ADDRESS"),
						rs.getDouble("SALARY"));
			}

		});
		return empList;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
