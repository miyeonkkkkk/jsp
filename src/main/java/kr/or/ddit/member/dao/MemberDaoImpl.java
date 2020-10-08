package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoImpl implements MemberDaoI {

	@Override
	public MemberVO getMember(String userId) {
		// 원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		// controller 기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		//						  Mock 객체(가짜객체)
		
		MemberVO memberVo = new MemberVO();
		memberVo.setUserId("brown");
		memberVo.setPassword("passBrown");
		
		return memberVo;
	}

}
