package com.newlecture.web.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.model.teacher.LectureModel;
import com.newlecture.web.service.AdminService;

@Controller
@RequestMapping("/admin/*") /*urlÁýÁßÈ­*/
public class AdminController {

	@RequestMapping("index")
	public String index(){
		return "admin.index";
		//return String.format("f:%s p:%s q:%s", field,page,query);
	}
	
}
