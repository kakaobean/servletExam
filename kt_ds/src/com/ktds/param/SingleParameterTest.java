package com.ktds.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/single")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 1. data get ( id, name, age)
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
//		 2. 1의 data를 이용하여 logic
//		 	나이가 10대면 아이디를 붉은색
//		 	20대면 아이디를 푸른색
		String color = "cyan";
		if(age == 10) {
			color = "pink";
		}
//		 3. 응답 페이지 
//		    박영빈(kakaobean)님 안녕하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(name+"(<font color= \" " + color + " \"  >" + id+"</font>)" +"님 안녕");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 1. data get ( id, name, age)
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
//		byte b[] = name.getBytes("ISO-8859-1");
//		name = new String(b, "utf-8");
//		 2. 1의 data를 이용하여 logic
//		 	나이가 10대면 아이디를 붉은색
//		 	20대면 아이디를 푸른색
		String color = "cyan";
		if(age == 10) {
			color = "pink";
		}
//		 3. 응답 페이지 
//		    박영빈(kakaobean)님 안녕하세요.
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(name+"(<font color= \" " + color + " \"  >" + id+"</font>)" +"님 안녕");
		out.println("</body>");
		out.println("</html>");
		
	}

}
