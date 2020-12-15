package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dto.StudentRequestDTO;
import com.example.demo.dto.StudentResponseDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.StudentBean;
import com.example.demo.model.UserBean;

@Controller
public class StudentController {
	@Autowired
	 StudentDAO dao;
	
	@ModelAttribute("studentBean")
	public StudentBean getStudentBean() {
		return new StudentBean();
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(Model model) {
		return "BUD001";
	}
	
	@RequestMapping(value = "/studentsearch", method = RequestMethod.POST)
	public String studentsearch(@ModelAttribute("studentBean")@Validated StudentBean bean,Model model) {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(bean.getId());
		dto.setStudentName(bean.getName());
		dto.setClassName(bean.getClassName());
		List<StudentResponseDTO> list = dao.select(dto);
		if (list.size() == 0)
			model.addAttribute("msg", "Student not found!");
		else
			model.addAttribute("studentlist", list);
			return "BUD001";
	}
	
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public String addstudent(Model model) {
		model.addAttribute("studentBean", new StudentBean());
		return "BUD002";
	}
	
	@RequestMapping(value = "/studentRegister", method = RequestMethod.POST)
	public String studentRegister(@ModelAttribute("studentBean")@Validated StudentBean bean,BindingResult bs,Model model) {
		if(bs.hasErrors()) {
			return "BUD002";
		}
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(bean.getId());
		dto.setStudentName(bean.getName());
		dto.setStatus(bean.getStatus());
		dto.setClassName(bean.getClassName());
		dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
		List<StudentResponseDTO> list = dao.select(dto);
		if (list.size() != 0)
			model.addAttribute("err", "StudentId has been already exist!");
		else {
			int res = dao.insert(dto);
			if (res > 0)
				model.addAttribute("msg", "Insert successful");
			else {
				model.addAttribute("err", "Insert fail");
				return "BUD002";
			}
		}
		return "BUD002";
	}
	
	@RequestMapping(value = "/studentUpdate", method = RequestMethod.GET)
	public String studentUpdate(@RequestParam("name")String name,Model model) {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentName(name);
		dto.setStudentId("");
		dto.setClassName("");
		StudentResponseDTO res = dao.select(dto).get(0);
		StudentBean bean = new StudentBean();
		bean.setId(res.getStudentId());
		bean.setName(res.getStudentName());
		bean.setClassName(res.getClassName());
		bean.setYear(res.getRegisterDate().substring(0, 4));
		String month=res.getRegisterDate().substring(5, 7);
		String mo=month.substring(0,1);
		if(mo.equals("0")) {
			bean.setMonth(month.substring(1,2));
		}else {
			bean.setMonth(month);
		}
		String date=res.getRegisterDate().substring(8, 10);
		String da=date.substring(0,1);
		if(da.equals("0")) {
			bean.setDay(date.substring(1,2));
		}else {
			bean.setDay(date);
		}
		bean.setStatus(res.getStatus());
		model.addAttribute("studentBean", bean);
		return "BUD002-01";
	}
	
	@RequestMapping(value = "/studentUpdate", method = RequestMethod.POST)
	public String studentUpdate(@ModelAttribute("studentBean")@Validated StudentBean bean,BindingResult bs,Model model) {
		if(bs.hasErrors()) {
			return "BUD002-01";
		}
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(bean.getId());
		dto.setStudentName(bean.getName());
		dto.setStatus(bean.getStatus());
		dto.setClassName(bean.getClassName());
		dto.setRegisterDate(bean.getYear() + "-" + bean.getMonth() + "-" + bean.getDay());
		int res = dao.update(dto);
		if (res > 0)
			model.addAttribute("msg", "Update successful");
		else
			model.addAttribute("err", "Update fail");
			return "BUD002-01";
	}
	
	@RequestMapping(value = "/studentDelete", method = RequestMethod.POST)
	public String studentDelete(@ModelAttribute("studentBean")StudentBean bean,Model model) {
		StudentRequestDTO dto = new StudentRequestDTO();
		dto.setStudentId(bean.getId());
		int res = dao.delete(dto);
		if (res > 0)
			model.addAttribute("msg", "Delete successful");
		else
			model.addAttribute("err", "Delete fail");
			return "BUD002-01";
	}
	
	
}
