package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.PlatformDao;
import com.newlecture.web.data.entity.Platform;

public class MyBatisPlatformDao implements PlatformDao{

   @Autowired
   private SqlSession sqlSession;
      
   @Override
   public List<Platform> getList() {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.getList();
   }

   @Override
   public Platform get(String code) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.get(code);
   }

   @Override
   public int add(Platform platform) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.add(platform);
   }

   @Override
   public int update(Platform platform) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.update(platform);
   }

   @Override
   public int delete(String code) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.delete(code);
   }
	
	@Override
	public List<Platform> getPlatformsOfLecture(String code) {
	      PlatformDao platformDao;
	      platformDao = sqlSession.getMapper(PlatformDao.class);
	      
	      return platformDao.getPlatformsOfLecture(code);
	}

}