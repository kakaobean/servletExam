package com.ktds.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.member.model.MemberDetailDto;
import com.ktds.member.model.service.MemberServiceImpl;
import com.ktds.util.SiteConstance;


@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		
//		System.out.println(MemberServiceImpl.getMemberService());
//		System.out.println(MemberServiceImpl.getMemberService()); 싱글톤 확인 
		
		String path = "";
		if("mvjoin".equals(act)) {
			response.sendRedirect("/membermvc/user/member.jsp");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect("/membermvc/user/login.jsp");
		} else if("register".equals(act)) {
			
			MemberDetailDto memberDetailDto = new MemberDetailDto();
			memberDetailDto.setName(request.getParameter("name"));
			memberDetailDto.setId(request.getParameter("id"));
			memberDetailDto.setPass(request.getParameter("pass"));
			memberDetailDto.setEmailid(request.getParameter("emailid"));
			memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
			memberDetailDto.setZipcode(request.getParameter("zipcode"));
			memberDetailDto.setAddress(request.getParameter("address"));
			memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
			memberDetailDto.setTel1(request.getParameter("tel1"));
			memberDetailDto.setTel2(request.getParameter("tel2"));
			memberDetailDto.setTel3(request.getParameter("tel3"));
			
			int cnt = MemberServiceImpl.getMemberService().registerMember(memberDetailDto);
			
			if(cnt != 0) {
				request.setAttribute("userInfo", memberDetailDto);
				RequestDispatcher dispatcher = request.getRequestDispatcher("");  // 경로는 내 프로젝트 안이다  ( 프젝 밖을 못나감)
																				// 내프로젝트가 기본 설정 되있기 때문에 앞에 /membermvc 를 안붙인다
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("/membermvc/user/registerfail.jsp");   // 어디든 갈수 있고 location 이기 때문에 풀네임을적는다 --  때문에 앞에 /membermvc 를 안붙인다
			}
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SiteConstance.ENCODE);
		doGet(request, response);      // get으로 오던 post 로 오던  다 get (하나로 처리)
	}

}
