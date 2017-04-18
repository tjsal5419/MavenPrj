package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.dao.LecturePlatformDao;
import com.newlecture.web.data.entity.Lecture;
import com.newlecture.web.data.entity.LecturePlatform;

public class MyBatisLecturePlatformDao implements LecturePlatformDao{

   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List<LecturePlatform> getList(int page, String field, String query) {
      LecturePlatformDao lecturePlatformDao;
      lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);
      
      return lecturePlatformDao.getList(page, field, query);
   }
   
   @Override
   public List<LecturePlatform> getList(int page) {
      
      return getList(page, "TITLE", "");
   }
   
   @Override
   public List<LecturePlatform> getList() {
      
      return getList(1, "TITLE", "");
   }

   @Override
   public int delete(String code) {
      LecturePlatformDao lecturePlatformDao;
      lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);

      return lecturePlatformDao.delete(code);
   }

   @Override
   public LecturePlatform get(String code) {
      LecturePlatformDao lecturePlatformDao;
      lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);

      return lecturePlatformDao.get(code);
   }

   @Override
   public int add(LecturePlatform lecturePlatform) {
      LecturePlatformDao lecturePlatformDao;
      lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);

      return lecturePlatformDao.add(lecturePlatform);
   }

   @Override
   public int update(LecturePlatform lecturePlatform) {
      LecturePlatformDao lecturePlatformDao;
      lecturePlatformDao = sqlSession.getMapper(LecturePlatformDao.class);

      return lecturePlatformDao.update(lecturePlatform);
   }

}