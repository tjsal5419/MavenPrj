package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Language;
import com.newlecture.web.data.entity.Lecture;


public interface LectureDao {
	List<Lecture> getList();
	List<Lecture> getList(String lectureCode);
	List<Lecture> getList(int page,String field, String query);
	
	
	Lecture get(String code);
	int add(Lecture lecture);
	int update(Lecture lecture);
	int delete(String code);
	int getSize(String field, String query);
}
