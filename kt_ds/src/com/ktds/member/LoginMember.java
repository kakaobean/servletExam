package com.ktds.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginMember
 */
@WebServlet("/login")
public class LoginMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = null;
//		2. 1의 data 를 DB dp insert 
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
			
//			StringBuffer sb = new StringBuffer();
//			sb.append("select  name \\r\\n");
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(name != null) {
			out.println(name + "님 안년하세요.<br>");
		} else {
			out.println("아이디 또는 비밀번호 확인후 다시 로그인해주세요.<br>");
			out.println("<a href=\"/ktds/user/login.html\"</a>");   //  \"  는 따옴표다
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
