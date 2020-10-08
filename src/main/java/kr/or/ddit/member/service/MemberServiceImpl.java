package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceImpl implements MemberServiceI {

	@Override
	public MemberVO getMember(String userId) {
		
		MemberDaoI memberDao = new MemberDaoImpl();
		
		return memberDao.getMember(userId);
	}

}
