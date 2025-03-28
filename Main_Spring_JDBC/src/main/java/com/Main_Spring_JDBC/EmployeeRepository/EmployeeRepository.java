package com.Main_Spring_JDBC.EmployeeRepository;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Main_Spring_JDBC.Employee;

@Repository
public class EmployeeRepository {

	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}


	public void save(Employee emp) {
//		System.out.println(emp);
//		System.out.println("Saved to Database...");
		
		String sql = "insert into Employee (EmpId, EmpName, EmpAddress) values (?,?,?)";
		
		int rows = jdbc.update(sql, emp.getEmpId(), emp.getEmpName(), emp.getEmpAddress());
		System.out.println(rows + " rows effected");
	}

	public List<Employee> findAll(Employee emp) {
		
		String sql = "select * from Employee";
		RowMapper<Employee> mapper = new RowMapper<>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee e = new Employee();
				e.setEmpId(rs.getInt("EmpId"));
				e.setEmpName(rs.getString("EmpName"));
				e.setEmpAddress(rs.getString("EmpAddress"));
				
				return e;
			}
			
			
		};
		
		return jdbc.query(sql, mapper);
	}

	
}
