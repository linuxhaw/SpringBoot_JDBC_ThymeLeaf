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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.UserBean;

@Controller
public class UserController {
	@Autowired
	 UserDAO dao;
	
	@ModelAttribute("userBean")
	public UserBean getUserBean() {
		return new UserBean();
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(Model model) {
		return "USR001";
	}
	
	@RequestMapping(value = "/userSearch", method = RequestMethod.POST)
	public String userSearch(@ModelAttribute("userBean")UserBean bean,Model model) {
		UserRequestDTO dto=new UserRequestDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		List<UserResponseDTO> list = dao.select(dto);
		if (list.size() == 0)
			model.addAttribute("msg", "User not found!");
		else
			model.addAttribute("userlist", list);
			return "USR001";
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	public ModelAndView adduser() {
		return new ModelAndView ("USR002","userBean",new UserBean());
	}
	
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute("userBean")@Validated UserBean bean,BindingResult bs,Model model) {
		if(bs.hasErrors()){
			return "USR002";
		}
		if (bean.getPassword().equals(bean.getConfirm())) {
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			dto.setPassword(bean.getPassword());
			List<UserResponseDTO> list = dao.select(dto);
			if (list.size() != 0) {
				model.addAttribute("user",bean);
				model.addAttribute("err", "UserId has been already exist!");
			}else {
				int res = dao.insert(dto);
				if (res > 0) {
					model.addAttribute("msg", "Insert successful");
					model.addAttribute("user", new UserBean());
					return "USR001";
				}else {
					model.addAttribute("err", "Insert fail");
					return "USR001";
				}
			}
		} else
			model.addAttribute("err", "Password are not match");
		return "USR002";
	}
	
	
	
	
	@RequestMapping(value = "/userupdate", method = RequestMethod.GET)
	public String userupdate(@RequestParam("id")String id,Model model) {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(id);
		UserResponseDTO user=dao.select(dto).get(0);
		model.addAttribute("userBean", new UserBean(user.getId(),user.getName(),user.getPassword(),user.getPassword()));
		return "USR002-01";
		
	}
	
	@RequestMapping(value = "/userupdate", method = RequestMethod.POST)
	public String userupdate(@ModelAttribute("userBean")@Validated UserBean bean,BindingResult bs,Model model) {
		if(bs.hasErrors()){
			model.addAttribute("user",bean);
			model.addAttribute("err", "Fields must not be null");
			return "USR002-01";
		}
		if (bean.getPassword().equals(bean.getConfirm())) {
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			dto.setName(bean.getName());
			dto.setPassword(bean.getPassword());
			int res = dao.update(dto);
			if (res > 0)
				model.addAttribute("msg", "Update successful");
			else
				model.addAttribute("err", "Update fail");
		}else {
			model.addAttribute("err", "Password are not match");
			model.addAttribute("user",bean);
			return "USR002-01";
		}
		model.addAttribute("userBean", new UserBean());
		return "USR001";
	}
	
	@RequestMapping(value = "/userdelete", method = RequestMethod.GET)
	public String userdelete(@RequestParam("id")String id,Model model) {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setId(id);
		int res = dao.delete(dto);
		if (res > 0) {
			model.addAttribute("msg", "Delete successful");
		}else
			model.addAttribute("err", "Delete failed");
		
		model.addAttribute("userBean", new UserBean());
		return "USR001";
	}
	
}
