package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class RootController {
	
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/index")
	public String index(){
		return "index";
		// 컨트롤러와 뷰를 연결함
		
	}
	// 함수로 URL 매핑하기!!!!

	@RequestMapping(value="/upload", method= RequestMethod.POST)
	public String upload(MultipartFile file) throws IOException{
		// out 객체 생성
		// out 해주기 

		String path = servletContext.getRealPath("/resource/upload");
		
		File d = new File(path);
		
		System.out.println(path);
		if(!d.exists())
			d.mkdirs();
		
		byte[] buf = new byte[1024];
		
		if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			InputStream fis = file.getInputStream();
			OutputStream fos = new FileOutputStream(path+File.separator+fileName);
			int len = 0;
			while((len=fis.read(buf))>0){
				fos.write(buf, 0, len);
			}
			fis.close();
			fos.close();
		}
		
		
		return "1";
		
	}
	

}
