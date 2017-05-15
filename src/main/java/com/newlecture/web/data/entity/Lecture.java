package com.newlecture.web.data.entity;

import java.util.List;

public class Lecture {
	
	private String code;
	private String title;
	private String context;
	private String teacherName;
	private String bookName;
	private String bookImg;
	private String target;
	private String impactContext;
	private String levelCode;
	private String memberId;
	// 관계 entity를 추가해줌(부모엔티티 & 자식엔티티)
	private List<LecturePlatform> platforms;
	private List<LectureLanguage> languages;
	private List<Language> languagesOfLecture;
	private List<Platform> PlatformsOfLecture;
	
	
	public List<Platform> getPlatformsOfLecture() {
		return PlatformsOfLecture;
	}
	public void setPlatformsOfLecture(List<Platform> platformsOfLecture) {
		PlatformsOfLecture = platformsOfLecture;
	}
	public List<Language> getLanguagesOfLecture() {
		return languagesOfLecture;
	}
	public void setLanguagesOfLecture(List<Language> languagesOfLecture) {
		this.languagesOfLecture = languagesOfLecture;
	}
	//부모 레벨,멤버
	private Level level;

	private Member member;
	
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookImg() {
		return bookImg;
	}
	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getImpactContext() {
		return impactContext;
	}
	public void setImpactContext(String impactContext) {
		this.impactContext = impactContext;
	}
	public String getLevelCode() {
		return levelCode;
	}
	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
	public List<LecturePlatform> getPlatforms() {
		return platforms;
	}
	public void setPlatforms(List<LecturePlatform> platforms) {
		this.platforms = platforms;
	}
	public List<LectureLanguage> getLanguages() {
		return languages;
	}
	public void setLanguages(List<LectureLanguage> languages) {
		this.languages = languages;
	}


}
