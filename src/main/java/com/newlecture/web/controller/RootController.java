package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
		// ��Ʈ�ѷ��� �並 ������
		
	}
	// �Լ��� URL �����ϱ�!!!!
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file){
		
		return "1";
		
	}
	

}
