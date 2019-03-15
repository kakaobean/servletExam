<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=name %>님 회원가입을 환영합니다.<br>
로그인후 서비스를 사용할 수 있습니다.<br>
<a href="/memberjsp/user/login.jsp">로그인</a>
</body>
</html>