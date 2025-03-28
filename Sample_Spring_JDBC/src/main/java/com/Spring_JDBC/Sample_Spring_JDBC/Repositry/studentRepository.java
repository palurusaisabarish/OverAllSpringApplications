package com.Spring_JDBC.Sample_Spring_JDBC.Repositry;

import java.sql.ResultSet;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.Spring_JDBC.Sample_Spring_JDBC.student;

@Repository
public class studentRepository {

	private JdbcTemplate jdbc;
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	@Autowired
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void  save(student s) {
		//System.out.println(s);
		//System.out.println("Added to the Database...");
		String sql = "insert into student(id, name, marks) values(?,?,?)";
		int rows = jdbc.update(sql, s.getId(), s.getName(), s.getMarks());
		System.out.println(rows+" effected ");
	}

	public List<student> findAll() {
				//List<student> students = new ArrayList<>();
				//return students;
		
		String sql = "select * from student";
		
		RowMapper<student> mapper = (ResultSet rs, int rowNum) -> {
				
				student s = new student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				
				return s;
		};
		
		return jdbc.query(sql, mapper);
	}
}
