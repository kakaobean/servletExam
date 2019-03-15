<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.ktds.member.model.*"%>
    <%
	String root = request.getContextPath();
	
	MemberDetailDto dto = (MemberDetailDto)request.getAttribute("userInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=dto.getName()%>님 회원가입을 환영합니다.<br>
가입 하신 정보는 아래와 같습니다.
id : <%=dto.getId()%> <br>
email : <%=dto.getEmailid()%> @<%=dto.getEmaildomain()%>

로그인후 서비스를 사용할 수 있습니다.<br>
<a href="<%=root %>/user?act=mvlogin">로그인</a>
</body>
</html>