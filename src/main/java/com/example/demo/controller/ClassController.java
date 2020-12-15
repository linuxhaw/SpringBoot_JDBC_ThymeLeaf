package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ClassDAO;
import com.example.demo.dto.ClassRequestDTO;
import com.example.demo.dto.ClassResponseDTO;
import com.example.demo.model.ClassBean;


@Controller
public class ClassController {
	@Autowired
	 ClassDAO dao;
	
	@ModelAttribute("classBean")
	public ClassBean getClassBean() {
		return new ClassBean();
	}

	
	@RequestMapping(value="/addclass", method=RequestMethod.GET)
	public ModelAndView addclass() {
		return new ModelAndView("BUD003","classBean",new ClassBean());
	}
	
	@RequestMapping(value="/ClassRegister",method=RequestMethod.POST)
	public String ClassRegister(@ModelAttribute("classBean")@Validated ClassBean bean,BindingResult bs,ModelMap model) {
		if(bs.hasErrors()) {
			model.addAttribute("class", bean);
			return "BUD003";
		}
		ClassRequestDTO dto=new ClassRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		
		List<ClassResponseDTO> list = dao.select(dto);
		if (list.size() != 0)
			model.addAttribute("err", "Class has been already exist!");
		else{
			int res = dao.insert(dto);
			if (res > 0)
				model.addAttribute("msg", "Insert successful");
			else
				model.addAttribute("err", "Insert fail");
		}
		
		return "BUD003";
	}
}
