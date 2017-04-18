package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.LecturePlatform;


public interface LecturePlatformDao {
	List<LecturePlatform> getList(int page);
	List<LecturePlatform> getList(int page, String field, String query);
	List<LecturePlatform> getList();
	LecturePlatform get(String code);
	int add(LecturePlatform notice);
	int update(LecturePlatform notice);
	int delete(String code);
}
