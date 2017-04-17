package com.newlecture.web.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;


/**
 * Notice Controller
 * ������ �����ϴ°�(���̵����)
 */
public interface NoticeDao {
	
	/**
	 * create: �Խñ� ��� �Լ�
	 */
	int add(Notice notice);
	int add(String title, String content, String writer);

	/**
	 * read :NoticeView���� list�� �޾ƿ��� �Լ�
	 */
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(int page, String field, String query);
	
	String lastCode();
	
	//�ϳ��� NoticeView�� ������ �������� �Լ�
	NoticeView get(String code);
	NoticeView getPrev(String code);
	NoticeView gerNext(String code);
	

	//�˻� ����� ���� �Խù� ���� �������� �Լ�
	int getSize();
	int getSize(String field, String query);
	
	/**
	 * update
	 */
	int update(Notice notice);
	int update(String title, String content, String code);
	
	/**
	 * delete
	 */
	int delete(String code);
	
}
