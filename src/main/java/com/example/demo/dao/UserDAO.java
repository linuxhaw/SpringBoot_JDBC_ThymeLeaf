package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(UserRequestDTO dto) {
		int result=0;
		String sql="insert into user (id,name,password) values(?,?,?)";
		result=jdbcTemplate.update(sql,dto.getId(),dto.getName(),dto.getPassword());
		return result;
	}
	
	public int update(UserRequestDTO dto) {
		int result=0;
		String sql="update user set name=?,password=? where id=?";
		result=jdbcTemplate.update(sql,dto.getName(),dto.getPassword(),dto.getId());
		return result;
	}
	
	public int delete(UserRequestDTO dto) {
		int result=0;
		String sql="delete from user where id=?";
		result=jdbcTemplate.update(sql,dto.getId());
		return result;
	}
	
	
	public List<UserResponseDTO> select(UserRequestDTO dto) {
		if (!dto.getId().equals("")) {
			String sql = "select * from user where id=?";
			return jdbcTemplate.query(sql, (rs,rowNum)->new UserResponseDTO(rs.getString("id"),rs.getString("name"),rs.getString("password")),dto.getId());
		}else if (!dto.getName().equals("")) {
			String sql = "select * from user where name=?";
			return jdbcTemplate.query(sql, (rs,rowNum)->new UserResponseDTO(rs.getString("id"),rs.getString("name"),rs.getString("password")),dto.getName());
		}else {
			String sql = "select * from user";
			return jdbcTemplate.query(sql, (rs,rowNum)->new UserResponseDTO(rs.getString("id"),rs.getString("name"),rs.getString("password")));
		}
	}
	
}
	
	
