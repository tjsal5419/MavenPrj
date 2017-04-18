package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.PlatformVerDao;
import com.newlecture.web.data.entity.PlatformVer;

public class MyBatisPlatformVerDao implements PlatformVerDao{

   @Autowired
      private SqlSession sqlSession;
   
   @Override
   public List<PlatformVer> getList(int page, String field, String query) {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);
      
      return platformVerDao.getList(page, field, query);
   }

   
   @Override
   public List<PlatformVer> getList() {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);
      
      return getList(1, "TITLE", "");
   }


	@Override
	public List<PlatformVer> getList(int page) {
	      PlatformVerDao platformVerDao;
	      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);
	      
	      return getList(page, "TITLE", "");
	}


   @Override
   public int delete(String code) {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);

      return platformVerDao.delete(code);
   }

   @Override
   public PlatformVer get(String code) {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);

      return platformVerDao.get(code);
   }

   @Override
   public int add(PlatformVer platformVer) {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);

      return platformVerDao.add(platformVer);
   }

   @Override
   public int update(PlatformVer platformVer) {
      PlatformVerDao platformVerDao;
      platformVerDao = sqlSession.getMapper(PlatformVerDao.class);

      return platformVerDao.update(platformVer);
   }


}