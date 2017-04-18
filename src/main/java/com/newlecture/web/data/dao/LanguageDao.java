package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Language;

public interface LanguageDao {
	List<Language> getList();
	Language get(String code);
	int add(Language language);
	int update(Language language);
	int delete(String language);
	List<Language> getList(int page, String field, String query);
	List<Language> getList(int page);
}
