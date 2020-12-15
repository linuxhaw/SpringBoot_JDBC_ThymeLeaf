package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;

@Repository
public class StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(StudentRequestDTO dto) {
		int result=0;
		String sql="insert into student (student_id,student_name,class_name,register_date,status) values(?,?,?,?,?)";
		result=jdbcTemplate.update(sql,dto.getStudentId(),dto.getStudentName(),dto.getClassName(),dto.getRegisterDate(),dto.getStatus());
		return result;
	}
	
	public int update(StudentRequestDTO dto) {
		int result=0;
		String sql="update student set student_name=?,class_name=?,register_date=?,status=? where student_id=?";
		result=jdbcTemplate.update(sql,dto.getStudentName(),dto.getClassName(),dto.getRegisterDate(),dto.getStatus(),dto.getStudentId());
		return result;
	}
	
	public int delete(StudentRequestDTO dto) {
		int result=0;
		String sql="delete from student where student_id=?";
		result=jdbcTemplate.update(sql,dto.getStudentId());
		return result;
	}

	public List<StudentResponseDTO> select(StudentRequestDTO dto) {
		if (!dto.getStudentId().equals("")) {
			String sql = "select * from student where student_id=?";
			return jdbcTemplate.query(sql,
					(res,rowNum)->
			new StudentResponseDTO(res.getString("student_id")
					,res.getString("student_name")
					,res.getString("register_date"),res.getString("status"),res.getString("class_name"))
			,dto.getStudentId());
		}else if (!dto.getStudentName().equals("") || !dto.getClassName().equals("")) {
			String sql = "select * from student where student_name=? or class_name=?";
			return jdbcTemplate.query(sql,
					(res,rowNum)->
			new StudentResponseDTO(res.getString("student_id")
					,res.getString("student_name")
					,res.getString("register_date"),res.getString("status"),res.getString("class_name"))
			,dto.getStudentName(),dto.getClassName());
		}else {
			String sql = "select * from student";
			return jdbcTemplate.query(sql,
					(res,rowNum)->
			new StudentResponseDTO(res.getString("student_id")
					,res.getString("student_name")
					,res.getString("register_date"),res.getString("status"),res.getString("class_name")));
		}
	}
	
}
