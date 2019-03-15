<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*, java.net.*"
    pageEncoding="UTF-8"%>
<%!
public void init() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}
%>
<%
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = null;
//2. 1의 data 를 DB dp insert 
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.202.17:1521:orcl", "ktds", "ktds"); //프로토콜 , 아이디, 패스워드
	String sql = "select  name \r\n" + 
			"from 	member\r\n" + 
			"where id = ? and pass = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, pass);
	
	rs = pstmt.executeQuery();
	if(rs.next()) {
		name = rs.getString("name");
	}
	
//	StringBuffer sb = new StringBuffer();
//	sb.append("select  name \\r\\n");
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if(rs != null)     
			rs.close();
		if(pstmt != null)     // NullPointException 에러 처리  필수
			pstmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}  
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(name != null){
	response.sendRedirect("/memberjsp/user/loginok.jsp?name=" + URLEncoder.encode(name,"UTF-8"));
%>
<%} else {%>
<%
response.sendRedirect("/memberjsp/user/loginfail.jsp");
}
%>
</body>
</html>