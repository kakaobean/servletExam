package com.ktds.member.model.service;

import java.util.List;

import com.ktds.member.model.MemberDetailDto;
import com.ktds.member.model.MemberDto;
import com.ktds.member.model.ZipCodeDto;
import com.ktds.member.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private static MemberService memberService;
	
	static {
		memberService = new MemberServiceImpl();
	}
	// 싱글톤 패턴이라고 한다
	private MemberServiceImpl() {
		
	}
	
	public static MemberService getMemberService() {
		return memberService;
	}


	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		// TODO Auto-generated method stub
		return MemberDaoImpl.getMemberDao().registerMember(memberDetailDto);
	}

	@Override
	public MemberDto login(String id, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDetailDto> listMember() {
		// TODO Auto-generated method stub
		return null;
	}

}
