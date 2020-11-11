package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;

import kr.or.ddit.ModelTestConfig;
import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.member.model.MemberVO;

public class MemberServiceTest extends ModelTestConfig {

	@Resource(name = "memberService")
	private MemberServiceI memberService;

//	@Before
//	public void setUp() {
//		memberService.deleteMember("ddit");
//	}

	@Test
	public void insertMember_SUCCESS_Test() {
		/*** Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", "개발원", "대전광역시", "중구청", "12345", "", "");

		/*** When : 행위 ***/
		int insertCnt = memberService.insertMember(memberVo);

		/*** Then : 결과 ***/
		assertEquals(1, insertCnt);
	}

	@Ignore
	@Test
	public void insertMember_FAIL_Test() {
		/*** Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("ddit", "dditpass", "대덕", "개발원", "대전광역시", "중구청", "12345", "", "");

		/*** When : 행위 ***/
		int insertCnt = memberService.insertMember(memberVo);

		/*** Then : 결과 ***/
		assertEquals(1, insertCnt);
	}

	@Test
	public void getMemberTest() {
		/*** Given : 주어진 상황 기술 ***/

		/*** When : 행위 ***/
		MemberVO memberVo = memberService.getMember("brown");

		/*** Then : 결과 ***/
		assertEquals("brown", memberVo.getUserid());

	}

	@Test
	public void selectAllMemberTest() {
		/*** Given : 주어진 상황 기술 ***/

		/*** When : 행위 ***/
		List<MemberVO> memberList = memberService.selectAllMember();

		/*** Then : 결과 ***/
		assertTrue(memberList.size() > 15);
	}

	@Test
	public void selectAllMemberPageTest() {
		/*** Given : 주어진 상황 기술 ***/

		/*** When : 행위 ***/
		Map<String, Object> memberMap = memberService.selectAllMemberPage(new PageVO(1, 5));

		/*** Then : 결과 ***/
		assertEquals(5, ((List<MemberVO>)memberMap.get("memberList")).size());
		assertEquals(23, memberMap.get("totalCnt"));
	}


	@Test
	public void deleteMemberTest() {
		/*** Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", "개발원", "대전광역시", "중구청", "12345", "", "");

		/*** When : 행위 ***/
		memberService.insertMember(memberVo);
		int deleteCnt = memberService.deleteMember("temp");

		/*** Then : 결과 ***/
		assertEquals(1, deleteCnt);
	}

	@Test
	public void updateMemberTest() {
		/*** Given : 주어진 상황 기술 ***/
		MemberVO memberVo = new MemberVO("temp", "dditpass", "대덕", "개발원", "대전광역시", "중구청", "12345", "", "");

		MemberVO memberVo_re = new MemberVO("temp", "dditpass", "대덕_수정", "개발원", "대전광역시", "중구청", "12345", "", "");

		/*** When : 행위 ***/
		memberService.insertMember(memberVo);
		int updateCnt = memberService.updateMember(memberVo_re);

		/*** Then : 결과 ***/
		assertEquals(1, updateCnt);

	}

}
