package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.view.NoticeView;

@Controller
public class CustomerController {
	
	@Autowired
	private NoticeDao noticeDao;

	
	@RequestMapping("/customer/notice")
	public String notice(Model model){
		
		List<NoticeView> list = noticeDao.getList();
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/customer/notice.jsp";
		// 컨트롤러와 뷰를 연결함
	}

	@RequestMapping("/customer/notice-detail")
	public String noticeDetail(){
		return "/WEB-INF/views/customer/notice-detail.jsp";
		// 컨트롤러와 뷰를 연결함
	}
	
	@RequestMapping("/customer/notice-edit")
	public String noticeEdit(){
		return "/WEB-INF/views/customer/notice-edit.jsp";
		// 컨트롤러와 뷰를 연결함
	}
	
	@RequestMapping("/customer/notice-reg")
	public String noticeReg(){
		return "/WEB-INF/views/customer/notice-reg.jsp";
		// 컨트롤러와 뷰를 연결함
	}
	

}
