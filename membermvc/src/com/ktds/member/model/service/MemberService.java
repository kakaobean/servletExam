package com.ktds.member.model.service;

import java.util.List;

import com.ktds.member.model.*;

public interface MemberService {

	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int registerMember(MemberDetailDto memberDetailDto);
	
	MemberDto login(String id, String pass);
	
	List<MemberDetailDto> listMember();
	
}
