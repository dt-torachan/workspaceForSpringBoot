package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.ParamObjectService;


@Controller
public class DemoController {

	@RequestMapping(value="/")
	public String entry() {
		
		return "entry";
		
	}
	
	@RequestMapping(value="/prime")
	public String login(@ModelAttribute ParamObjectService param , Model model) {
		
		
		model.addAttribute("response", param.getMessage());
		
		return "login";
		
	}
	
}


