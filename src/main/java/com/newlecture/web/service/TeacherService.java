package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.data.dao.LanguageDao;
import com.newlecture.web.data.dao.LectureDao;
import com.newlecture.web.data.dao.LectureLanguageDao;
import com.newlecture.web.data.dao.LecturePlatformDao;
import com.newlecture.web.data.dao.LevelDao;
import com.newlecture.web.data.dao.MemberDao;
import com.newlecture.web.data.dao.PlatformDao;
import com.newlecture.web.data.entity.Language;
import com.newlecture.web.data.entity.Lecture;
import com.newlecture.web.data.entity.LectureLanguage;
import com.newlecture.web.data.entity.Platform;
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
	private LanguageDao languageDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PlatformDao platformDao;
	
	// 강좌 목록 뿐만 아니라, 그 외의 필요한 요소까지 모델에 포함한다.(page수 등등)
	public LectureModel getLectureModel(int page, String field, String query){
		LectureModel model = new LectureModel();
		
		
		List<Lecture> lectures = lectureDao.getList(0,"CODE","");
		int size = lectureDao.getSize(field,query);
		
		for(Lecture l: lectures ){
			l.setLevel(levelDao.getLevelOfLecture(l.getCode()));
			List<LectureLanguage> lang = lectureLanguageDao.getList(l.getCode());
			l.setLanguages(lang);
			System.out.println(l.getCode());
			List<Language> language = languageDao.getLanguagesOfLecture(l.getCode());
			l.setLanguagesOfLecture(language);
			//l.setPlatforms(lecturePlatformDao.getList(l.getCode()));
			//l.setLevel(levelDao.get(l.getCode()));
			//l.setMember(l.get());
			List<Platform> platfrom = platformDao.getPlatformsOfLecture(l.getCode());
			l.setPlatformsOfLecture(platfrom);
		}
		
		
		
		model.setLectures(lectures);
		model.setTotalPageCount(size);
		return model;
	}

	public LectureDetailModel getLectureDetailModel(String code) {
		LectureDetailModel model = new LectureDetailModel();
		Lecture lectureDetail = lectureDao.get(code);
		model.setLectureDatail(lectureDetail);
		
		return model;
	}
	
}
