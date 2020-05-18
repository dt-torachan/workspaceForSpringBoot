package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.UserDAO;

@Controller
public class AuthController {

	@RequestMapping(value = "/")
	public String entry() {
		return "entry";
	}
	
	@RequestMapping(value = "/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,Model model,UserDAO userDAO) {
		
		model = userDAO.searchById(id,password,model);
		
		if(model.getAttribute("errormessage") != null) {
			return "entry";
		}else {
			return "mypage";
		}
	}
	
}
