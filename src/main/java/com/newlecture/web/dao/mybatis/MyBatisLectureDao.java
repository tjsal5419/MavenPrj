package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LanguageDao;
import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.entity.Language;
import com.newlecture.web.data.entity.Lecture;

public class MyBatisLectureDao implements LectureDao {
   
   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<Lecture> getList(int page, String field, String query) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.getList(page, field, query);
   }

   @Override
   public List<Lecture> getList() {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.getList(1, "TITLE", "");
   }

   @Override
   public Lecture get(String code) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.get(code);
   }

   @Override
   public int add(Lecture lecture) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.add(lecture);
   }

   @Override
   public int update(Lecture lecture) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.update(lecture);
   }

   @Override
   public int delete(String code) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.delete(code);
   }

	@Override
	public List<Lecture> getList(String lectureCode) {
	      LectureDao lectureDao;
	      lectureDao = sqlSession.getMapper(LectureDao.class);
	      return lectureDao.getList(lectureCode);
	}

	@Override
	public int getSize(String field, String query) {
	      LectureDao lectureDao;
	      lectureDao = sqlSession.getMapper(LectureDao.class);
	      return lectureDao.getSize(field, query);
	}

	

}