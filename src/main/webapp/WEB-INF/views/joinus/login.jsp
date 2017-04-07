<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	
	<!-- Spring에서 제공하는 로그인 처리기로 전달 -->
	<form action="${root }/j_spring_security_check" method="POST">
	
		<fieldset>
			<table>
				<c:if test="${not empty validate && not validate}">
				<tr>
					<td colspan="2" style="color:red;">유효하지 않는 아이디, 비밀번호 입니다.</td>
				</tr>
				</c:if>
				<tr>
					<th>아이디 :</th>
					<td><input name="j_username" type="text"/></td>
				</tr>
				<tr>
					<th>비밀번호 :</th>
					<td><input name="j_password" type="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="로그인"/></td>
				</tr>
			</table>
		</fieldset>
	</form>

</body>
</html>