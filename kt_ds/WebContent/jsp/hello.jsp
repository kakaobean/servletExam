<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name;
	
	public void init(){
		name = "박영빈";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head> 
<body>
Hello JSP !!!!  <br>
안녕 <% out.println(name); %> <br>
안녕 <%= name %>
</body>
</html>