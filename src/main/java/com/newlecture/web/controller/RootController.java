package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
	
	@RequestMapping("/index")
	public String index(){
		return "/WEB-INF/views/index.jsp";
		// 컨트롤러와 뷰를 연결함
		
	}
	// 함수로 URL 매핑하기!!!!
	
	

}
