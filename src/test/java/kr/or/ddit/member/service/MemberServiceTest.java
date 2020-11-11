package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig{

	@Resource(name = "memberService")
	private MemberServiceI memberService;
	
	@Before
	public void setUp() {
		memberService.deleteMember("ddit");
	}
	
	@Test
	public void insertMember_SUCCESS_Test() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕", 
								"개발원", "대전광역시", "중구청", "12345", "", "");
		
		/***When : 행위 ***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then : 결과 ***/
		assertEquals(1, insertCnt);
	}
	
	//@Test
	public void insertMember_FAIL_Test() {
		/***Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕", 
				"개발원", "대전광역시", "중구청", "12345", "", "");
		
		/***When : 행위 ***/
		int insertCnt = memberService.insertMember(memberVo);
		
		/***Then : 결과 ***/
		assertEquals(1, insertCnt);
	}

}
