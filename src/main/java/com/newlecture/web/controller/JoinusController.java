package com.newlecture.web.controller;

import java.security.Principal;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.dao.MemberRoleDao;
import com.newlecture.web.data.entity.Member;

@Controller
@RequestMapping("/joinus/*") /*url집중화*/
public class JoinusController {
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private MemberDao memberDao; /*컨테이너가 자동으로 담아준다*/

	@RequestMapping("login")
	public String login(){
		return "joinus.login";
		//return String.format("f:%s p:%s q:%s", field,page,query);
	}

	@RequestMapping("join")
	public String join(String id, String pwd){
		Member member = new Member();
		
		return "joinus.join";
		// 컨트롤러와 뷰를 연결함
	}

	@RequestMapping("mypage")
	public String mypage(Principal principal){
		
		String memberId = principal.getName();

		//String defaultRole = memberRoleDao.getDefaultRoleById(memberId);

		String defaultRole = "ROLTE_TEACHER";
		if (defaultRole.equals("ROLE_ADMIN"))
			return "redirect:../admin/index";
		else if (defaultRole.equals("ROLE_TEACHER"))
			return "redirect:../teacher/index";
		else
			return "redirect:../student/index";
	}

}
