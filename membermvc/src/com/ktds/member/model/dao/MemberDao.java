package com.ktds.member.model.dao;

import java.util.List;
import java.util.Map;

import com.ktds.member.model.*;

public interface MemberDao {

	int idCheck(String id);
	List<ZipCodeDto> zipSearch(String doro);
	int registerMember(MemberDetailDto memberDetailDto);
	
	MemberDto login(Map<String, String> map);
	
	List<MemberDetailDto> listMember();
	
}
