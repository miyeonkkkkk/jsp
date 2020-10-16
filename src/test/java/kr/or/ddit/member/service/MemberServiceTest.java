package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest {
	
//	private MemberServiceI memberService;
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	private void init() {
//		memberService = new MemberServiceImpl();
	}

	@Test
	public void getMemberTest() {
		
		/***Given : 주어진 상황 기술 ***/
		MemberServiceI memberService = new MemberServiceImpl();
		String userId = "brown";
		
		MemberVO answerMemberVo = new MemberVO();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When : 행위 ***/
		MemberVO memberVo = memberService.getMember(userId);

		/***Then : 결과 ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo, memberVo);
	}
	
	@Test
	public void selectAllMemberPage() {
		/***Given : 주어진 상황 기술 ***/
		MemberServiceI memberService = new MemberServiceImpl();
		
		/***When : 행위 ***/
//		int page = 1;
		
		PageVO pv = new PageVO(1, 5);
		
		logger.debug("{}",pv.getPage());
		
		Map<String, Object> map = memberService.selectAllMemberPage(pv);
		List<MemberVO> memList = (List<MemberVO>)map.get("memberList");
		
		// 생성해야할 page 수
		// alt + shift + r 하면 같은 변수 선택이 가능하다.87
		//int pages = (int)map.get("pages");
		
		/***Then : 결과 ***/
//		assertNotNull(memList);
//		assertEquals(5, memList.size()); // 약식 비교
//		assertEquals(3, pv.getPageSize()); // 약식 비교
		
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		
		for(Locale locale : locales) {
			logger.debug(locale.toString());
		}
	}
	
	
	


}
