package com.example.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
//메서드 단독 매핑 관련된 예제
//@Controller("myController")
@Controller
public class HelloController {
	// 메서드가 /hello URL 요청에 반응하도록 한다
	@RequestMapping("/hello")
	
	public ModelAndView hello(@RequestParam String name) {
		// 서블릿에서 getParameter로 해준 것을
		// RequestParam이 대신 해준 것
		ModelAndView mav = new ModelAndView();
		
		// 객체 추가: 서블릿에서 addAttribute의 역할
		mav.addObject("message", 	//	키
				"Hello, " + name);	//	값
		// 뷰파일을 연결: 서블릿에서 RequestDispatcher로 포워드한 것과 비슷
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	// 문자열을 반환하려면 해당 뷰로의 포워딩을 의미
	// # hello2는 String 반환
	@RequestMapping("/hello2")
	public String hello2() {
		return "/WEB-INF/views/hello.jsp";		
	}
	
	// 문자열을 반환할 때 직접 응답으로 전송하고 싶을 때
	// #뷰없이 직접 문자열을 전송하고 싶은 경우 ResponseBody를 사용한다.
	// ResponseBody -> MessageConverter를 실행하는 어노테이션
	// #hello3은 String 직접 응답
	@ResponseBody
	@RequestMapping("/hello3")
	public String hello3() {
		return "<h1>문자열을 직접 전송</h1>";
	}
}