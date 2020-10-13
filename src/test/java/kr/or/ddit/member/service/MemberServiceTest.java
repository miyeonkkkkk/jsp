package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	
	private MemberServiceI memberService;
	
	private void init() {
		memberService = MemberServiceImpl.getService();
	}

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
//		MemberServiceI memberService = new MemberServiceImpl();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When : 행위 ***/
		MemberVO memberVo = memberService.getMember(userId);

		/***Then : 결과 ***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}

}
