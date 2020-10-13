package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	
	private MemberDaoI memberDao;
	
	private void init() {
		memberDao = MemberDaoImpl.getDao();
	}

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When : 행위 ***/
		MemberVO memberVo = memberDao.getMember(userId);

		/***Then : 결과 ***/
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());
		
		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMember() {
		/***Given : 주어진 상황 기술 ***/
//		MemberDaoI memberDao = new MemberDaoImpl();

		/***When : 행위 ***/
		List<MemberVO> memList = memberDao.selectAllMember();

		/***Then : 결과 ***/
//		assertNotNull(memList);
		assertEquals(5, memList.size()); // 약식 비교
	}

}
