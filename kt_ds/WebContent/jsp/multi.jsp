<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String fruit[] = request.getParameterValues("fruit");
%>	
<%= name %>(<%=id %>)님이 좋아하는 과일은
<% 
if(fruit != null){
int len = fruit.length;
for(int i = 0; i<len; i++){
%><%= fruit[i] %><%
if(i != len-1){
%>, <%
	}
} 
%>입니다.
<%} else {
%>
없습니다.
<% 
}
%>
</body>
</html>