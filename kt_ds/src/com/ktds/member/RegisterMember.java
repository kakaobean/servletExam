package com.ktds.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. DATA GET
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
		
//		2. 1의 data 를 DB dp insert 
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
		
		
//		3. 2의 결과에 따른 page 생성.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(cnt != 0) {
			out.println(name + "님 회원가입을 환영합니다.<br>");
			out.println("로그인 후 모든 서비스를 사용 할 수 없습니다.<br>");
			out.println("<a href=\"/ktds/user/login.html\"</a>");   //  \"  는 따옴표다
		} else {
			out.println("<font color=\" color \" size = \" 15 \">");
			out.println("서버에 문제가 있습니다.<br>");
			out.println("다음기회에 가입해 주세요");
			out.println("</font>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}

}
