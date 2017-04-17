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
	int add(Member member);
	
	Member get(String id);
}
