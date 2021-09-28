package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


// RequestMapping ( Type + Method )
@RequestMapping("/user")   
@Controller
public class UserController {   // #해당 클래스가 통째로 /user을 잡고 있음
	// # /user/join이 Method GET호출 -> joinform
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinform() {
		return "/WEB-INF/views/joinform.jsp";
	}
	
	// # Method POST호출 -> joinsuccess
	// # Form data 처리시 넘어오는 파라미터가 많으면 일일히 명시해줘하는 불편함이 있음.
	@RequestMapping(value="/join", method=RequestMethod.POST)
    public String join(@RequestParam String name,
    				   @RequestParam String email,
    				   @RequestParam String password) {
		System.out.println("name:" + name);
		System.out.println("email:" + email);
		System.out.println("password:" + password);
		
		// 리다이렉트
		return "redirect:/user/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "<h1>JOIN SUCCESS</h1>";
	}
}
