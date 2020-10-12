package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceImpl implements MemberServiceI {

	MemberDaoI memberDao = new MemberDaoImpl();
	
	@Override
	public MemberVO getMember(String userId) {
		
		
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVO> selectAllMember() {

//		MemberDaoI memberDao = new MemberDaoImpl();
		return memberDao.selectAllMember();
	}

}
