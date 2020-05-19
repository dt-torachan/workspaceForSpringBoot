package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
	
	@RequestMapping(value="/registrationEntry")
	public String registration() {
		return "registration";
	}
	
	@Transactional
	@RequestMapping(value="/registrationExecute")
	public String registrationExecute(@RequestParam("id") String id,@RequestParam("password") String password,@RequestParam("username") String username,
			@RequestParam("passwordConfirm") String passwordConfirm,@RequestParam("phone") String phone,@RequestParam("mail") String mail) {
		
		return "registration";
	}
}
