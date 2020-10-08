package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
		MemberDaoI memberDao = new MemberDaoImpl();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserId("brown");
		answerMemberVo.setPassword("passBrown");

		/***When : 행위 ***/
		MemberVO memberVo = memberDao.getMember(userId);

		/***Then : 결과 ***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}

}
