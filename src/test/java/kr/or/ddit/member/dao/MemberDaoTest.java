package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;


public class MemberDaoTest extends ModelTestConfig{
	
	@Resource(name = "memberRepository")
	private MemberDaoI memberDao;
	
	
	@Test
	public void getMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/
		MemberVO memberVo = memberDao.getMember("brown");	
		
		/***Then : 결과 ***/
		assertEquals("brown", memberVo.getUserid());
		
	}

	@Test
	public void selectAllMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		
		/***When : 행위 ***/
		List<MemberVO> memberList = memberDao.selectAllMember();	
		
		/***Then : 결과 ***/
		assertTrue(memberList.size() > 15);
	}
	
	@Test
	public void selectAllMemberPageTest() {
		/***Given : 주어진 상황 기술 ***/
		
		
		/***When : 행위 ***/
		List<MemberVO> memberList = memberDao.selectAllMemberPage(new PageVO(1,5));
		
		/***Then : 결과 ***/
		assertEquals(5, memberList.size());
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given : 주어진 상황 기술 ***/
		
		
		/***When : 행위 ***/
		int memberCnt = memberDao.selectMemberTotalCnt();
		
		/***Then : 결과 ***/
		assertEquals(23, memberCnt);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", 
				"개발원", "대전광역시", "중구청", "12345", "", "");
		
		/***When : 행위 ***/
		int insertCnt = memberDao.insertMember(memberVo);
		
		/***Then : 결과 ***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void deleteMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", 
				"개발원", "대전광역시", "중구청", "12345", "", "");
		
		/***When : 행위 ***/
		memberDao.insertMember(memberVo);
		int deleteCnt = memberDao.deleteMember("temp");
		
		/***Then : 결과 ***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", 
				"개발원", "대전광역시", "중구청", "12345", "", "");
		
		MemberVO memberVo_re = new MemberVO("temp", "dditpass", "대덕_수정", 
				"개발원", "대전광역시", "중구청", "12345", "", "");
		
		/***When : 행위 ***/
		memberDao.insertMember(memberVo);
		int updateCnt = memberDao.updateMember(memberVo_re);
		
		/***Then : 결과 ***/
		assertEquals(1, updateCnt);
		
	}
	
}
