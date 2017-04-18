package com.newlecture.web.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.model.teacher.LectureDetailModel;
import com.newlecture.web.model.teacher.LectureModel;
import com.newlecture.web.service.TeacherService;

@Controller
@RequestMapping("/teacher/*") /*url����ȭ*/
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping("index")
	public String index(){
		return "teacher.index";

	}

	// ������� ���񽺸� ��Ʈ�ѷ� �ܿ��� �̿���.
	@RequestMapping("lecture")
	public String lecture(int page, String field, String query, Model model){
		LectureModel m = service.getLectureModel(page, field, query);
		model.addAttribute("model",m);
				
		return "admin.lecture";
	}

	@RequestMapping("lecture-detail")
	public String lectureDetail(String code, Model model){
		LectureDetailModel m = service.getLectureDetailModel(code);
		model.addAttribute("model",m);		
		return "admin.lecture";
	}

}
