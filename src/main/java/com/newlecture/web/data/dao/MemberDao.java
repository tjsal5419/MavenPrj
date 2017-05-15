package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Member;

/**
 * Member Controller
 */
public interface MemberDao {
	List<Member> getList();
	List<Member> getList(String query);
	List<Member> getList(String query, String pwd, String name);
	
	Member get(String id);
	int add(Member member);
	int delete(String id);
	int modify(Member member);
}
