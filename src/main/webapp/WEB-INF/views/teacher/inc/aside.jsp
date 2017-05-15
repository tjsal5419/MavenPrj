<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
			<aside id="aside">
				<!-- div를 시맨틱하게 태그로 표현 (nav, article, aside) -->
				<!-- 	Section 내에서 헤더 푸터 따로 사용 가능. 메인은 사용 불가능 (문서 내 메인은 단 하나만 존재해야함 ) -->
				<h1 class="aside-title aside-main-title aside-margin">TEACHER PAGE</h1>
				<nav>
					<h1>마이페이지</h1>
					<ul class="margin">
					<!-- 권한을 여러개 갖는 경우, 본인의 권한에 해당하는 url에는 접근 불가해야한다 -->
						<security:authorize ifAnyGranted="ROLE_ADMIN">
							<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="${root }/admin/index">관리자 홈</a></li>						
						</security:authorize>
						<security:authorize ifAnyGranted="ROLE_TEACHER">
							<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="${root }/teacher/index">선생님홈</a></li>						
						</security:authorize>
				
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="${root }/student/index">학생홈</a></li>
					</ul>
				</nav>


				<nav>
					<h1>콘텐츠 관리</h1>
					<ul class="margin">
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="lecture">강좌 관리</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href="">문제 관리</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link"
							href=""></a></li>
					</ul>
				</nav>

				<nav>
					<div>
						<h1 class="aside-title margin">추천사이트</h1>
						<ul class="margin">
							<li><a href=""><img src="${root}/resource/images/answeris.png"
									alt="answeris"></a></li>
							<li><a href=""><img src="${root}/resource/images/w3c.png" alt="w3c"></a></li>
							<li><a href=""><img src="${root}/resource/images/microsoft.png"
									alt="마이크로소프트"></a></li>
						</ul>
					</div>
				</nav>
			</aside>