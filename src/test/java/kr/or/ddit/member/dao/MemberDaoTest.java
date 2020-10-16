package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVO;

public class MemberDaoTest {
	
//	private MemberDaoI memberDao;
//	
//	private void init() {
//		memberDao = new MemberDaoImpl();
//	}

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
		MemberDaoI memberDao = new MemberDaoImpl();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When : 행위 ***/
		MemberVO memberVo = memberDao.getMember(userId);

		/***Then : 결과 ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		// memberVo에 속성을 추가하였기 때문에 오류가 난다.
//		assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMember() {
		/***Given : 주어진 상황 기술 ***/
		MemberDaoI memberDao = new MemberDaoImpl();

		/***When : 행위 ***/
		List<MemberVO> memList = memberDao.selectAllMember();

		/***Then : 결과 ***/
//		assertNotNull(memList);
		assertEquals(15, memList.size()); // 약식 비교
	}
	
	@Test
	public void selectAllMemberPage() {
		/***Given : 주어진 상황 기술 ***/
		MemberDaoI memberDao = new MemberDaoImpl();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/***When : 행위 ***/
//		int page = 1;
		PageVO pv = new PageVO(1, 5);
		
		List<MemberVO> memList = memberDao.selectAllMemberPage(sqlSession, pv);
		
		/***Then : 결과 ***/
//		assertNotNull(memList);
		assertEquals(5, memList.size()); // 약식 비교
	}
	
	@Test
	public void selectMemberTotalCnt() {
		/***Given : 주어진 상황 기술 ***/
		MemberDaoI memberDao = new MemberDaoImpl();
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		/***When : 행위 ***/
		int memberTotalCnt = memberDao.selectMemberTotalCnt(sqlSession);
		
		/***Then : 결과 ***/
		assertEquals(15, memberTotalCnt);
	}

}
