package com.newlecture.web.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.model.teacher.LectureDetailModel;
import com.newlecture.web.model.teacher.LectureModel;
import com.newlecture.web.service.TeacherService;

@Controller
@RequestMapping("/teacher/*") /*url집중화*/
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping("index")
	public String index(){
		return "teacher.index";

	}

	// 만들어진 서비스를 컨트롤러 단에서 이용함.
	@RequestMapping("lecture")
	public String lecture(
			@RequestParam(value="page", defaultValue="1")Integer page,
			@RequestParam(value="field", defaultValue="TITLE")String field, 
			@RequestParam(value="query", defaultValue="")String query, 
			Model model){
		LectureModel m = service.getLectureModel(page, field, query);
		model.addAttribute("model",m);
				
		return "teacher.lecture";
	}

	@RequestMapping("lecture-detail")
	public String lectureDetail(String code, Model model){
		LectureDetailModel m = service.getLectureDetailModel(code);
		model.addAttribute("model",m);		
		return "admin.lecture";
	}

}
