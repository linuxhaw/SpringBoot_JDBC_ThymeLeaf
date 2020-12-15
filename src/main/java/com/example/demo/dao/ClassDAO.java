package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ClassRequestDTO;
import com.example.demo.dto.ClassResponseDTO;
import com.example.demo.dto.UserResponseDTO;


@Repository
public class ClassDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(ClassRequestDTO dto) {
		int result=0;
		String sql="insert into class (id,name) values(?,?)";
		result=jdbcTemplate.update(sql,dto.getId(),dto.getName());
		return result;
	}
	
	
	public List<ClassResponseDTO> select(ClassRequestDTO dto) {
		if (!dto.getId().equals("") || !dto.getName().equals("")) {
			String sql = "select * from class where id=? or name=?";
			return jdbcTemplate.query(sql, (res,rowNum)->new ClassResponseDTO(res.getString("id"),res.getString("name")),dto.getId(),dto.getName());
		}else {
			String sql = "select * from class";
			return jdbcTemplate.query(sql, (res,rowNum)->new ClassResponseDTO(res.getString("id"),res.getString("name")));
		}
	}
	
}
