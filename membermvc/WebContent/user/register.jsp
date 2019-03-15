<%@ page language="java" contentType="text/html; charset=UTF-8" 
	import="java.sql.*, java.net.*"
    pageEncoding="UTF-8"%>
    <%
	String root = request.getContextPath();
%>
<!--     page language="java" contentType="text/html; charset=UTF-8" 사이에 공백이 없으면 에러난다 -->
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
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String emailid = request.getParameter("emailid");
String emaildomain = request.getParameter("emaildomain");
String zipcode = request.getParameter("zipcode");
String address = request.getParameter("address");
String addressDetail = request.getParameter("address_detail");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");

Connection conn = null;
PreparedStatement pstmt = null;
int cnt = 0;
try {
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.202.17:1521:orcl", "ktds", "ktds");  //프로토콜 , 아이디, 패스워드
	String sql = "insert all\r\n" + 
			"		into member (id, name, pass, emailid, emaildomain, joindate) \r\n" + 
			"		values (?, ?, ?, ?, ?, sysdate)\r\n" + 
			"		into member_detail(id, zipcode, address, address_detail, tel1, tel2, tel3)\r\n" + 
			"		 values (?, ?, ?, ?, ?, ?, ?)\r\n" + 
			"select * from dual";
	pstmt = conn.prepareStatement(sql);
	int idx = 1;
	pstmt.setString(idx++, id);
	pstmt.setString(idx++, name);
	pstmt.setString(idx++, pass);
	pstmt.setString(idx++, emailid);
	pstmt.setString(idx++, emaildomain);
	pstmt.setString(idx++, id);
	pstmt.setString(idx++, zipcode);
	pstmt.setString(idx++, address);
	pstmt.setString(idx++, addressDetail);
	pstmt.setString(idx++, tel1);
	pstmt.setString(idx++, tel2);
	pstmt.setString(idx++, tel3);
	
	cnt = pstmt.executeUpdate();
} catch (SQLException e) {
	e.printStackTrace();
} finally {
	try {
		if(pstmt != null)     // NullPointException 에러 처리  필수
			pstmt.close();
		if(conn != null)
			conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

if(cnt != 0){
	response.sendRedirect("/memberjsp/user/registerok.jsp?name=" + URLEncoder.encode(name,"UTF-8"));
} else {
	response.sendRedirect("/memberjsp/user/registerok.jsp");

}	
%>
