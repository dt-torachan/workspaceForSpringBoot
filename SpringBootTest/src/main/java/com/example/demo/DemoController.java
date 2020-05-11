package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class DemoController {

	@RequestMapping(value="/")
	public String entry() {
		
		return "entry";
		
	}
	
	@RequestMapping(value="/prime")
	public String login(@ModelAttribute ParamObject param , Model model) {
		
		
		model.addAttribute("response", param.getMessage());
		
		return "login";
		
	}
	
}


class ParamObject{
	
	private int prime;
	
	private String message = "TEST";
	
	private boolean isPrime = true;

	public int getPrime() {
		return prime;
	}

	public void setPrime(int prime) {
		this.prime = prime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ParamObject(@RequestParam("id") String id) {
		
		ArrayList<Integer> listPrime = new ArrayList<>();
			
			try {
				
				setPrime(Integer.parseInt(id));
				
				if(prime > 9999) {
					
					message = "入力は9999以下でお願いします";
					
					return;
					
				}
				
				for(int i = 2 ; i <= prime ; i++) {
					
					isPrime = true;
					
					for(int j : listPrime) {
						
						if(i%j == 0) {
							
							isPrime = false;
							
							break;
							
						}
						
					}
					
					if(isPrime) {
						
						listPrime.add(i);
						
					}
					
				}
				
				if(listPrime.contains(prime)) {
					
					message = prime + "は　素数　です";
					
				}else {
					
					message = prime + "は　素数　ではありません";
					
				}
				
			}catch(NumberFormatException e) {
				
				message = "整数を入力してください";
				
			}catch(Exception e) {
				
				message = "エラーが発生しました";
				
			}
			

			
		
		
		

	}
	
}