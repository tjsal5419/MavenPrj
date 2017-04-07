package com.newlecture.web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class NewlecSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, 
			HttpServletResponse response, 
			Authentication auth)
			throws IOException, ServletException {
		
		response.sendRedirect("/MavenPrj/student/index");
		
	}

}
