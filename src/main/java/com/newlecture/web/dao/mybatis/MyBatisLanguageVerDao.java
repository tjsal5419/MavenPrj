package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LanguageVerDao;
import com.newlecture.web.data.entity.LanguageVer;



public class MyBatisLanguageVerDao implements LanguageVerDao {
   
   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<LanguageVer> getList(int page, String field, String query) {
      LanguageVerDao languageverDao;
      languageverDao = sqlSession.getMapper(LanguageVerDao.class);

      return languageverDao.getList(page, field, query);
   }

   @Override
   public List<LanguageVer> getList(int page) {
      // TODO Auto-generated method stub
      return getList(page, "TITLE", "");
   }

   @Override
   public List<LanguageVer> getList() {
      // TODO Auto-generated method stub
      return getList(1, "TITLE", "");
   }

   @Override
   public LanguageVer get(String code) {
      LanguageVerDao languageverDao;
      languageverDao = sqlSession.getMapper(LanguageVerDao.class);
      return languageverDao.get(code);
   }

   @Override
   public int add(LanguageVer langver) {
      LanguageVerDao languageverDao;
      languageverDao = sqlSession.getMapper(LanguageVerDao.class);
      return languageverDao.add(langver);
   }

   @Override
   public int update(LanguageVer langver) {
      LanguageVerDao languageverDao;
      languageverDao = sqlSession.getMapper(LanguageVerDao.class);
      return languageverDao.update(langver);
   }

   @Override
   public int delete(String code) {
      LanguageVerDao languageverDao;
      languageverDao = sqlSession.getMapper(LanguageVerDao.class);
      return languageverDao.delete(code);
   }
}