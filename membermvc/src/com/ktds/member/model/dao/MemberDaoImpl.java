package com.ktds.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ktds.member.model.*;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;

	static {
		memberDao = new MemberDaoImpl();
	}

	private MemberDaoImpl() {
	}

	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		return null;
	}

	@Override
	public int registerMember(MemberDetailDto memberDetailDto) {
		int cnt = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.202.17:1521:orcl", "ktds", "ktds"); // 프로토콜 ,
																												// 아이디,
																												// 패스워드
			String sql = "insert all\r\n" + "		into member (id, name, pass, emailid, emaildomain, joindate) \r\n"
					+ "		values (?, ?, ?, ?, ?, sysdate)\r\n"
					+ "		into member_detail(id, zipcode, address, address_detail, tel1, tel2, tel3)\r\n"
					+ "		 values (?, ?, ?, ?, ?, ?, ?)\r\n" + "select * from dual";
			pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getName());
			pstmt.setString(idx++, memberDetailDto.getPass());
			pstmt.setString(idx++, memberDetailDto.getEmailid());
			pstmt.setString(idx++, memberDetailDto.getEmaildomain());
			pstmt.setString(idx++, memberDetailDto.getId());
			pstmt.setString(idx++, memberDetailDto.getZipcode());
			pstmt.setString(idx++, memberDetailDto.getAddress());
			pstmt.setString(idx++, memberDetailDto.getAddressDetail());
			pstmt.setString(idx++, memberDetailDto.getTel1());
			pstmt.setString(idx++, memberDetailDto.getTel2());
			pstmt.setString(idx++, memberDetailDto.getTel3());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) // NullPointException 에러 처리 필수
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		return null;
	}

	@Override
	public List<MemberDetailDto> listMember() {
		return null;
	}

}
