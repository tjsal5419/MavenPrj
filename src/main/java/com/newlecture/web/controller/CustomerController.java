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
@RequestMapping("/customer/*") /*url����ȭ*/
public class CustomerController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private NoticeDao noticeDao; /*�����̳ʰ� �ڵ����� ����ش�*/
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
		// ��Ʈ�ѷ��� �並 ������
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.GET)
	public String noticeEdit(@RequestParam("c")String code,
			Model model){
		Notice notice = noticeDao.get(code);
		model.addAttribute("n",notice);

		return "customer.notice-edit";
		// ��Ʈ�ѷ��� �並 ������
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.POST)
	public String noticeEdit(Notice notice){
		noticeDao.update(notice.getTitle(), notice.getContent(), notice.getCode());
		
		return "redirect:notice-detail?c="+notice.getCode();
		// ��Ʈ�ѷ��� �並 ������
	}
	
	
	@RequestMapping(value="notice-reg", method=RequestMethod.GET)
	public String noticeReg(){
		return "customer.notice-reg";
		// ��Ʈ�ѷ��� �並 ������
	}
	
	
	/*postó��*/
	@RequestMapping(value="notice-reg", method=RequestMethod.POST, produces="text/txt;charset=UTF-8")
	public String noticeReg(
			Notice notice,
			@RequestParam(value="files")List<MultipartFile> files) throws IOException{ 
		/*����ó�� ����ڰ� �Է��� ���� setter�� �ڵ� �����*/
		StringBuilder sb = new StringBuilder();

		String path = context.getRealPath("/resource/upload"); // realPath = �������丮,
		
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
			/*�ü���� ���� ��� �и��� ������ ��. File.separator�̿�*/ 

			int len=0;
			
//			1024bytes�� �о 1024bytes�� ���Ƿ� while������ �ݺ�
			while((len=fis.read(buf))>0)
				fos.write(buf, 0, len); /*1024byte�� len��ŭ�� �������ش�.*/
			
			fis.close();
			fos.close();
			}
		}
		
	    /*Ʈ������� ���� �� ó���� ������Ѵ�. => Spring Ʈ��������� ����*/
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
		return "redirect:notice"; //�䰡 �ƴ��� �˸��� redirect

	}
	
	@RequestMapping(value="notice-delete", method=RequestMethod.GET)
	public String noticeDelete(@RequestParam("c")String code){
		// ���� ������ ���
		List<NoticeFile> fs = noticeFileDao.getList(code);
		String path = null;
		File d = null;
		boolean a = false;
		for(NoticeFile f : fs){
			path = context.getRealPath("/resources/upload"); // realPath = �������丮,
			d = new File(path+File.separator+f.getSrc());
			a = d.delete();	
		}
		
		
		//  �ܷ�Ű ���� ���ǿ� no delete CASCADE�� �Ǿ��ִ� ���
		// notice ������ ����� ��
		// �׷��� ���� ��� notice file�� ���� ��������. �ƴϸ� �ܷ�Ű �������� ���� �߻�!!
		noticeDao.delete(code);
				
		return "redirect:notice";
		// ��Ʈ�ѷ��� �並 ������
	}

	

}
