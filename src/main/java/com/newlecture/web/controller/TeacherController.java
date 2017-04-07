package com.newlecture.web.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;

@Controller
@RequestMapping("/teacher/*") /*urlÁýÁßÈ­*/
public class TeacherController {
	
	@RequestMapping("index")
	public String index(){
		return "teacher.index";

	}


}
