<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#table{
		border : 1px solid black;
	}
	
	td{
		border : 1px solid black;
		text-align:center;
	}
	
	tr{
		border : 1px solid black;
	}
</style>

<main>
	<table id="table">
		<tr>
			<td>제목</td>
			<td>강의명</td>
			<td>난이도</td>
			<td>변경</td>
			<td>언어</td>
			<td>플랫폼명</td>
			<td>플랫폼버전</td>
		</tr>
		
		<c:forEach items="${model.lectures}" var="lec">
		<tr>
			<td>${lec.title }</td>
			<td>${lec.level.name }</td>
			<td>입문편</td>
			<td>
				<input type="button" value="공개">
				<input type="button" value="편집">
				<input type="button" value="삭제">
			</td>
			<td>
				<!-- 강좌 언어를 가져옴 -->
				<ul>
					<c:forEach items="${lec.languagesOfLecture}" var="lang">

					<li>
						${lang.name} 언어
					</li>
					</c:forEach>
				</ul>
				<!-- 강좌 플랫폼 -->
				
			</td>
			<td>
				<!-- 강좌 언어를 가져옴 -->
				<ul>
					<c:forEach items="${lec.platformsOfLecture}" var="lang">
					<li>
						${lang.name} 플랫폼
					</li>
					<li>
						${lang.version} 버전
					</li>
					</c:forEach>
				</ul>
				<!-- 강좌 플랫폼 -->
				
			</td>
			
		</tr>
		</c:forEach>
		
	</table>
</main>