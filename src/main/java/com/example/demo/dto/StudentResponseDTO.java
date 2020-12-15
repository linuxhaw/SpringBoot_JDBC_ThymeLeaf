package com.example.demo.dto;

public class StudentResponseDTO {
	private String studentId;
	private String studentName;
	private String registerDate;
	private String status;
	private String className;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public StudentResponseDTO(String studentId, String studentName, String registerDate, String status,
			String className) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.registerDate = registerDate;
		this.status = status;
		this.className = className;
	}
	
	
}
