package com.newlecture.web.model.teacher;

import java.util.List;

import com.newlecture.web.data.entity.Lecture;


public class LectureModel {

	private List<Lecture> lectures;
	private int totalPageCount;
	
	public List<Lecture> getLectures() {
		return lectures;
	}
	
	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}
	
	public int getTotalPageCount() {
		return totalPageCount;
	}
	
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
}
