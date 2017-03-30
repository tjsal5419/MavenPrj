package com.newlecture.web.data.dao;

import java.util.List;

import com.newlecture.web.data.entity.Member;
 // ���� , ��Ʈ�ѷ��� ���� ���� ���� , ������ ����
public interface MemberDao {
	List<Member> getList();
	int add(Member member);
	void delete(String mid);
	void modify(Member member);
	List<Member> getList(String query);
	Member get(String id);
} 
