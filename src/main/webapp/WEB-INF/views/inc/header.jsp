<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
	<header id="header">
		<div class="content-container">

			<h1 id="logo">
				<img src="${root }/resource/images/logo.png" alt="뉴렉처 온라인">
			</h1>

			<section>
				<h1 class="hidden">header</h1>
				<!-- 		스타일에는  세미콜론 써주기!
 -->
				<nav id="main-menu" class="hr-menu">
					<h1 >메인메뉴
						<input type = "button"  id="btn-result" value="클릭"  />
					</h1>
					<ul>
						<!-- ul,ol,dl -->
						<li><a href="">학습가이드</a></li>
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>

				<div id="lecture-search-form">
					<h3 class="hidden">검색 폼</h3>
					<form>
						<fieldset>
							<legend class="hidden">검색 필드</legend>
							<label>과정검색</label> <input type="text" /> <input
								class="lecture-search-btn" type="submit" value="검색" />
						</fieldset>
					</form>
				</div>

				<security:authentication property="authorities" var="auth"/>
				<security:authentication property="name" var="name"/>
				
				<div>
					name:${name }
					<c:forEach items="auth" var="role">
						role: ${role}
					</c:forEach>
				</div>

				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">계정메뉴</h1>
					<ul>
						<li><a href="${root }/index">HOME</a></li>
						<c:if test="${empty pageContext.request.userPrincipal.name }">		
						<li><a href="${root }/joinus/login">로그인</a></li>
						<li><a href="${root }/joinus/join">회원가입</a></li>
						</c:if>	
		
						<security:authorize  access="isAuthenticated()">
						<li><a href="${root }/j_spring_security_logout">
						 <security:authentication property="name"/>님 로그아웃
						</a></li>
						</security:authorize>
					</ul>
				</nav>

				<nav id="member-menu" class="hr-menu">
					
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="${root }/joinus/mypage">마이페이지</a></li>
						<li><a href="${root }/customer/notice">고객센터</a></li>
					</ul>
					
				</nav>

			</section>
		</div>
	</header>