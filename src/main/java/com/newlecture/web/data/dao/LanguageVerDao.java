package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.LanguageVer;


public interface LanguageVerDao {
	List<LanguageVer> getList();
	LanguageVer get(String code);
	int add(LanguageVer languageVer);
	int update(LanguageVer languageVer);
	int delete(String code);
	List<LanguageVer> getList(int page, String field, String query);
	List<LanguageVer> getList(int page);
}
