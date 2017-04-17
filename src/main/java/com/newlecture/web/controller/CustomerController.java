package com.newlecture.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.data.dao.NoticeDao;
import com.newlecture.web.data.dao.NoticeFileDao;
import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.entity.NoticeFile;
import com.newlecture.web.data.view.NoticeView;

@Controller
@RequestMapping("/customer/*") /*url집중화*/
public class CustomerController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private NoticeDao noticeDao; /*컨테이너가 자동으로 담아준다*/
	@Autowired
	private NoticeFileDao noticeFileDao;
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("notice")
	public String notice(@RequestParam(value="p", defaultValue="1")int page,
			@RequestParam(value="q", defaultValue="")String query,
			@RequestParam(value="f", defaultValue="TITLE")String field, Model model){
		
		//List<NoticeView> list = noticeDao.getList(page, field, query);
		List<NoticeView> list = sqlSession.getMapper(NoticeDao.class).getList(page, field, query);
		
		int size = noticeDao.getSize(field, query);
		
		int last = 0;
		if((size%10)> 0)
			last = size/10 +1;
		else
			last = size / 10;
		
		model.addAttribute("list",list);
		model.addAttribute("size",size);
		model.addAttribute("last",last);
		model.addAttribute("f",field);
		model.addAttribute("q",query);
		model.addAttribute("p",page);
		
		return "customer.notice";
		
		//return String.format("f:%s p:%s q:%s", field,page,query);
	}

	@RequestMapping("notice-detail")
	public String noticeDetail(@RequestParam("c")String code,Model model){
		NoticeView n = noticeDao.get(code);
		NoticeView prev = noticeDao.getPrev(code);
		NoticeView next = noticeDao.getNext(code);
		List<NoticeFile> list = noticeFileDao.getList(n.getCode());
		
		model.addAttribute("n",n);
		model.addAttribute("prev",prev);
		model.addAttribute("next",next);
		model.addAttribute("list",list);
		
		return "customer.notice-detail";
		// 컨트롤러와 뷰를 연결함
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.GET)
	public String noticeEdit(@RequestParam("c")String code,
			Model model){
		Notice notice = noticeDao.get(code);
		model.addAttribute("n",notice);

		return "customer.notice-edit";
		// 컨트롤러와 뷰를 연결함
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.POST)
	public String noticeEdit(Notice notice){
		noticeDao.update(notice.getTitle(), notice.getContent(), notice.getCode());
		
		return "redirect:notice-detail?c="+notice.getCode();
		// 컨트롤러와 뷰를 연결함
	}
	
	
	@RequestMapping(value="notice-reg", method=RequestMethod.GET)
	public String noticeReg(){
		return "customer.notice-reg";
		// 컨트롤러와 뷰를 연결함
	}
	
	
	/*post처리*/
	@RequestMapping(value="notice-reg", method=RequestMethod.POST, produces="text/txt;charset=UTF-8")
	public String noticeReg(
			Notice notice,
			@RequestParam(value="files")List<MultipartFile> files) throws IOException{ 
		/*디스패처가 사용자가 입력한 값을 setter에 자동 담아줌*/
		StringBuilder sb = new StringBuilder();

		String path = context.getRealPath("/resource/upload"); // realPath = 배포디렉토리,
		
		File d = new File(path);

		if (!d.exists()) {
			d.mkdirs();
		}
		
		byte[] buf = new byte[1024];
		
		for(MultipartFile file : files){
			if(!file.isEmpty())
			{
			String fileName = file.getOriginalFilename();
			InputStream fis = file.getInputStream();
			OutputStream fos = new FileOutputStream(path+File.separator+fileName);
			/*운영체제에 따른 경로 분리에 주의할 것. File.separator이용*/ 

			int len=0;
			
//			1024bytes씩 읽어서 1024bytes씩 쓰므로 while문으로 반복
			while((len=fis.read(buf))>0)
				fos.write(buf, 0, len); /*1024byte중 len만큼만 저장해준다.*/
			
			fis.close();
			fos.close();
			}
		}
		
	    /*트랜잭션이 깨질 때 처리를 해줘야한다. => Spring 트랜잭션으로 관리*/
		notice.setWriter("TJSAL");
		noticeDao.add(notice);

		for(MultipartFile file : files)
		{
			if(!file.isEmpty()){
			String fileName = file.getOriginalFilename();
			NoticeFile f = new NoticeFile();
			f.setNoticeCode(noticeDao.lastCode());
			f.setSrc(fileName);
			noticeFileDao.add(f);
			}
		}
		return "redirect:notice"; //뷰가 아님을 알리는 redirect

	}
	
	@RequestMapping(value="notice-delete", method=RequestMethod.GET)
	public String noticeDelete(@RequestParam("c")String code){
		// 파일 정보를 얻기
		List<NoticeFile> fs = noticeFileDao.getList(code);
		String path = null;
		File d = null;
		boolean a = false;
		for(NoticeFile f : fs){
			path = context.getRealPath("/resources/upload"); // realPath = 배포디렉토리,
			d = new File(path+File.separator+f.getSrc());
			a = d.delete();	
		}
		
		
		//  외래키 제약 조건에 no delete CASCADE가 되어있는 경우
		// notice 정보만 지우면 됨
		// 그렇지 않은 경우 notice file을 먼저 지워야함. 아니면 외래키 제약조건 오류 발생!!
		noticeDao.delete(code);
				
		return "redirect:notice";
		// 컨트롤러와 뷰를 연결함
	}

	

}
