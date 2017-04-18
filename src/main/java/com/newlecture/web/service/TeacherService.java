package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.dao.LecturePlatformDao;
import com.newlecture.web.data.dao.LevelDao;
import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.entity.Lecture;
import com.newlecture.web.data.entity.LectureLanguage;
import com.newlecture.web.data.entity.Level;
import com.newlecture.web.data.entity.Member;
import com.newlecture.web.model.teacher.LectureDetailModel;
import com.newlecture.web.model.teacher.LectureModel;



//언어, 강좌, 플랫폼 서비스가 필요(ppt 참고)

public class TeacherService {
	
	@Autowired 
	private LectureDao lectureDao;
	
	@Autowired
	private LectureLanguageDao lectureLanguageDao;
	
	@Autowired
	private LecturePlatformDao lecturePlatformDao;
	
	@Autowired
	private LevelDao levelDao;
	
	@Autowired
	private MemberDao memberDao;
	
	// 강좌 목록 뿐만 아니라, 그 외의 필요한 요소까지 모델에 포함한다.(page수 등등)
	public LectureModel getLectureModel(int page, String field, String query){
		LectureModel model = new LectureModel();
		
		
		List<Lecture> lectures = lectureDao.getList(page,field,query);
		int size = lectureDao.getSize(field,query);
		model.setLectures(lectures);
		model.setTotalPageCount(size);
		
/*		for(Lecture l: lectures ){
			List<LectureLanguage> lang = lectureLanguageDao.getList(l.getCode());
			l.setLanguages(lang);
			l.setPlatforms(lecturePlatformDao.getList(l.getCode()));
			l.setLevel(levelDao.get(l.getCode()));
			l.setMember(l.get());
		}
*/		
		
		return model;
	}

	public LectureDetailModel getLectureDetailModel(String code) {
		LectureDetailModel model = new LectureDetailModel();
		Lecture lectureDetail = lectureDao.get(code);
		model.setLectureDatail(lectureDetail);
		
		return model;
	}
	
}
