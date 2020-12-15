package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.ClassDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.dto.ClassRequestDTO;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.UserBean;

@Controller
public class LoginController {
	@Autowired
	UserDAO dao;
	@Autowired
	ClassDAO classDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("user", new UserBean());
		return "LGN001";
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	public String header() {
		return "M00001";
	}
	
	@RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
	public String login(HttpServletRequest request,@ModelAttribute("user")UserBean bean,Model model) {
		if (bean.getId().equals("") || bean.getPassword().equals("")) {
			request.setAttribute("err", "Feilds must not be null");
			model.addAttribute("user", bean);
			return "LGN001";
		} else {
			UserRequestDTO dto = new UserRequestDTO();
			dto.setId(bean.getId());
			
			List<UserResponseDTO> list = dao.select(dto);
			if (list.size() == 0) {
				request.setAttribute("err", "User not found!");
				model.addAttribute("user", bean);
				return "LGN001";
			} else if (bean.getPassword().equals(list.get(0).getPassword())) {		
				ClassRequestDTO cdto = new ClassRequestDTO();
				cdto.setId("");
				cdto.setName("");
				request.getServletContext().setAttribute("classlist", classDao.select(cdto));
				request.getSession().setAttribute("sesUser", list.get(0));
				return "M00001";
			} else {
				request.setAttribute("err", "Password is incorrect!");
				return "LGN001";
			}
		}
	}
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,Model model) {
		model.addAttribute("user", new UserBean());
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "LGN001";
	}
	
}
