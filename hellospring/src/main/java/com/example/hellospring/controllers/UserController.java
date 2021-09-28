package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exmaple.hellospring.vo.UserVo;


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
//    public String join(@RequestParam String name,
//    				   @RequestParam String email,
//    				   @RequestParam String password) {
//		System.out.println("name:" + name);
//		System.out.println("email:" + email);
//		System.out.println("password:" + password);
//		
	// # UserVo 객체 데이터 넘어오는 것 확인하는 예제	
	// # 해당 방식은 폼으로 전송 받은 데이터 처리하는 것이 제일 편하다.
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("폼으로부터 전송받은 DTO:" + vo);
		// 리다이렉트
		return "redirect:/user/joinsuccess";
	}
	
	@ResponseBody
	@RequestMapping("/joinsuccess")
	public String joinsuccess() {
		return "<h1>JOIN SUCCESS</h1>";
	}
	
}
