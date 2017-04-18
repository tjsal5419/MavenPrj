package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.PlatformVer;


public interface PlatformVerDao {
	List<PlatformVer> getList();
	List<PlatformVer> getList(int page, String field, String query);
	List<PlatformVer> getList(int page);
	PlatformVer get(String code);
	int add(PlatformVer platformVer);
	int update(PlatformVer platformVer);
	int delete(String code);
}
