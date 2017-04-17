package com.newlecture.web.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newlecture.web.data.entity.Notice;
import com.newlecture.web.data.view.NoticeView;


/**
 * Notice Controller
 * 무엇을 구현하는가(가이드라인)
 */
public interface NoticeDao {
	
	/**
	 * create: 게시글 등록 함수
	 */
	int add(Notice notice);
	int add(String title, String content, String writer);

	/**
	 * read :NoticeView형의 list를 받아오는 함수
	 */
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(int page, String field, String query);
	
	String lastCode();
	
	//하나의 NoticeView의 정보를 가져오는 함수
	NoticeView get(String code);
	NoticeView getPrev(String code);
	NoticeView gerNext(String code);
	

	//검색 결과에 따른 게시물 수를 가져오는 함수
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
